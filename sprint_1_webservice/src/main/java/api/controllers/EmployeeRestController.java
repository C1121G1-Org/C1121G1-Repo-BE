package api.controllers;

import api.dto.PersonalDto;
import api.models.Account;
import api.models.Employee;
import api.payload.request.ChangePasswordRequest;
import api.repositories.IAccountRepository;
import api.security.JwtFilter;
import api.services.IEmployeeService;
import api.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IPositionService iPositionService;

    @Autowired
    private IAccountRepository iAccountRepository;

    @Autowired
    private JwtFilter jwtFilter;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(value = "/list")
    public String listEmployee(){
        return null;
    }

    @PostMapping(value = "/create")
    public String createEmployee(){
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateEmployee(){
        return null;
    }

    @DeleteMapping(value = "/delete") //eteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteEmployee(){
        return null;
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
        return employeeOptional.map(employee -> new ResponseEntity<>(employee, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR));
    }

    /*
        Created by KhaiTT
        Date: 15:34 01/06/2022
        Function: This method update personal information of employee.
    */
    @PutMapping(value = "/personal/information/update")
    public ResponseEntity<Map<String, String>> updatePersonalInformation(@Valid @RequestBody PersonalDto personalDto,
                                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
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
    @PutMapping(value = "/personal/change-password")
    public ResponseEntity<Account> changePersonalPassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        Account account = jwtFilter.findAccountByJwtToken();
        if (encoder.matches(changePasswordRequest.getCurrentPassword(), account.getEncryptPassword()) &&
                changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmNewPassword())) {
            String encryptPassword = encoder.encode(changePasswordRequest.getNewPassword());
            iAccountRepository.changPassword(encryptPassword, account.getId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
