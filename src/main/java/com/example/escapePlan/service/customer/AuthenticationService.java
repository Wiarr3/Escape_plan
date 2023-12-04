package com.example.escapePlan.service.customer;

import com.example.escapePlan.dto.LoginResponseDto;
import com.example.escapePlan.dto.userAccountDto.UserDto;
import com.example.escapePlan.model.Role;
import com.example.escapePlan.model.User;
import com.example.escapePlan.repository.RoleRepository;
import com.example.escapePlan.repository.UserRepository;
import com.example.escapePlan.service.TokenService;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public User registerUser(String email, String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) return null;
        String encodedPassword = encoder.encode(password);
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByAuthority("USER").get();
        roles.add(userRole);
        User user = new User(email, username, encodedPassword);
        user.setAuthorities(roles);
        return userRepository.save(user);
    }

    public LoginResponseDto loginUser(String username, String password) {

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            String token = tokenService.generateJwt(auth);

            return new LoginResponseDto(userRepository.findByUsername(username).get(), token);

        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResponseDto(new UserDto(), "");
        }
    }

    public Long getCurrentId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
            return user.getId();
        } else
            throw new IllegalStateException();
    }

    public Long getIdByUsername(String username){
        if(userRepository.findByUsername(username).isPresent())
            return userRepository.findByUsername(username).get().getId();
        else
            //do zmiany
            throw new RuntimeException();
    }


}



