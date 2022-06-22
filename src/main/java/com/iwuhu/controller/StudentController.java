package com.iwuhu.controller;

import com.iwuhu.dto.StudentDto;
import com.iwuhu.commons.Response;
import com.iwuhu.service.PushDingService;
import com.iwuhu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther: Yuxilai
 * @Date: 2022/1/6 - 9:43
 * @Description: com.iwuhu.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private PushDingService pushDingService;

    //查询所有学生
    @GetMapping("/list")
    public Response studentList(){
        pushDingService.pushDing();
        return studentService.list();
    }

    //添加一个学生
    @RequestMapping("/insert")
    public Response insertStudent (@Valid StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }



}
