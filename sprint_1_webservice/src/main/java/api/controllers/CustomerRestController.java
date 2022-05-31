package api.controllers;

import api.models.Customer;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    ICustomerService iCustomerService;


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

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customer = iCustomerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
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
