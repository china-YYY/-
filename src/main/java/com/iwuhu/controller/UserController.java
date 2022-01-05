package com.iwuhu.controller;

import com.iwuhu.dto.UserDto;
import com.iwuhu.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinyongzhu
 * @date 2022/1/5 5:35 下午
 * @description
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<UserDto> getUserList(){
       return userService.getUserList();
    }
}
