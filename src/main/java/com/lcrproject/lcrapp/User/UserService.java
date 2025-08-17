package com.lcrproject.lcrapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
            () -> new RuntimeException("User not found with id: " + id)
        );
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(String id, User updatedUser) {
        User existing = getUserById(id);
        existing.setUsername(updatedUser.getUsername());
        existing.setAge(updatedUser.getAge());
        existing.setGender(updatedUser.getGender());
        existing.setTelephone(updatedUser.getTelephone());
        existing.setEmail(updatedUser.getEmail());
        return userRepository.save(existing);
    }

    // Delete
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    
}
