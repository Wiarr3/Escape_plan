package com.example.escapePlan.service;

import com.example.escapePlan.dao.UserDao;
import com.example.escapePlan.dto.UserDto;
import com.example.escapePlan.model.User;

import java.util.List;

public interface UserService {
    User addUser(UserDto user);
    User updateUser(Long id,UserDto user);
    User showUser(Long id);
    List<User> showAllUsers();
    void deleteUser(Long id);
    void deleteAllUsers();

}
