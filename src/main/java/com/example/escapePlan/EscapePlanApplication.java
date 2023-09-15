package com.example.escapePlan;

import com.example.escapePlan.model.Role;
import com.example.escapePlan.model.User;
import com.example.escapePlan.repository.RoleRepository;
import com.example.escapePlan.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EscapePlanApplication {

    public static void main(String[] args) {
        SpringApplication.run(EscapePlanApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            if (roleRepository.findByAuthority("USER").isPresent()) return;
            Role adminRole = new Role("ADMIN");
            Role userRole = new Role("USER");
            roleRepository.save(adminRole);
            roleRepository.save(userRole);
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            User user = new User("wiara", encoder.encode("1"));
            user.setAuthorities(roles);
            userRepository.save(user);

        };
    }

}
