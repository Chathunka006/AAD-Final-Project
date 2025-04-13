package com.example.studywithchathu.Service.impl;

import com.example.studywithchathu.Dto.LoginDTO;
import com.example.studywithchathu.Dto.UserDTO;
import com.example.studywithchathu.Entity.User;
import com.example.studywithchathu.Repo.UserRepository;
import com.example.studywithchathu.Service.UserService;
import com.example.studywithchathu.Util.VarList;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDTO searchUser(String username) {
        if (userRepository.existsByEmail(username)) {
            User user=userRepository.findByEmail(username);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            userDTO.setPassword((userDTO.getPassword()));
            userDTO.setRole(userDTO.getRole());
            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int deleteUser(String email) {
        if (userRepository.existsByEmail(email)) {
            userRepository.deleteByEmail(email);
            return VarList.Created;
        } else {
            return VarList.Not_Found;
        }
    }

    @Override
    public int login(LoginDTO loginDTO) {
        boolean existsByEmail = userRepository.existsByEmail(loginDTO.getEmail());
        if (existsByEmail){
            boolean existsByPassword = userRepository.existsByPassword(loginDTO.getPassword());
            if (existsByPassword){
                return VarList.Accepted;
            }
            return VarList.Not_Acceptable;
        }
        return VarList.Not_Acceptable;
    }

    @Override
    public UserDTO findByEmail(String email) {
        User byEmail = userRepository.findByEmail(email);
        return modelMapper.map(byEmail,new TypeToken<UserDTO>(){}.getType());
    }
}
