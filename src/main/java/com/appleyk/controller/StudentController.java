package com.appleyk.controller;

import com.appleyk.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 学生接口
 * @Author lixy
 * @Date 2024/3/6 18:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    public R<Boolean> addStudent(@RequestBody Student){

    }
}
