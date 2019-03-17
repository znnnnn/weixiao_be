package com.miaoroom.weixiao.vo;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.miaoroom.weixiao.utils.SMSVerification.SMSUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 手机号 、code、日期关系记录
 */

@Data
public class CodeInfo {
    private String phone;
    private String code;
    private String action;
    private Date date;

    public CodeInfo(String phone, String code, String action, Date date) {
        this.phone = phone;
        this.code = code;
        this.action = action;
        this.date = date;
    }

    public boolean isCodeIn5Min(Date generateCodeTime) {
//        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-M-d HH:mm:ss"); 
//        java.util.Date start = sdf.parse(date1);
        java.util.Date end = new Date();

        long cha = end.getTime() - generateCodeTime.getTime();

        // TODO 验证码五分钟之内的bug
        System.out.println(end.getTime());
        System.out.println(generateCodeTime.getTime());
        System.out.println("是否在5分钟内");
        System.out.println(cha<1);
        return cha < 1;
    }

    @Autowired
    SMSUtil smsUtil;
}
