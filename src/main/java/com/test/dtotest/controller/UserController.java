package com.test.dtotest.controller;

import com.test.dtotest.dto.UserLocationDto;
import com.test.dtotest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/userlocation")
    public List<UserLocationDto> allUserLocation(){
        return userService.getAllUserLocation();
    }
}
