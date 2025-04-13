package com.example.studywithchathu.Service;


import com.example.studywithchathu.Dto.LoginDTO;
import com.example.studywithchathu.Dto.UserDTO;
import com.example.studywithchathu.Entity.User;

import java.util.List;


public interface UserService  {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);

    List<UserDTO> getAllUsers();
    int deleteUser(String email);

    int login(LoginDTO loginDTO);

    UserDTO findByEmail(String email);
}