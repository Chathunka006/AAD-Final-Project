package com.example.studywithchathu.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dhanujaya(Dhanu)
 * @TimeStamp 30/03/2025 11:43
 * @ProjectDetails StudyWithChathu
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDTO {
    private String email;
    private String password;
}
