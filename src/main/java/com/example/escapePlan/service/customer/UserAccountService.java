package com.example.escapePlan.service.customer;

import com.example.escapePlan.dto.userAccountDto.ChangeAddressDto;
import com.example.escapePlan.dto.userAccountDto.ChangeEmailDto;
import com.example.escapePlan.dto.userAccountDto.ChangePasswordDto;
import com.example.escapePlan.model.User;
import com.example.escapePlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class UserAccountService {
    private final UserRepository userRepository;

    public UserAccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ChangePasswordDto changePassword(Long id, ChangePasswordDto changePasswordDto) {
        User user = userRepository.findById(id).orElseThrow();
        if (changePasswordDto.getOldPassword().equals(user.getPassword())) {
            user.setPassword(changePasswordDto.getNewPassword());
            userRepository.save(user);
            return changePasswordDto;
        }
        else
            throw new IllegalStateException();
    }

    public ChangeAddressDto changeAddress(Long id, ChangeAddressDto changeAddressDto){
        User user = userRepository.findById(id).orElseThrow();
        if(changeAddressDto.getPassword().equals(user.getPassword())){
            user.setAddress(changeAddressDto.getAddress());
            userRepository.save(user);
            return changeAddressDto;
        }
        else
            throw new IllegalStateException();
    }
    public ChangeEmailDto changeEmail(Long id, ChangeEmailDto changeEmailDto){
        User user = userRepository.findById(id).orElseThrow();
        System.out.println("haslo podane");
        System.out.println(changeEmailDto.getPassword());
        System.out.println("haslo posiadane");
        System.out.println(user.getPassword());
        if(changeEmailDto.getPassword().equals(user.getPassword())){
            user.setEmail(changeEmailDto.getNewEmail());
            userRepository.save(user);
            return changeEmailDto;
        }
        else
            throw new IllegalStateException();
    }
}
