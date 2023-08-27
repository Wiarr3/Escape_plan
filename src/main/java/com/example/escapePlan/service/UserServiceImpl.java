package com.example.escapePlan.service;

import com.example.escapePlan.dao.UserDao;
import com.example.escapePlan.dto.UserDto;
import com.example.escapePlan.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    public UserServiceImpl(UserDao userDao)
    {
        super();
        this.userDao = userDao;
    }

    @Override
    public User addUser(UserDto newUser){
        return userDao.addUser(newUser);
    }

    @Override
    public User updateUser(Long id,UserDto user) {
        return userDao.updateUser(id, user);
    }

    @Override
    public User showUser(Long id) {
        return userDao.showUser(id);
    }

    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void deleteAllUsers() {
        userDao.showAllUsers();
    }
    /*
    @Override
    public User save(UserRegistrationDto userDto) {
        User user = new User(userDto.getName(),userDto.getSurname(), userDto.getEmail(), userDto.getPassword());
        return userRepository.save(user);
    }

     */
}
