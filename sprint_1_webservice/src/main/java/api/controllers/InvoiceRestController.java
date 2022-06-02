package api.controllers;

import api.dto.InvoiceDto;
import api.models.Customer;
import api.models.Invoice;
import api.models.Product;
import api.models.ResponseObject;
import api.services.ICustomerService;
import api.services.IInvoiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/invoice")
public class InvoiceRestController {

    @Autowired
    IInvoiceService iInvoiceService;
    @Autowired
    ICustomerService iCustomerService;

    @ModelAttribute("customer")
    private List<Customer> customerList(){
        return iInvoiceService.listCustomer();
    }

    @ModelAttribute("product")
    private List<Product> productList(){
        return iInvoiceService.listProduct();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Invoice>> list(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                                               @RequestParam("page") Optional<Integer> page,
                                               @RequestParam(defaultValue = "",required = false) String sort) {
        Pageable pageable = PageRequest.of(page.orElse(0), 10);
        Page<Invoice> invoices = iInvoiceService.findAll(keyword, pageable);
        if (invoices.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoices,HttpStatus.OK);
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
