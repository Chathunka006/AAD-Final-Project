package com.example.studywithchathu.Controller;

import com.example.studywithchathu.Dto.LessonDTO;
import com.example.studywithchathu.Service.LessonService;
import com.example.studywithchathu.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;


    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil saveLesson(@RequestBody LessonDTO lessonDTO) {
        lessonService.saveLesson(lessonDTO);
        return new ResponseUtil(201, "Lesson saved successfully", null);
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getAllLessons() {
        List<LessonDTO> lessons = lessonService.getAllLessons();
        return new ResponseUtil(200, "All lessons retrieved", lessons);
    }

    @GetMapping("/getNames")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getLessonNames() {
        List<String> lessonNames = lessonService.getAllLessonNames();
        return new ResponseUtil(200, "All lesson names retrieved", lessonNames);
    }

    @GetMapping("/getLessonByName/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil getLessonByName(@PathVariable String name) {
        Integer lessonId = lessonService.getLessonIdByName(name);
        return new ResponseUtil(200, "Lesson found", lessonId);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil updateLesson(@PathVariable String id, @RequestBody LessonDTO lessonDTO) {
        lessonDTO.setLessonId(Integer.parseInt(id));
        lessonService.updateLesson(lessonDTO);
        return new ResponseUtil(200, "Lesson updated successfully", null);
    }

    @DeleteMapping(path = "/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseUtil deleteLesson(@PathVariable int id) {
        lessonService.deleteLesson(id);
        return new ResponseUtil(200, "Lesson deleted successfully (soft delete)", null);
    }

}
