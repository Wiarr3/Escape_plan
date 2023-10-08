package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.userAccountDto.UpdateAddressDto;
import com.example.escapePlan.dto.userAccountDto.UpdateEmailDto;
import com.example.escapePlan.dto.userAccountDto.UpdatePasswordDto;
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
    public UpdatePasswordDto updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto){
        return accountService.changePassword(authService.getCurrentId(), updatePasswordDto);
    }

    @PatchMapping("/address")
    public UpdateAddressDto updateAddress(@RequestBody UpdateAddressDto updateAddressDto){
       return accountService.changeAddress(authService.getCurrentId(), updateAddressDto);
    }

    @PatchMapping("/email")
    public UpdateEmailDto updateEmail(@RequestBody UpdateEmailDto updateEmailDto){
       System.out.println(authService.getCurrentId());
       return accountService.changeEmail(authService.getCurrentId(), updateEmailDto);
    }

}
