package com.iwuhu.service.impl;

import com.iwuhu.dto.UserDto;
import com.iwuhu.service.UserService;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author jinyongzhu
 * @date 2022/1/5 5:38 下午
 * @description
 */
@Slf4j
@Service("serServiceImpl")
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDto> getUserList() {
        return Arrays.asList(new UserDto("xxx",1000));
    }
}
