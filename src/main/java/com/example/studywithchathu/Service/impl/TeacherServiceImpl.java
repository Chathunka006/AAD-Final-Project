package com.example.studywithchathu.Service.impl;

import com.example.studywithchathu.Dto.TeacherDTO;
import com.example.studywithchathu.Entity.Teacher;
import com.example.studywithchathu.Repo.TeacherRepository;
import com.example.studywithchathu.Service.TeacherService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public void saveTeacher(TeacherDTO teacherDTO) {
        if (teacherRepo.existsById(Integer.valueOf(teacherDTO.getTeacherId()))) {
            throw new RuntimeException("Teacher already exists!");
        }
        teacherRepo.save(modelMapper.map(teacherDTO, Teacher.class));
    }

    @Override
    public List<String> getAllTeacherNames() {
        return teacherRepo.findAllTeacherNames();
    }

    @Override
    public Integer getTeacherIdByName(String name) {
        return teacherRepo.findTeacherByName(name);
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return modelMapper.map(teacherRepo.findByIsDeletedFalse(),
                new TypeToken<List<TeacherDTO>>() {}.getType());
    }

    @Override
    public void updateTeacher(TeacherDTO teacherDTO) {
        if (!teacherRepo.existsById(Integer.valueOf(teacherDTO.getTeacherId()))) {
            throw new RuntimeException("Teacher does not exist!");
        }

        Teacher teacher = modelMapper.map(teacherDTO, Teacher.class);
        teacherRepo.save(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        teacher.setDeleted(true); // Soft delete
        teacherRepo.save(teacher);
    }
}
