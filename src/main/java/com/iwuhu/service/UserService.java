package com.iwuhu.service;

import com.iwuhu.dto.UserDto;
import java.util.List;

/**
 * @author jinyongzhu
 * @date 2022/1/5 5:35 下午
 * @description
 */
public interface UserService {
    List<UserDto> getUserList();
}
