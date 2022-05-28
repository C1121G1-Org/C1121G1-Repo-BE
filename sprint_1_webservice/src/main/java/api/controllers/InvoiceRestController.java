package api.controllers;

import api.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/invoice")
public class InvoiceRestController {

    @Autowired
    IInvoiceService iInvoiceService;

    @GetMapping(value = "/list")
    public String listInvoice(){
        return null;
    }

    @PostMapping(value = "/create")
    public String createInvoice(){
        return null;
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
