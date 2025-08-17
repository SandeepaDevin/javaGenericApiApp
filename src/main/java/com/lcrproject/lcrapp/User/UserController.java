package com.lcrproject.lcrapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lcrproject.lcrapp.User.User;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Fetching all users");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        logger.info("Fetching user with id: {}", id);
        return userService.getUserById(id);

    }

    @PutMapping("/{id}")
    public User updateUser(@Valid @PathVariable String id, @RequestBody User user) {
        logger.info("Updating user with id: {}", id);
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        logger.warn("Deleting user with id: {}", id);
        userService.deleteUser(id);
    }

}
