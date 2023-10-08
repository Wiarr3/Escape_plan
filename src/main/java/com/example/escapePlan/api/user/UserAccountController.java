package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.userAccountDto.ChangeAddressDto;
import com.example.escapePlan.dto.userAccountDto.ChangeEmailDto;
import com.example.escapePlan.dto.userAccountDto.ChangePasswordDto;
import com.example.escapePlan.service.AuthenticationService;
import com.example.escapePlan.service.customer.UserAccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/account")
public class UserAccountController {

   public AuthenticationService authService;
   public UserAccountService accountService;

   public UserAccountController(AuthenticationService authService, UserAccountService accountService){
       this.authService = authService;
       this.accountService = accountService;
   }

    @PatchMapping("/password")
    public ChangePasswordDto updatePassword(@RequestBody ChangePasswordDto changePasswordDto){
        return accountService.changePassword(authService.getCurrentId(),changePasswordDto);
    }

    @PatchMapping("/address")
    public ChangeAddressDto updateAddress(@RequestBody ChangeAddressDto changeAddressDto){
       return accountService.changeAddress(authService.getCurrentId(),changeAddressDto);
    }

    @PatchMapping("/email")
    public ChangeEmailDto updateEmail(@RequestBody ChangeEmailDto changeEmailDto){
       System.out.println(authService.getCurrentId());
       return accountService.changeEmail(authService.getCurrentId(),changeEmailDto);
    }
    @GetMapping("/id")
    public Long getUserId(){
       return authService.getCurrentId();
    }
}
