package com.example.studywithchathu.Controller;

import com.example.studywithchathu.Dto.TeacherDTO;
import com.example.studywithchathu.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    @Autowired
    private com.example.studywithchathu.Service.TeacherService teacherService;

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil saveTeacher(@RequestBody TeacherDTO teacherDTO) {
        teacherService.saveTeacher(teacherDTO);
        return new ResponseUtil(201, "Teacher saved successfully", null);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getAllTeachers() {
        List<TeacherDTO> teachers = teacherService.getAllTeachers();
        return new ResponseUtil(200, "All teachers retrieved", teachers);
    }

    @GetMapping("/getNames")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getTeacherNames() {
        List<String> teacherNames = teacherService.getAllTeacherNames();
        return new ResponseUtil(200, "All teacher names retrieved", teacherNames);
    }

    @GetMapping("/getTeacherByName/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getTeacherByName(@PathVariable String name) {
        Integer teacherId = teacherService.getTeacherIdByName(name);
        return new ResponseUtil(200, "Teacher found", teacherId);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil updateTeacher(@PathVariable String id, @RequestBody TeacherDTO teacherDTO) {
        teacherDTO.setTeacherId(String.valueOf(Integer.parseInt(id)));
        teacherService.updateTeacher(teacherDTO);
        return new ResponseUtil(200, "Teacher updated successfully", null);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return new ResponseUtil(200, "Teacher deleted successfully (soft delete)", null);
    }
}
