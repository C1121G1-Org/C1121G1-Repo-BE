package api.controllers;

import api.dto.CustomerDto;
import api.models.Customer;
import api.models.ResponseObject;
import api.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    ICustomerService iCustomerService;

    /*
    Created By hoangDH,
    Time: 15:00 PM 2022-06-01
    Function: find customer object by id from database
    */
    @GetMapping(value="/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer customer=iCustomerService.findById(id).orElse(null);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }



    @PostMapping(value = "/create")
    public String createCustomer(){
        return null;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Customer>> listCustomer(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> keyName,
                                                       @RequestParam Optional<String> keyPhone) {
        String keyNameValue = keyName.orElse("");
        String keyPhoneValue = keyPhone.orElse("");

        Page<Customer> customerPage = iCustomerService.findAllCustomer(pageable, keyNameValue, keyPhoneValue);
        if (customerPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    /*
    Created By hoangDH,
    Time: 12:38 PM 2022-06-01
    Function: edit object by id from database
    */

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> updateCustomer(@Valid @RequestBody CustomerDto customerDto,
                                               @PathVariable("id") Long id,
                                               BindingResult bindingResult){
        Customer customer = new Customer();
        customer=iCustomerService.findById(id).orElse(null);

        if(customer==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            Map<String, String> errorMap = new HashMap<>();
            if(bindingResult.hasErrors()){
                bindingResult.getFieldErrors()
                        .stream().forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
                return new ResponseEntity<>(new ResponseObject(false,"Failed!", errorMap, new ArrayList()),
                        HttpStatus.BAD_REQUEST);
            }
            customerDto.setId(id);
            BeanUtils.copyProperties(customerDto, customer);
            iCustomerService.editCustomer(customer,id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteCustomer(){
        return null;
    }



}
