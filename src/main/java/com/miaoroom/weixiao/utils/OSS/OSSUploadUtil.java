package com.miaoroom.weixiao.utils.OSS;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.*;
import com.miaoroom.weixiao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OSSUploadUtil {

    private static OSSConfig config = new OSSConfig();

    /**
     * @param file
     * @param fileType 文件后缀
     * @return String 文件地址
     * @MethodName: uploadFile
     * @Description: OSS单文件上传
     */
    public static String uploadFile(File file, String fileType) {
//        config = config == null ? new OSSConfig() : config;
        //通过UUID生成文件名

        String fileName = config.getPicLocation()
                + UUID.randomUUID().toString().toUpperCase()
                .replace("-", "")
                + "." + fileType;
        return putFile(file, fileType, fileName);
    }

    /**
     * @param file
     * @param fileType
     * @param oldUrl
     * @return String
     * @MethodName: updateFile
     * @Description: 更新文件:只更新内容，不更新文件名和文件地址。
     * (因为地址没变，可能存在浏览器原数据缓存，不能及时加载新数据，例如图片更新，请注意)
     */
    public static String updateFile(File file, String fileType, String oldUrl) {
        String fileName = getFileName(oldUrl);
        if (fileName == null) return null;
        return putFile(file, fileType, fileName);
    }

    /**
     * @param file
     * @param fileType 文件后缀
     * @param oldUrl   需要删除的文件地址
     * @return String 文件地址
     * @MethodName: replaceFile
     * @Description: 替换文件:删除原文件并上传新文件，文件名和地址同时替换
     * 解决原数据缓存问题，只要更新了地址，就能重新加载数据)
     */
    public static String replaceFile(File file, String fileType, String oldUrl) {
        boolean flag = deleteFile(oldUrl);        //先删除原文件
        if (!flag) {
            //更改文件的过期时间，让他到期自动删除。
        }
        return uploadFile(file, fileType);
    }

    /**
     * @param fileUrl 需要删除的文件url
     * @return boolean 是否删除成功
     * @MethodName: deleteFile
     * @Description: 单文件删除
     */
    public static boolean deleteFile(String fileUrl) {
        config = config == null ? new OSSConfig() : config;

        String bucketName = OSSUploadUtil.getBucketName(fileUrl);        //根据url获取bucketName
        String fileName = OSSUploadUtil.getFileName(fileUrl);            //根据url获取fileName
        if (bucketName == null || fileName == null) return false;
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
            GenericRequest request = new DeleteObjectsRequest(bucketName).withKey(fileName);
            ossClient.deleteObject(request);
        } catch (Exception oe) {
            oe.printStackTrace();
            return false;
        } finally {
            ossClient.shutdown();
        }
        return true;
    }

    /**
     * @param fileUrls 需要删除的文件url集合
     * @return int 成功删除的个数
     * @MethodName: batchDeleteFiles
     * @Description: 批量文件删除(较快)：适用于相同endPoint和BucketName
     */
    public static int deleteFile(List<String> fileUrls) {
        int deleteCount = 0;    //成功删除的个数
        String bucketName = OSSUploadUtil.getBucketName(fileUrls.get(0));        //根据url获取bucketName
        List<String> fileNames = OSSUploadUtil.getFileName(fileUrls);            //根据url获取fileName
        if (bucketName == null || fileNames.size() <= 0) return 0;
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
            DeleteObjectsRequest request = new DeleteObjectsRequest(bucketName).withKeys(fileNames);
            DeleteObjectsResult result = ossClient.deleteObjects(request);
            deleteCount = result.getDeletedObjects().size();
        } catch (OSSException oe) {
            oe.printStackTrace();
            throw new RuntimeException("OSS服务异常:", oe);
        } catch (ClientException ce) {
            ce.printStackTrace();
            throw new RuntimeException("OSS客户端异常:", ce);
        } finally {
            ossClient.shutdown();
        }
        return deleteCount;

    }

    /**
     * @param fileUrls 需要删除的文件url集合
     * @return int 成功删除的个数
     * @MethodName: batchDeleteFiles
     * @Description: 批量文件删除(较慢)：适用于不同endPoint和BucketName
     */
    public static int deleteFiles(List<String> fileUrls) {
        int count = 0;
        for (String url : fileUrls) {
            if (deleteFile(url)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param file
     * @param fileType
     * @param fileName
     * @return String
     * @MethodName: putFile
     * @Description: 上传文件
     */
    private static String putFile(File file, String fileType, String fileName) {
        config = config == null ? new OSSConfig() : config;
        String url = null;        //默认null
        OSSClient ossClient = null;
        try {
            ossClient = new OSSClient(config.getEndpoint(), config.getAccessKeyId(), config.getAccessKeySecret());
            InputStream input = new FileInputStream(file);
            ObjectMetadata meta = new ObjectMetadata();                // 创建上传Object的Metadata
            meta.setContentType(OSSUploadUtil.contentType(fileType));        // 设置上传内容类型
            meta.setCacheControl("no-cache");                    // 被下载时网页的缓存行为
            PutObjectRequest request = new PutObjectRequest(config.getBucketName(), fileName, input, meta);            //创建上传请求
            ossClient.putObject(request);
            Date expiration = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10); // 设置URL过期时间为10年  3600L* 1000*24*365*10
            //上传成功再返回的文件路径
            url = ossClient.generatePresignedUrl(config.getBucketName(), fileName, expiration)
                    .toString()
                    .replaceFirst(config.getBucketUrl(), config.getBaseUrl());
        } catch (OSSException | FileNotFoundException | ClientException oe) {
            oe.printStackTrace();
            return null;
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }

    /**
     * @param fileType
     * @return String
     * @MethodName: contentType
     * @Description: 获取文件类型
     */
    private static String contentType(String fileType) {
        fileType = fileType.toLowerCase();
        String contentType = "";
        switch (fileType) {
            case "bmp":
                contentType = "image/bmp";
                break;
            case "gif":
                contentType = "image/gif";
                break;
            case "png":
            case "jpeg":
            case "jpg":
                contentType = "image/jpeg";
                break;
            case "html":
                contentType = "text/html";
                break;
            case "txt":
                contentType = "text/plain";
                break;
            case "vsd":
                contentType = "application/vnd.visio";
                break;
            case "ppt":
            case "pptx":
                contentType = "application/vnd.ms-powerpoint";
                break;
            case "doc":
            case "docx":
                contentType = "application/msword";
                break;
            case "xml":
                contentType = "text/xml";
                break;
            case "mp4":
                contentType = "video/mp4";
                break;
            default:
                contentType = "application/octet-stream";
                break;
        }
        return contentType;
    }

    /**
     * @param fileUrl 文件url
     * @return String bucketName
     * @MethodName: getBucketName
     * @Description: 根据url获取bucketName
     */
    private static String getBucketName(String fileUrl) {
        String http = "http://";
        String https = "https://";
        int httpIndex = fileUrl.indexOf(http);
        int httpsIndex = fileUrl.indexOf(https);
        int startIndex = 0;
        if (httpIndex == -1) {
            if (httpsIndex == -1) {
                return null;
            } else {
                startIndex = httpsIndex + https.length();
            }
        } else {
            startIndex = httpIndex + http.length();
        }
        int endIndex = fileUrl.indexOf(".oss-");
        return fileUrl.substring(startIndex, endIndex);
    }

    /**
     * @param fileUrl 文件url
     * @return String fileName
     * @MethodName: getFileName
     * @Description: 根据url获取fileName
     */
    private static String getFileName(String fileUrl) {
        String str = "aliyuncs.com/";
        int beginIndex = fileUrl.indexOf(str);
        if (beginIndex == -1) return null;
        return fileUrl.substring(beginIndex + str.length());
    }

    /**
     * @param fileUrls 文件url
     * @return List<String>  fileName集合
     * @MethodName: getFileName
     * @Description: 根据url获取fileNames集合
     */
    private static List<String> getFileName(List<String> fileUrls) {
        List<String> names = new ArrayList<>();
        for (String url : fileUrls) {
            names.add(getFileName(url));
        }
        return names;
    }

}


