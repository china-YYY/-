package com.iwuhu.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Auther: Yuxilai
 * @Date: 2022/1/6 - 9:57
 * @Description: com.iwuhu.exception
 * @Version: 1.0
 */
// @Component
@Data
public class Response<T> {
    private Integer code ;
    private String message;
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private T data;

    public Response(Integer code, String messages) {
        this.code = code;
        this.message = messages;
    }

    public Response(Integer code, String messages,T data) {
        this.code = code;
        this.message = messages;
        this.data = data;
    }




}
