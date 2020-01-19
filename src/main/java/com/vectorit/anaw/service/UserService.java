package com.vectorit.anaw.service;

import com.vectorit.anaw.model.User;
import com.vectorit.anaw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
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
        User user = userRepository.findByUserName(username);
        return user;
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public User deleteUser(String username) {
        User opu = userRepository.findByUserName(username);

        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList :: add);

        User user = userList.stream().filter(u -> u.getUserName().equals(opu.getUserName()))
                .findAny()
                .orElse(null);
        if(user!=null)
            userRepository.delete(user);

        return user;
    }

    public void updateUser(User user) {
        this.deleteUser(user.getUserName());
        userRepository.save(user);
    }
}
