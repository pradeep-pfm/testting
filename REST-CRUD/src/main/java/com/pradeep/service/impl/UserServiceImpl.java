package com.pradeep.service.impl;

import com.pradeep.entity.User;
import com.pradeep.repository.UserRepository;
import com.pradeep.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override

    public Optional<List<User>> allUser() {
        List<User> allUser = userRepository.findAll();
        //System.out.println("All user are "+allUser.toString());
        Optional<List<User>> maleUser50 = Optional.of(allUser.stream().filter(user -> user.getGender().equals("Female") && user.getAge() < 50)
                .collect(Collectors.toList()));
        System.out.println("list are " + maleUser50);
        this.getAllUsersByGender("Male");
        return maleUser50;
    }

    public Optional<List<User>> getAllUsersByGender(String genderType) {
        Optional<List<User>> maleUser50 = Optional.ofNullable(userRepository.findAll().stream().filter(user -> genderType.equals(user.getGender()))
                .collect(Collectors.toList()));

        System.out.println("getAllUsersByGender are " + maleUser50);
        return maleUser50;
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else throw new RuntimeException("User is not available for " + id);
    }
}
