package api.controllers;

import api.dto.CustomerDto;
import api.dto.InvoiceDto;
import api.models.Customer;
import api.models.Invoice;
import api.models.ResponseObject;
import api.services.ICustomerService;
import api.services.IInvoiceService;
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
@RequestMapping("/api/invoice")
public class InvoiceRestController {

    @Autowired
    IInvoiceService iInvoiceService;
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping(value = "/list")
    public String listInvoice(){
        return null;
    }

    /*
    Created by LongNHL
    Time: 21:30 31/05/2022
    Function: create invoice
    */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createInvoice(@Valid @RequestBody InvoiceDto invoiceDto, BindingResult bindingResult){
        Map<String, String> errorMap = new HashMap<>();
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors()
                    .stream().forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false,"Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }

//        Customer customer;
//        if(invoiceDto.getCustomer().getId() == null){
//            iCustomerService.createCustomer(invoiceDto.getCustomer());
//            customer = iCustomerService.findCustomer(invoiceDto.getCustomer());
//        }else {
//            customer = invoiceDto.getCustomer();
//        }
        Invoice invoice = new Invoice();
        BeanUtils.copyProperties(invoiceDto, invoice);
        invoice.setCustomer(invoiceDto.getCustomer());
        iInvoiceService.saveNewInvoice(invoice);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping(value = "/update")
    public String updateInvoice(){
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteInvoice(){
        return null;
    }
}
