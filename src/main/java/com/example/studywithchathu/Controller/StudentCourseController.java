package com.example.studywithchathu.Controller;


import com.example.studywithchathu.Dto.StudentCourseDTO;
import com.example.studywithchathu.Service.StudentCourseService;
import com.example.studywithchathu.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/studentcourse")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping("/save")
    public ResponseUtil saveStudentCourse(@RequestBody StudentCourseDTO studentCourseDTO) {
        System.out.println("studentCourseDTO : " + studentCourseDTO);

        studentCourseService.addStudentCourse(studentCourseDTO);
        return new ResponseUtil(201, "Student Course saved successfully", null);
    }

    @GetMapping("/getStudentCourse/{id}")
    public ResponseUtil getStudentCourse(@PathVariable UUID id) {
        System.out.println(id);
        List<StudentCourseDTO> studentCourses =  studentCourseService.getAllStudentCoursesByStudentId(id);
        return new ResponseUtil(200, "Student Course found", studentCourses);
    }
}
