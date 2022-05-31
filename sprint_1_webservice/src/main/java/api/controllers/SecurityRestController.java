package api.controllers;

import api.models.Account;
import api.payload.request.LoginRequest;
import api.payload.response.JwtResponse;
import api.security.JwtUtility;
import api.services.IAccountService;
import api.services.impl.AccountDetailsImpl;
import api.services.impl.EmailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
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
        System.out.println("authenticateUser() at SecurityRestController in controller package.");
        return new ResponseEntity<>(new JwtResponse(jwt, accountDetails.getId(), accountDetails.getUsername(), roles), HttpStatus.OK);
    }

    /*
        Function: This findByUserName() method checks the existence of the account and sends the password
                  change confirmation code to that account's email.
    */
    @GetMapping(value = "/find-by-username")
    public ResponseEntity<Account> findByUserName(@RequestParam String username) {
        Account account = iAccountService.findByUserName(username);
        if (account != null) {
            String code = iAccountService.setVetificationCode(account);
            emailSendService.setMail(account.getEmail(), "Xác nhận", "Mã xác nhận " + code);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
        Function: This checkVerificationCode() method checks if the VerificationCode sent from the client
                  matches the VerificationCode stored in that account object.
    */
    @GetMapping(value = "/check-code")
    public ResponseEntity<Boolean> checkVerificationCode(@RequestParam("username") String username, @RequestParam("code") String code) {
        Account account = iAccountService.findByUserName(username);
        if (account != null) {
            if (account.getVerificationCode().equals(code)) {
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
