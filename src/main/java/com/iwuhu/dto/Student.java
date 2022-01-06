package com.iwuhu.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Auther: Yuxilai
 * @Date: 2022/1/6 - 9:43
 * @Description: com.iwuhu.dto
 * @Version: 1.0
 */
@Data
public class Student {
    @NotNull(message = "姓名不能为空")
    private String name;
    @Max(value = 200,message = "输入的年龄太大了")
    @Min(value = 0,message = "输入的年龄太小了")
    private Integer age;
}
