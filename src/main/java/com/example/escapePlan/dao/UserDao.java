package com.example.escapePlan.dao;

import com.example.escapePlan.dto.UserDto;
import com.example.escapePlan.model.User;
import com.example.escapePlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User showUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> showAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User addUser(UserDto newUserDto) {
        User newUser = new User(newUserDto.getEmail(), newUserDto.getUsername(), newUserDto.getPassword(), newUserDto.getAddress());
        return userRepository.save(newUser);
    }

    @Transactional
    public User updateUser(Long id, UserDto updatedUser) {
        User existingUser = userRepository.findById(id).orElseThrow();
        existingUser.copyFromDto(updatedUser);
        return existingUser;
    }

    @Transactional

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
