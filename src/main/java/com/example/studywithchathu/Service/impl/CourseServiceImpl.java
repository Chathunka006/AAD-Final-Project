package com.example.studywithchathu.Service.impl;

import com.example.studywithchathu.Dto.CourseDTO;
import com.example.studywithchathu.Entity.Course;
import com.example.studywithchathu.Repo.CourseRepository;
import com.example.studywithchathu.Service.CourseService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public void saveCourse(CourseDTO courseDTO) {
        if (courseRepo.existsById(courseDTO.getCourseId())) {
            throw new RuntimeException("Course already exists!");
        }
        courseRepo.save(modelMapper.map(courseDTO, Course.class));
    }

    @Override
    public List<String> getAllCourseNames() {
        return courseRepo.findAllCourseNames();
    }

    @Override
    public Integer getCourseIdByName(String name) {
        return courseRepo.findCourseByName(name);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        return modelMapper.map(courseRepo.findByIsDeletedFalse(),
                new TypeToken<List<CourseDTO>>() {}.getType());
    }

    @Override
    public void updateCourse(CourseDTO courseDTO) {
        if (!courseRepo.existsById(courseDTO.getCourseId())) {
            throw new RuntimeException("Course does not exist!");
        }

        Course course = modelMapper.map(courseDTO, Course.class);
        courseRepo.save(course);
    }

    @Override
    public void deleteCourse(int id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setDeleted(true); // Soft delete
        courseRepo.save(course);
    }
}
