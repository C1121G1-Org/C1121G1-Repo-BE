package api.controllers;

import api.services.IProductService;
import api.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/storage")
public class StorageRestController {

    @Autowired
    IStorageService iStorageService;

    @Autowired
    IProductService iProductService;


    @GetMapping(value = "/list")
    public String listStorage(){
        return null;
    }

    @PostMapping(value = "/create")
    public String createStorage(){
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateStorage(){
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteStorage(){
        return null;
    }
}
