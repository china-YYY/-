package com.iwuhu.service.impl;

import com.iwuhu.dto.Student;
import com.iwuhu.exception.Response;
import com.iwuhu.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Yuxilai
 * @Date: 2022/1/6 - 9:48
 * @Description: com.iwuhu.service.impl
 * @Version: 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    List<Student> studentList = new ArrayList<>();

    @Resource
    HttpServletRequest request;

    @Override
    public Response list() {
        String accessToken = request.getHeader("accessToken");
        String ssoId = request.getHeader("ssoId");
        if (!StringUtils.isNotEmpty(accessToken)) {
            return new Response(4003,"token-> 无效");
        }
        if (!StringUtils.isNotEmpty(ssoId)) {
            return new Response(4003,"ssoId-> 无效");
        }

        for (int i = 1; i <= 5; i++) {
            Student student = new Student();
            student.setName("学生"+i);
            student.setAge(i);
            studentList.add(student);
        }
        return new Response(2000,"查询成功",studentList);
    }

    @Override
    public Response addStudent(Student student) {
        String accessToken = request.getHeader("accessToken");
        String ssoId = request.getHeader("ssoId");
        if (!StringUtils.isNotEmpty(accessToken)) {
            return new Response(4003,"token-> 无效");
        }
        if (!StringUtils.isNotEmpty(ssoId)) {
            return new Response(4003,"ssoId-> 无效");
        }

        boolean contains = studentList.contains(student);
        if (contains) {
            return new Response(4005,"数据库中已经有当前对象了");
        }
        studentList.add(student);
        return new Response(2000,"添加成功");
    }

}
