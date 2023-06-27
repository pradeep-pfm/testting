package com.pradeep.controller;

import com.pradeep.entity.User;
import com.pradeep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save-user")
    public User saveUser(@RequestBody User user) throws Exception {
        System.out.println("fistNmae "+user.getFirstName()+" " +"Last name "+user.getLastName());
//        if(user.getFName().isEmpty() || user.getLName().isEmpty())
//            throw new Exception("Required data shuld not be null");
        return userService.saveUser(user);
    }
    @GetMapping("/alluser")
    public List<User> getAllUser() {
        //System.out.println("all user list  "+getAllUser().toString());
        return userService.allUser();

    }
}
