package com.example.escapePlan.service.admin;

import com.example.escapePlan.dto.userAccountDto.UserDto;
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
