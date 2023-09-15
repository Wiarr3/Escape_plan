package com.example.escapePlan.service;

import com.example.escapePlan.dto.LoginResponseDto;
import com.example.escapePlan.model.Role;
import com.example.escapePlan.model.User;
import com.example.escapePlan.repository.RoleRepository;
import com.example.escapePlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.lang.invoke.WrongMethodTypeException;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder encoder, AuthenticationManager authenticationManager,
                                 TokenService tokenService) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public User registerUser(String username, String password) {
        if(userRepository.findByUsername(username).isPresent()) return null;
        String encodedPassword = encoder.encode(password);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByAuthority("USER").get();
        roles.add(userRole);
        User user = new User(username, encodedPassword);
        user.setAuthorities(roles);
        return userRepository.save(user);
    }

    public LoginResponseDto loginUser(String username, String password){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username,password));
        String token = tokenService.generateJwt(auth);
        return new LoginResponseDto(userRepository.findByUsername(username).get(),token);

    }
}
