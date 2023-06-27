package com.pradeep.service;

import com.pradeep.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> allUser();
     User getUserById(Long id);
}
