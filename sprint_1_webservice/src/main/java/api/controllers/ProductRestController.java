package api.controllers;

import api.dto.ProductDto;
import api.models.Product;
import api.models.ResponseObject;
import api.services.IProductService;
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
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/list")
    public String listProduct() {
        return null;
    }

    /*
    Created by TuanPA
    Date: 17:08 31/05/2022
    Function: Create product
*/

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createProduct(@Valid @RequestBody ProductDto productDto,
                                                        BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();

        if (bindingResult.hasFieldErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        product.setDeleteFlag(false);

        this.iProductService.save(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {

        Product product = this.iProductService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();

        if (bindingResult.hasFieldErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }


        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        this.iProductService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteProduct() {
        return null;
    }
}
