package com.iwuhu.controller;

import com.iwuhu.dto.UserDto;
import com.iwuhu.service.PushDingService;
import com.iwuhu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Yuxilai
 * @Date: 2022/6/16 - 14:52
 * @Description: com.iwuhu.controller
 * @Version: 1.0
 */
@Controller("/push")
public class PushDingController {
    @Autowired
    private PushDingService pushDingService;

    @GetMapping("/ding")
    public String pushDing(){
        return pushDingService.pushDing();
    }
}
