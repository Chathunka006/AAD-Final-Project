package com.example.studywithchathu.Controller;


import com.example.studywithchathu.Dto.CourseDTO;
import com.example.studywithchathu.Service.CourseService;
import com.example.studywithchathu.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil saveCourse(@RequestBody CourseDTO courseDTO) {
        courseService.saveCourse(courseDTO);
        return new ResponseUtil(201, "Course saved successfully", null);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getAllCourses() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return new ResponseUtil(200, "All courses retrieved", courses);
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseUtil getCourseById(@PathVariable int id) {
        CourseDTO courses = courseService.getCourseById(id);
        System.out.println(courses);
        return new ResponseUtil(200, "Course found", courses);
    }

    @GetMapping("/getNames")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getCourseNames() {
        List<String> courseNames = courseService.getAllCourseNames();
        return new ResponseUtil(200, "All course names retrieved", courseNames);
    }

    @GetMapping("/getCourseByName/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getCourseByName(@PathVariable String name) {
        Integer courseId = courseService.getCourseIdByName(name);
        return new ResponseUtil(200, "Course found", courseId);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil updateCourse(@PathVariable String id, @RequestBody CourseDTO courseDTO) {
        courseDTO.setCourseId(Integer.parseInt(id));
        courseService.updateCourse(courseDTO);
        return new ResponseUtil(200, "Course updated successfully", null);
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return new ResponseUtil(200, "Course deleted successfully (soft delete)", null);
    }
}
