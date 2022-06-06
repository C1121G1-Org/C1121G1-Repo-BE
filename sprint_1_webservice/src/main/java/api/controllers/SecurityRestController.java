package api.controllers;

import api.dto.PersonalDto;
import api.models.Account;
import api.models.Employee;
import api.payload.request.ChangePasswordRequest;
import api.payload.request.CheckVerificationCodeRequest;
import api.payload.request.LoginRequest;
import api.payload.request.ResetPasswordRequest;
import api.payload.response.JwtResponse;
import api.security.JwtFilter;
import api.security.JwtUtility;
import api.services.IAccountService;
import api.services.IEmployeeService;
import api.services.impl.AccountDetailsImpl;
import api.services.impl.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Created by KhaiTT
    Date: 17:55 31/05/2022
    Function: This SecurityRestController class stipulates which method the requests sent from clients will go.
*/
@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityRestController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private EmailSendService emailSendService;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    IEmployeeService iEmployeeService;

    /*
        Function: This authenticateUser() method stipulates which method the requests sent from clients will go.
    */
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtUtility.generateJwtToken(loginRequest.getUsername());

        AccountDetailsImpl accountDetails = (AccountDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<String> roles = accountDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return new ResponseEntity<>(new JwtResponse(jwt, accountDetails.getId(), accountDetails.getUsername(), accountDetails.getImageLink(), roles), HttpStatus.OK);
    }

    /*
        Function: This findByUserName() method checks the existence of the account and sends the password
                  change confirmation code to that account's email.
    */
    @PostMapping(value = "/find-by-email")
    public ResponseEntity<Account> findByUserName(@RequestBody String email) throws MessagingException, UnsupportedEncodingException {
        Account account = iAccountService.findAccountByEmail(email);
        if (account != null) {
            String code = iAccountService.setVetificationCode(account);
            emailSendService.sendEmail(account.getEmail(), account.getEmployee().getEmployeeName(), code);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
        Function: This findByUserName() method checks the existence of the account and sends the password
                  change confirmation code to that account's email.
    */
    @PatchMapping(value = "/refresh-code")
    public ResponseEntity<Account> refreshCode(@RequestBody String email) {
        Account account = iAccountService.findAccountByEmail(email);
        if (account != null) {
            iAccountService.refreshCode(account.getUserName());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
        Function: This checkVerificationCode() method checks if the VerificationCode sent from the client
                  matches the VerificationCode stored in that account object.
    */
    @PostMapping(value = "/check-code")
    public ResponseEntity<Boolean> checkVerificationCode(@RequestBody CheckVerificationCodeRequest checkVerificationCodeRequest) {
        Account account = iAccountService.findAccountByEmail(checkVerificationCodeRequest.getEmail());
        if (account != null && account.getVerificationCode().equals(checkVerificationCodeRequest.getCode())) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    /*
        Created by KhaiTT
        Date: 22:37 31/05/2022
        Function: This method return Employee object by token of account.
    */
    @GetMapping(value = "/personal/information")
    public ResponseEntity<Employee> getPersonalInformation() {
        Account account = jwtFilter.findAccountByJwtToken();
        Optional<Employee> employeeOptional = iEmployeeService.findById(account.getEmployee().getId());
        return employeeOptional.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.BAD_REQUEST));
    }

    /*
        Created by KhaiTT
        Date: 15:34 01/06/2022
        Function: This method update personal information of employee.
    */
    @PatchMapping(value = "/personal/information/update")
    public ResponseEntity<Map<String, String>> updatePersonalInformation(@Valid @RequestBody PersonalDto personalDto,
                                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        iEmployeeService.updatePersonalInforamation(personalDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
        Created by KhaiTT
        Date: 22:44 31/05/2022
        Function: This method change account password.
    */
    @PatchMapping(value = "/personal/change-password")
    public ResponseEntity<Account> changePersonalPassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        Account account = jwtFilter.findAccountByJwtToken();
        if (encoder.matches(changePasswordRequest.getCurrentPassword(), account.getEncryptPassword()) &&
                changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmNewPassword())) {
            String encryptPassword = encoder.encode(changePasswordRequest.getNewPassword());
            iAccountService.changePassword(encryptPassword, account.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
        Created by KhaiTT
        Date: 19:34 03/06/2022
        Function: This method reset account password.
    */
    @PatchMapping(value = "/reset-password")
    public ResponseEntity<Account> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        Account account = iAccountService.findAccountByEmail(resetPasswordRequest.getEmail());
        if (account != null && resetPasswordRequest.getNewPassword().equals(resetPasswordRequest.getConfirmNewPassword())) {
            String encryptPassword = encoder.encode(resetPasswordRequest.getNewPassword());
            iAccountService.changePassword(encryptPassword, account.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
