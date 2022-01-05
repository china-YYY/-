package com.iwuhu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jinyongzhu
 * @date 2022/1/5 5:36 下午
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userName;

    private Integer id;
}
