package com.pharmacy.pharmacy.controller.user;

import com.pharmacy.pharmacy.model.user.User;
import com.pharmacy.pharmacy.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String test() {
        return "Success!";
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/get-list")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User bean = new User();
        bean = userService.login(user.getUserName(), user.getPassword());
        if (bean != null) {
            return new ResponseEntity<User>(userService.login(user.getUserName(), user.getPassword()), HttpStatus.OK);
        }
        return new ResponseEntity<User>(userService.login(user.getUserName(), user.getPassword()), HttpStatus.CONFLICT);
    }
}
