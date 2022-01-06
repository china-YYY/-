package com.iwuhu.service;

import com.iwuhu.dto.Student;
import com.iwuhu.exception.Response;

import java.util.List;

/**
 * @Auther: Yuxilai
 * @Date: 2022/1/6 - 9:46
 * @Description: com.iwuhu.service
 * @Version: 1.0
 */
public interface StudentService {
    /**
    *功能描述：
    *@param: 获取学生集合
    *@return: 学生集合
    *@auther: Yuxilai
    */
     Response list();

    /**
    *功能描述：
    *@param:添加一个学生
    *@return: 无
    *@auther: Yuxilai
    */
    Response addStudent(Student student);



}
