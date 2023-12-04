package com.example.escapePlan.service.admin;

import com.example.escapePlan.dao.UserDao;
import com.example.escapePlan.dto.userAccountDto.UserDto;
import com.example.escapePlan.model.User;
import com.example.escapePlan.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserDao userDao;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    public UserServiceImpl(UserDao userDao, PasswordEncoder encoder, UserRepository userRepository)
    {
        super();
        this.userDao = userDao;
        this.encoder = encoder;
        this.userRepository = userRepository;
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("user is not valid"));
    }
    /*
    @Override
    public User save(UserRegistrationDto userDto) {
        User user = new User(userDto.getName(),userDto.getSurname(), userDto.getEmail(), userDto.getPassword());
        return userRepository.save(user);
    }

     */
}
