package com.example.studywithchathu.Service.impl;

import com.example.studywithchathu.Dto.StudentCourseDTO;
import com.example.studywithchathu.Entity.StudentCourse;
import com.example.studywithchathu.Repo.StudentCourseRepository;
import com.example.studywithchathu.Service.StudentCourseService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public void addStudentCourse(StudentCourseDTO studentCourseDTO) {
        if(studentCourseRepository.findStudentCourseByCourseIdAndStudentId(studentCourseDTO.getCourseId() , studentCourseDTO.getUserId()) != null) {
            throw new RuntimeException("Cannot add  course because student course already exists");
        }
        System.out.println("studentCourseDTO : " + studentCourseDTO);
        studentCourseRepository.save(modelMapper.map(studentCourseDTO, StudentCourse.class));
    }

    @Override
    public List<StudentCourseDTO> getAllStudentCoursesByStudentId(UUID studentId) {
       List<StudentCourse> studentCourses = studentCourseRepository.findStudentCourseByStudentId(studentId);

       if(studentCourses != null) {
           return modelMapper.map(studentCourses, new TypeToken<List<StudentCourseDTO>>(){}.getType());
       }else {
           throw new RuntimeException("Cannot find student course");
       }

    }
}
