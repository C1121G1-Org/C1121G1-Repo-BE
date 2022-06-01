package api.controllers;

import api.dto.PersonalDto;
import api.models.Account;
import api.models.Employee;
import api.payload.request.ChangePasswordRequest;
import api.repositories.IAccountRepository;
import api.security.JwtFilter;
import api.services.IAccountService;
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

}
