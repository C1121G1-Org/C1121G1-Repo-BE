package api.controllers;

import api.dto.ProductDto;
import api.models.Product;
import api.services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.Map;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: list all Products from DB
    */
//    @GetMapping(value = "/list")
//    public List<Product> listProduct() {
//        return iProductService.getAllProduct();
//    }

    /*
          Created by tamHT
          Time: 18:15 31/05/2022
          Function: get  all page product and search of product
      */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Product>> findAllProduct(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> keyName,
                                                        @RequestParam Optional<String> keyPrice,
                                                        @RequestParam Optional<String> keyQuantity) {
        String keyNameValue = keyName.orElse("");
        String keyQuantityValue = keyQuantity.orElse("");
        String keyPriceValue = keyPrice.orElse("");

        Page<Product> productPage = iProductService.findAllProduct(pageable, keyNameValue, keyPriceValue, keyQuantityValue);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public String createProduct() {
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateProduct() {
        return null;
    }

    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: create new product
 */
//    @PostMapping(value = "/create")
//    public ResponseEntity<Map<String, String>> createProduct(@Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {
//        Map<String, String> mapErrors = null;
//        if (bindingResult.hasFieldErrors()) {
////        mapErrors = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(e -> e.getField(), e -> e.getDefaultMessage()));
//        }
//        Product product = new Product();
//        BeanUtils.copyProperties(productDto, product);
//        this.iProductService.save(product);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    /*
     Created by tamHT
     Time: 18:15 31/05/2022
     Function: findById
 */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Optional<Product> product = this.iProductService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: edit product
 */
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
