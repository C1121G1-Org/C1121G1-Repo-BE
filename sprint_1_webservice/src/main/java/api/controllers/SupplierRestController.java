package api.controllers;

import api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/supplier")
public class SupplierRestController {

    @Autowired
    ISupplierService iSupplierService;

    @GetMapping(value = "/list")
    public String listSupplier(){
        return null;
    }

    @PostMapping(value = "/create")
    public String createSupplier(){
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateSupplier(){
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteSupplier(){
        return null;
    }
}
