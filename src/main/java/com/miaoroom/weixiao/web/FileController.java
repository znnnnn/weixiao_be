package com.miaoroom.weixiao.web;

import com.miaoroom.weixiao.core.Result;
import com.miaoroom.weixiao.core.ResultCode;
import com.miaoroom.weixiao.core.ResultGenerator;
import com.miaoroom.weixiao.utils.MultipartFile2File;
import com.miaoroom.weixiao.utils.OSS.OSSUploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Slf4j
@RestController
public class FileController {

    /**
     * 提取上传方法为公共方法
     */
    private String executeUpload(String uploadDir, MultipartFile file) throws IOException {
        if (file == null || file.isEmpty() || file.getSize() == 0) {
//            return ResultUtils.error(ResultCode.UPLOAD_FILE_EMPTY);
            System.out.println("空文件");
        }
        assert file != null;
        if (file.getSize() > 10 * 1024 * 1024) {
//            return ResultUtils.error(ResultCode.UPLOAD_FILE_LIMIT);
            System.out.println("文件过大");
        }

        Map<String, String> map = new HashMap<>();
        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        //OSS单文件上传,返回上传成功后的oss存储服务器中的url
        String fileName = OSSUploadUtil.uploadFile(MultipartFile2File.convert(file), fileType);
        System.out.println("OSS中的url为："+fileName);
        map.put(file.getName(), fileName);
        return fileName;
    }

    /**
     * 单个文件上传
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public Result upload(HttpServletRequest request, MultipartFile file) {
        try {
            // 上传目录地址(相对路径)
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            // 上传目录地址(绝对路径)
//            String uploadDir = "f:/test/";
//            // 输出地址 - 测试
//            System.out.println(uploadDir);
            File dir = new File(uploadDir);
            // 如果目录不存在，自动创建文件夹
            if (!dir.exists()) {
                dir.mkdir();
            }
            //调用上传方法
            String ossUrl = executeUpload(uploadDir, file);
            return ResultGenerator.genSuccessResult(ossUrl);
        } catch (Exception e) {
            // 打印错误堆栈信息
            e.printStackTrace();
            return ResultGenerator.genFailResult("上传失败");
        }

    }

    /**
     * 多个文件上传
     */
    @PostMapping(value = "/uploads")
    @ResponseBody
    public Result uploads(HttpServletRequest request, MultipartFile[] files) {
        try {
            // 上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            // 输出地址 - 测试
//            System.out.println(uploadDir);
            System.out.println("共" + files.length + "个文件");
            File dir = new File(uploadDir);
            // 如果目录不存在，自动创建文件夹
            if (!dir.exists()) {
                dir.mkdir();
            }
            // 遍历文件数组执行上传
            for (int i = 0; i < files.length; i++) {
                if (files[i] != null) {
                    // 调用上传方法
                    executeUpload(uploadDir, files[i]);
                }
            }
        } catch (Exception e) {
            // 打印错误堆栈信息
            e.printStackTrace();
            return ResultGenerator.genFailResult("上传失败");
        }
        return ResultGenerator.genSuccessResult("上传成功");
    }

    /**
     * 下载文件
     */
    @GetMapping(value = "/downloadFile")
    public void downloadFile(HttpServletResponse response) throws IOException {
        // 文件所在的路径
        File file = new File("f:/test/2.jpg");
        // 使用response 获取字节输出
        OutputStream outputStream = response.getOutputStream();
        // 进行文件下载
        response.setContentType("application/x-download");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(("下载名称").getBytes("gbk"), "iso8859-1") + ".jpg");
        // outputStream 写入到输出流
        outputStream.write(FileCopyUtils.copyToByteArray(file));
        // 刷新流
        outputStream.flush();
        // 关闭流
        outputStream.close();
    }
}
