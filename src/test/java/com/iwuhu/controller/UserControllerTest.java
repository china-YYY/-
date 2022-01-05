package com.iwuhu.controller;

import com.iwuhu.MyApplicaiton;
import java.net.URL;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author jinyongzhu
 * @date 2022/1/5 5:44 下午
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyApplicaiton.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserControllerTest extends TestCase {

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
    public void testGetUserList() {
        ResponseEntity<List> response = this.restTemplate.getForEntity(
                this.base.toString() + "/user/list", List.class, "");
        System.out.println(String.format("测试结果为：%s", response.getBody()));
    }
}