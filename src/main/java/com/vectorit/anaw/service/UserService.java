package com.vectorit.anaw.service;

import com.vectorit.anaw.model.User;
import com.vectorit.anaw.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList :: add);
        return userList;
    }

    public User getAll(String username) {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList :: add);
        User user = userList.stream().filter(u -> u.getUserName().equals(username))
                .findAny()
                .orElse(null);
        return user;
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public User deleteUser(String username) {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList :: add);
        User user = userList.stream().filter(u -> u.getUserName().equals(username))
                .findAny()
                .orElse(null);
        if(user != null)
            userRepository.delete(user);
        return user;
    }

    public void updateUser(User user) {
    }
}
