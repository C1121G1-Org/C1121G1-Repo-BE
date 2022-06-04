package api.controllers;

import api.dto.ProductDto;
import api.models.Product;
import api.models.ResponseObject;
import api.services.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.*;


import org.springframework.validation.BindingResult;

import javax.validation.Valid;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;


//    @GetMapping(value = "/list")
//    public ResponseEntity<Page<Product>>findAllProduct(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> keyName,
//                                                       @RequestParam Optional<String> keyPhone) {
//    /*
//        Created by khoaVC
//        Time: 21:54 31/05/2022
//        Function: list all Products from DB
//    */

//    @GetMapping(value = "/list")
//    public List<Product> listProduct() {
//        return iProductService.getAllProduct();
//    }

    /*
          Created by tamHT and hieuMMT
>>>>>>> f1c93deb94322896c6f0a7413dba6a9c11bec107

    /*
          Created by tamHT and hieuMMT
          Time: 18:15 31/05/2022
          Function: get  all page product and search of product
      */
    @GetMapping(value = "/listProduct")
    public ResponseEntity<Page<Product>> findAllProduct(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> keyName,
                                                        @RequestParam Optional<String> keyPhone,
                                                        @RequestParam Optional<String> keyQuality) {
        String keyNameValue = keyName.orElse("");
        String keyPhoneValue = keyPhone.orElse("");
        String keyQualityValue = keyQuality.orElse("");

        Page<Product> productPage = iProductService.findAllProduct(pageable, keyNameValue, keyPhoneValue, keyQualityValue);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }



//    @PostMapping(value = "/create")
//    public String createProduct() {
//        return null;
//    }


//    @PostMapping(value = "/create")
//    public String createProduct() {
//        return null;
//    }





    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: create new product
 */

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createProduct(@Valid @RequestBody ProductDto productDto,
                                                        BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        ProductDto productDtoErrors = new ProductDto();
        productDtoErrors.setIProductService(iProductService);
        productDtoErrors.validate(productDto,bindingResult);
//        productDto.validate(productDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }
//        change price of Dto become Double
        Double price = Double.valueOf(productDto.getPrice());
        Product product = new Product();

        BeanUtils.copyProperties(productDto, product);
        product.setPrice(price);
        product.setDeleteFlag(false);

        this.iProductService.save(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     Created by tuanPA
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
        Double price = Double.valueOf(productDto.getPrice());
        product.setPrice(price);
        BeanUtils.copyProperties(productDto, product);

        this.iProductService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     Created by hieuMMT
     Time: 14:15 1/06/2022
     Function: delete product
 */
//    @PatchMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
//    public void deleteProduct(Long id) {
//         this.iProductService.deleteFlag(id);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

//        Product product = iProductService.findById(id);
        Optional<Product> product = iProductService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iProductService.deleteFlag(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /*
         Created by LongNHL
         Time: 15:00 2/06/2022
         Function: use test create invoiec
     */
    @GetMapping(value = {"/listTest"})
    public ResponseEntity<List<Product>> showListCustomer() {
        List<Product> productTest = iProductService.findAllTest();
        return new ResponseEntity<>(productTest, HttpStatus.OK);
    }

}
