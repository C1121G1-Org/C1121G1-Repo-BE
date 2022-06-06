package api.controllers;

import api.models.Account;
import api.models.Employee;
import api.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityRestController {

    @Autowired
    IEmployeeService iEmployeeService;
    /*
        Created by KhaiTT
        Date: 22:37 31/05/2022
        Function: This method return Employee object by token of account.
    */
    @GetMapping(value = "/personal/information")
    public ResponseEntity<Employee> getPersonalInformation() {
        Employee employee = iEmployeeService.findEmployee(1L);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
