package com.pharmacy.pharmacy.service.user;

import com.pharmacy.pharmacy.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    List<User> getAll();

    Optional<User> getUser(Integer id);

    boolean userLogin(String userName, String password);

    User login(String userName, String password);
}
