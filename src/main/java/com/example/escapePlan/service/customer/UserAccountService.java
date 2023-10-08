package com.example.escapePlan.service.customer;

import com.example.escapePlan.dto.userAccountDto.UpdateAddressDto;
import com.example.escapePlan.dto.userAccountDto.UpdateEmailDto;
import com.example.escapePlan.dto.userAccountDto.UpdatePasswordDto;
import com.example.escapePlan.model.User;
import com.example.escapePlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class UserAccountService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UpdatePasswordDto changePassword(Long id, UpdatePasswordDto updatePasswordDto) {
        User user = userRepository.findById(id).orElseThrow();
        String password = updatePasswordDto.getOldPassword();
        if (passwordEncoder.matches(password,user.getPassword())) {
            String newPassword = passwordEncoder.encode(updatePasswordDto.getNewPassword());
            user.setPassword(newPassword);
            userRepository.save(user);
            return updatePasswordDto;
        }
        else
            throw new IllegalStateException();
    }

    public UpdateAddressDto changeAddress(Long id, UpdateAddressDto updateAddressDto){
        User user = userRepository.findById(id).orElseThrow();
        String password = updateAddressDto.getPassword();
        if(passwordEncoder.matches(password,user.getPassword())){
            user.setAddress(updateAddressDto.getAddress());
            userRepository.save(user);
            return updateAddressDto;
        }
        else
            throw new IllegalStateException();
    }
    public UpdateEmailDto changeEmail(Long id, UpdateEmailDto updateEmailDto){
        User user = userRepository.findById(id).orElseThrow();
        String password = updateEmailDto.getPassword();
        System.out.println("haslo podane i zaszyfrowane");
        System.out.println(password);
        System.out.println("haslo w systemie");
        System.out.println(user.getPassword());
        System.out.println(passwordEncoder.matches(password,user.getPassword()));
        if(passwordEncoder.matches(password,user.getPassword())){
            user.setEmail(updateEmailDto.getNewEmail());
            userRepository.save(user);
            return updateEmailDto;
        }
        else
            throw new IllegalStateException();
    }
}
