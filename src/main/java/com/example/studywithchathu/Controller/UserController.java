package com.example.studywithchathu.Controller;

import com.example.studywithchathu.Dto.LoginDTO;
import com.example.studywithchathu.Dto.ResponseDTO;
import com.example.studywithchathu.Dto.UserDTO;
import com.example.studywithchathu.Service.UserService;
import com.example.studywithchathu.Util.VarList;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    //constructor injection
    public UserController(UserService userService) {
        this.userService = userService;

    }
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO){
        int status = userService.login(loginDTO);
        switch (status){
            case VarList.Accepted -> {
                UserDTO user = userService.findByEmail(loginDTO.getEmail());
                return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(new ResponseDTO(VarList.Accepted,"Logging Success",user));
            }
            case VarList.Not_Acceptable -> {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                        .body(new ResponseDTO(VarList.Not_Acceptable,"Logging unsuccessfully!",null));
            }
            default -> {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseDTO(VarList.Internal_Server_Error,"Logging unsuccessfully!",null));
            }
        }
    }

    @PostMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllUsers() {
        try {
            List<UserDTO> userDTOS = userService.getAllUsers();
            ResponseDTO responseDTO = new ResponseDTO(VarList.Created, "Success", userDTOS);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            ResponseDTO responseDTO = new ResponseDTO(VarList.Bad_Gateway, e.getMessage(), null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping( "/register")
    public ResponseEntity<ResponseDTO> registerUser(@Valid @RequestBody UserDTO userDTO) {
        System.out.println("nane"+userDTO);
        try {
            int res = userService.saveUser(userDTO);
            switch (res) {
                case VarList.Created -> {
                    return ResponseEntity.status(HttpStatus.CREATED)

                            .body(new ResponseDTO(VarList.Created, "Success",null));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @DeleteMapping("/deleteUser/{email}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable String email) {
        try {
            int result = userService.deleteUser(email);
            if (result == VarList.Created) {
                ResponseDTO responseDTO = new ResponseDTO(VarList.Created, "User deleted successfully", null);
                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else if (result == VarList.Not_Found) {
                ResponseDTO responseDTO = new ResponseDTO(VarList.Not_Found, "User not found", null);
                return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
            } else {
                ResponseDTO responseDTO = new ResponseDTO(VarList.Bad_Request, "Error deleting user", null);
                return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            ResponseDTO responseDTO = new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null);
            return new ResponseEntity<>(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
