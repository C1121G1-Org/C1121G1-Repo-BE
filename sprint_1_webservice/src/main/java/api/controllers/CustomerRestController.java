package api.controllers;

import api.dto.CustomerDto;
import api.models.Customer;
import api.models.ResponseObject;
import api.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    /*
    Created by LongNHL
    Time: 11:30 31/05/2022
    Function: create invoice
    */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createCustomer(@Valid @RequestBody CustomerDto customerDto,
                                 BindingResult bindingResult){
        Map<String, String> errorMap = new HashMap<>();
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors()
                    .stream().forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false,"Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        iCustomerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
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
