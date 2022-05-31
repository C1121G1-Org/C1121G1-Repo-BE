package api.controllers;

import api.models.Product;
import api.services.IProductService;
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
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Product>>findAllProduct(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> keyName,
                                                       @RequestParam Optional<String> keyPhone) {
        String keyNameValue = keyName.orElse("");
        String keyPhoneValue = keyPhone.orElse("");

        Page<Product> productPage = iProductService.findAllProduct(pageable, keyNameValue, keyPhoneValue);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
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
