package api.controllers;

import api.dto.ProductDto;
import api.models.Product;
import api.services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "/list")
    public String listProduct() {
        return null;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Map<String, String>> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        Map<String, String> mapErrors = null;
        if (bindingResult.hasFieldErrors()) {
//        mapErrors = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        this.iProductService.save(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = this.iProductService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {

        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);

        this.iProductService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteProduct() {
        return null;
    }
}
