package api.controllers;

import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/list")
    public String listProduct(){
        return null;
    }

    @PostMapping(value = "/create")
    public String createProduct(){
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateProduct(){
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteProduct(){
        return null;
    }
}
