package api.controllers;

import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    ICustomerService iCustomerService;


    @GetMapping(value = "/list")
    public String listCustomer(){
        return null;
    }

    @PostMapping(value = "/create")
    public String createCustomer(){
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateCustomer(){
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteCustomer(){
        return null;
    }


}
