package com.iwuhu.service.impl;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iwuhu.dto.EventActivateRecord;
import com.iwuhu.dto.EventActivateRecordFactor;
import com.iwuhu.service.PushDingService;
import com.sun.javafx.collections.ElementObservableListDecorator;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Yuxilai
 * @Date: 2022/6/16 - 14:53
 * @Description: com.iwuhu.service.impl
 * @Version: 1.0
 */
@Service
@Slf4j
public class PushDingServiceImpl implements PushDingService {
    private String signOne = "秘钥地址";
    private String workHook = "机器人的url";

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public String pushDing() {
        //标签
        Boolean flag = false;
        //获取加密后的秘钥
        String sign = null;
        try {
            sign = getSign(signOne);
        } catch (Exception e) {
            log.info("getSign 失败:{}", e.getMessage(), e);
            e.printStackTrace();
        }

        //这边请求的url
        String url = workHook;
        url = url + sign;
        log.info("url:{}", url);

        //创建sdk 请求类
        DingTalkClient client = new DefaultDingTalkClient(url);
        //创建请求体
        OapiRobotSendRequest request = new OapiRobotSendRequest();
        //设置请求类型
        request.setMsgtype("text");
        OapiRobotSendRequest.Text text = new OapiRobotSendRequest.Text();
        //设置文本内容
        text.setContent(getText());
        request.setText(text);
        OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
        // isAtAll类型如果不为Boolean，请升级至最新SDK
        //默认通知所有人

        //如果等于0 就是通知所有人员
        /*if (eventTargetDTO.getInformTheWay() == 0) {
            flag = true;
        }
        if (!flag) {
            at.setAtMobiles(eventTargetDTO.getInformThePhone().size() == 0 ? Collections.emptyList() :eventTargetDTO.getInformThePhone());
        }*/
        at.setAtMobiles(Arrays.asList("15055770181","17639711011"));
        at.setIsAtAll(flag);
        request.setAt(at);

        OapiRobotSendResponse response = null;
        try {
            response = client.execute(request);
        } catch (ApiException e) {
            log.info("pushDing 失败:{}", e.getMessage(), e);
            e.printStackTrace();
        }
        log.info("pushDingDing response:{}", response);
        return "123";
    }


    private String getText() {

        EventActivateRecordFactor eventActivateRecordFactor = new EventActivateRecordFactor();
        eventActivateRecordFactor.setExpressionKeyName("阿珍爱阿强");
        eventActivateRecordFactor.setFactorId(999);
        Map<String, Object> map = new HashMap<>();
        map.put("1", "2");
        eventActivateRecordFactor.setRunResult(map);
        eventActivateRecordFactor.setRunTime(new Date());


        EventActivateRecord contentText = EventActivateRecord.builder()
                .eventId(110)
                .activateDateTime(new Date())
                .activateTimestamp(System.currentTimeMillis())
                .orgHierarchyCode("123321")
                .factorList(Arrays.asList(eventActivateRecordFactor))
                .domainId("1234")
                .eventExpression("1234")
                .build();
        String s = "";


        //组装调用钉钉机器人的文本参数
        StringBuilder text = new StringBuilder();
        text.append("事件报警通知如下:\n");
        text.append("事件id:"+contentText.getEventId());
        text.append("\n");
        text.append("事件名称:"+"测试组装字符串");
        text.append("\n");
        text.append("域id:"+contentText.getEventId());
        text.append("\n");
        text.append("企业代码:"+contentText.getEventId());
        text.append("\n");
        text.append("事件触发时间:"+sdf.format(new Date()));
        text.append("\n");
        text.append("详细数据请进入系统查看。");


        return text.toString();
    }

    public String getSign(String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        //https://oapi.dingtalk.com/robot/send?access_token=XXXXXX&timestamp=XXX&sign=XXX
        String signUrl = "&timestamp=" + timestamp + "&sign=" + sign;
        return signUrl;
    }

}
