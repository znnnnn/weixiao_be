package com.miaoroom.weixiao.utils.SMSVerification;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.dysmsapi.transform.v20170525.SendSmsResponseUnmarshaller;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.FormatType;
import com.aliyuncs.http.HttpResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.miaoroom.weixiao.enums.ValidateCodeEnum;
import com.miaoroom.weixiao.vo.CodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Component
public class SMSUtil {

    //产品名称:云通信短信API产品,开发者无需替换
    private static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    private static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    private static final String accessKeyId = "LTAICq734h6sfksn";
    private static final String accessKeySecret = "U6zDeG1DcTb4I13JXbNOBGuA8ItUuv";


    public SendSmsResponse sendSms(String mobile, String template_code, String sign_name, String param) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");


        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);      //你要发送的手机号
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(sign_name);     //必须是你自己的已经审核通过的签名
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(template_code);   //模板CODE
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(param);

        //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");

        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
//        request.setOutId("yourOutId");

        //hint 此处可能会抛出异常，注意catch

        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            System.out.println("短信接口返回的数据----------------");
            System.out.println("Code=" + sendSmsResponse.getCode());
            System.out.println("Message=" + sendSmsResponse.getMessage());
            System.out.println("RequestId=" + sendSmsResponse.getRequestId());
            System.out.println("BizId=" + sendSmsResponse.getBizId());
            return sendSmsResponse;
        } catch (ServerException e) {
            e.printStackTrace();
            return null;
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }
    }


    public QuerySendDetailsResponse querySendDetails(String mobile, String bizId) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");


        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(mobile);
        //可选-流水号
        request.setBizId(bizId);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);

        //hint 此处可能会抛出异常，注意catch
        try {
            QuerySendDetailsResponse querySendDetailsResponse = acsClient.getAcsResponse(request);
            System.out.println(querySendDetailsResponse);
            return querySendDetailsResponse;
        } catch (ServerException e) {
            e.printStackTrace();
            return null;
        } catch (ClientException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static final char[] chars="123456789".toCharArray();
    private static Random random = new Random();
    public String getRandomCode() {
        StringBuffer buffer = new StringBuffer();
        int index;   //获取随机chars下标
        for(int i=0;i<4;i++){
            index = random.nextInt(chars.length);  //获取随机chars下标
            buffer.append(chars[index]);
        }
        return buffer.toString();
    }

    /**
     * 根据手机号和用户操作的动作，进行发送短信
     * 该记录应该在调用处存入Map
     * @param phone
     * @param action
     * @return 手机号和验证码对应的记录
     * @throws ClientException
     */
    public CodeInfo sendSMS2codeInfo(String phone, String action) throws ClientException {
        String code = getRandomCode();
//        生成手机号和code对应关系
        CodeInfo codeInfo = new CodeInfo(phone, code, action, new Date());
        if (!phone.equals("")) {
            SendSmsResponse sendSmsResponse = sendSms(phone, "SMS_160306918", "微校", "{\"name\":\"Tom\", \"code\":" + code + "}");
        }
        return codeInfo;
//        codeInfoMap.put(phone, codeInfo);
    }


    /**
     * 判断验证码是否正确
     * @param phone
     * @param code
     * @return
     * @throws ClientException
     */
    public ValidateCodeEnum validateCode(String phone, String code, Map<String, CodeInfo> codeInfoMap){
        Date now = new Date();
        if (codeInfoMap.containsKey(phone)) {
            CodeInfo codeInfo = codeInfoMap.get(phone);
            if (codeInfo.isCodeIn5Min(now)) {
                System.out.println("传入的验证码为"+code);
                System.out.println("记录的验证码为"+codeInfo.getCode());
                return code.equals(codeInfo.getCode()) ? ValidateCodeEnum.SUCCESS : ValidateCodeEnum.FAIL;
            }
        } else {
            return ValidateCodeEnum.FAIL;
        }
        return ValidateCodeEnum.TIMEOUT;
    }
}