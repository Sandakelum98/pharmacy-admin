package com.pharmacy.pharmacy.service.impl;

import com.pharmacy.pharmacy.model.user.User;
import com.pharmacy.pharmacy.repository.user.UserRepository;
import com.pharmacy.pharmacy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean userLogin(String userName, String password) {
        return userRepository.userLogin(userName, password);
    }

    @Override
    public User login(String userName, String password) {
        return userRepository.login(userName, password);
    }
}
