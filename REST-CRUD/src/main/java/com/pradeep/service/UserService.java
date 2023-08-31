package com.pradeep.service;

import com.pradeep.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<List<User>> allUser();
     User getUserById(Long id);
}
