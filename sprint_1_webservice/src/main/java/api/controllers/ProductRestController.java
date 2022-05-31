package api.controllers;

import api.models.Product;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: list all Products from DB
    */
    @GetMapping(value = "/list")
    public List<Product> listProduct(){
        return iProductService.getAllProduct();
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
