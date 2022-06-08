package api.controllers;

import api.dto.HistoryInvoiceDto;
import api.models.Customer;
import api.models.Product;
import api.services.ICustomerService;
import api.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/invoice")
public class InvoiceRestController {

    @Autowired
    IInvoiceService iInvoiceService;
    @Autowired
    ICustomerService iCustomerService;

    @ModelAttribute("customer")
    private List<Customer> customerList() {
        return iInvoiceService.listCustomer();
    }

    @ModelAttribute("product")
    private List<Product> productList() {
        return iInvoiceService.listProduct();
    }

    /*
        Created by CongNV
        Date:  06/06/2022
        Function: find all history
        Role: Admin, seller
    */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<HistoryInvoiceDto>> list(@RequestParam(required = false, defaultValue = "") String keyword,
                                                        @RequestParam("page") Optional<Integer> page,
                                                        @RequestParam(defaultValue = "", required = false) String sort) {
        Pageable pageable = PageRequest.of(page.orElse(0), 3);
        Page<HistoryInvoiceDto> invoices = iInvoiceService.findAll(keyword, pageable, sort);
        if (invoices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(invoices, HttpStatus.OK);
    }
}