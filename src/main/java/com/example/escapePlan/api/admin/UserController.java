package com.example.escapePlan.api.admin;

import com.example.escapePlan.dto.userAccountDto.UserDto;
import com.example.escapePlan.model.User;
import com.example.escapePlan.service.admin.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service){
        this.service = service;
    }
    @PostMapping
    public User addUser(@RequestBody UserDto userDto){
        return service.addUser(userDto);
    }
    @PatchMapping
    public User updateUser(@PathVariable Long id, UserDto userDto){
        return service.updateUser(id,userDto);
    }
    @GetMapping("/{id}")
    public User showUser(@PathVariable Long id){
        return service.showUser(id);
    }
    @GetMapping
    public List<User> showAllUsers(){
        return service.showAllUsers();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
    @DeleteMapping
    public void deleteAllUsers(){
        service.deleteAllUsers();
    }

}
