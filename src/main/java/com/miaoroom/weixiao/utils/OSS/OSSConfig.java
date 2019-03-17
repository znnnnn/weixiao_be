package com.miaoroom.weixiao.utils.OSS;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Getter
@Component
public class OSSConfig {

    private String bucketUrl = "https://oss-miaoroom.oss-cn-shanghai.aliyuncs.com";        //原图片服务器地址
    private String baseUrl = "https://oss.miaoroom.com";        //自定义解析后的图片服务器地址
    private String endpoint = "https://oss-cn-shanghai.aliyuncs.com";        //连接区域地址
    private String accessKeyId = "LTAICq734h6sfksn";    //连接keyId
    private String accessKeySecret = "U6zDeG1DcTb4I13JXbNOBGuA8ItUuv";    //连接秘钥
    private String bucketName = "oss-miaoroom";    //需要存储的bucketName
    private String picLocation = "weixiao/";    //图片保存路径
}