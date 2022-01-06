package com.iwuhu.controller;

import com.iwuhu.MyApplicaiton;
import com.iwuhu.exception.Response;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Auther: Yuxilai
 * @Date: 2022/1/6 - 10:12
 * @Description: com.iwuhu.controller
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplicaiton.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

    @Test
    public void studentList() {
       /*Map<String,Object> map = new HashMap<>();
        map.put("accessToken","dsafkldfhsakjewnbfsdafkakl");
        map.put("ssoId","T23429382");

        HttpHeaders httpHeaders = restTemplate.headForHeaders(this.base.toString() + "/student/list", map);

        ResponseEntity<Response> response = this.restTemplate.getForEntity(
                this.base.toString() + "/student/list", Response.class, "");
        System.out.println(String.format("测试结果为：%s", response.getBody()));*/

        /*ResponseEntity<Response> response = this.restTemplate.getForEntity(
                this.base.toString() + "/student/list", Response.class, "");
        System.out.println(String.format("测试结果为：%s", response.getBody()));*/


        //声明一个header变量
        HttpHeaders headers = new HttpHeaders();

        // 设置 user-agent
        // headers.set("user-agent","");
        //设置token和ssoId
        headers.set("accessToken","dsafkldfhsakjewnbfsdafkakl");
        headers.set("ssoId","T23429382");
        //设置为异步请求
        // headers.set("X-Requested-With","XMLHttpRequest");

        //创建请求的header实体
        HttpEntity entity = new HttpEntity(headers);

        //ResponseEntity封装了返回的数据，包括request，body，header等
        ResponseEntity<String> jsonObject =
                this.restTemplate.exchange(this.base.toString() + "student/list", HttpMethod.GET, entity, String.class);

        // System.out.println(this.base.toString() + " ------------------------>>");
        //打印请求的获取到的数据
        System.out.println(jsonObject.getBody());

    }

    @Test
    public void insertStudent() {
    }
}