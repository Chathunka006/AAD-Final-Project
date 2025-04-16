package com.example.studywithchathu.Service.impl;

import com.example.studywithchathu.Dto.TeacherDTO;
import com.example.studywithchathu.Entity.Teacher;
import com.example.studywithchathu.Repo.TeacherRepository;
import com.example.studywithchathu.Service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        teacher.setDeleted(false);
        teacherRepo.save(teacher);
    }

    @Override
    public void updateTeacher(TeacherDTO teacherDTO) {
        Optional<Teacher> optionalTeacher = teacherRepo.findById(Integer.valueOf(teacherDTO.getTeacherId()));
        if (optionalTeacher.isPresent()) {
            Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
            teacherRepo.save(teacher);
        } else {
            throw new RuntimeException("Teacher not found with ID: " + teacherDTO.getTeacherId());
        }
    }

    @Override
    public void deleteTeacher(int id) {
        Optional<Teacher> optionalTeacher = teacherRepo.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setDeleted(true); // soft delete
            teacherRepo.save(teacher);
        } else {
            throw new RuntimeException("Teacher not found with ID: " + id);
        }
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepo.findByIsDeletedFalse()
                .stream()
                .map(teacher -> modelMapper.map(teacher, TeacherDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllTeacherNames() {
        return teacherRepo.findByIsDeletedFalse()
                .stream()
                .map(Teacher::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Integer getTeacherIdByName(String name) {
        Teacher teacher = teacherRepo.findByNameAndIsDeletedFalse(name);
        if (teacher != null) {
            return teacher.getTeacherId();
        } else {
            throw new RuntimeException("Teacher not found with name: " + name);
        }
    }
}
