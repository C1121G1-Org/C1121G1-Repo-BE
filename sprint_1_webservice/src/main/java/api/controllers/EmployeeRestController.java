package api.controllers;

import api.services.IEmployeeService;
import api.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteEmployee(){
        return null;
    }

}
