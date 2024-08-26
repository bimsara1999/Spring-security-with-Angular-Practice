package com.springbootAcademy.security.controller;


import com.springbootAcademy.security.model.User;
import com.springbootAcademy.security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepo;

    @PostMapping
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        ResponseEntity response = null;

        try{
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            User savedUser = userRepo.save(user);
            if(savedUser.getId()>0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Successfully Registered");
            }

        }catch (Exception ex){
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("An exception has occurred" + ex.getMessage());

        }
        return response;
    }
}
