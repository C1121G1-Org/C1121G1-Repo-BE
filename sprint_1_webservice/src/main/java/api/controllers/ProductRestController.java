package api.controllers;

import api.dto.IProductDto;
import api.dto.ProductDto;
import api.models.Category;
import api.models.Product;
import api.models.ResponseObject;
import api.services.ICategoryService;
import api.services.IProductService;
import api.services.ISaleReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    IProductService iProductService;
    @Autowired
    ICategoryService iCategoryService;

    /*
      Created by HauPV
      Time: 20:20 04/06/2022
      Function: QRCode Create with new Product
    */
    @Autowired
    ISaleReportService iSaleReportService;


    /*
        Created by tamHT and hieuMMT
        Time: 18:15 31/05/2022
        Function: get all page product and search of product
        Role : Admin, business staff, seller
     */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<IProductDto>> findAllProduct(@PageableDefault(value = 10) Pageable pageable, @RequestParam Optional<String> keyName,
                                                            @RequestParam(value = "keyPrice", defaultValue = "1000000000000000000000000000000000", required = false) String keyPrice,
                                                            @RequestParam(value = "keyQuantity", defaultValue = "0", required = false) String keyQuantity,
                                                            @RequestParam(value = "keySort", defaultValue = "priceDesc", required = false) String keySort){
        String keyNameValue = keyName.orElse("");
        Page<IProductDto> productPage = iProductService.findAllProduct(pageable, keyNameValue, keyPrice, keyQuantity,keySort);
        if (productPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productPage, HttpStatus.OK);
    }


    /*
         Created by tuanPA
         Time: 18:15 31/05/2022
         Function: create new product
         Role: Admin, business staff
    */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createProduct(@Valid @RequestBody ProductDto productDto,
                                                        BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        ProductDto productDtoErrors = new ProductDto();
        productDtoErrors.setIProductService(iProductService);


        productDtoErrors.validate(productDto, bindingResult);
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
        Category category = new Category();
        BeanUtils.copyProperties(productDto.getCategoryDto(), category);
        product.setCategory(category);
        product.setPrice(price);
        product.setDeleteFlag(false);

        this.iProductService.save(product);


     /*
        Created by HauPV
        Time: 20:20 04/06/2022
        Function: Create QRCode on local storage => D:/qrcode
    */
//        Product latestProduct = this.iSaleReportService.getLatestProduct();
//        ProductQRCode productQRCode = new ProductQRCode();
//        BeanUtils.copyProperties(latestProduct, productQRCode);
//        QRCodeUtils.encode(productQRCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: findById
     Role: Admin, business staff
 */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Optional<Product> product = this.iProductService.findById(id);
        if (product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: edit product
     Role: Admin, business staff
 */
    @PatchMapping(value = "/update/{id}")
    public ResponseEntity<ResponseObject> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDto productDto, BindingResult bindingResult) {

        Map<String, String> errorMap = new HashMap<>();
        if (!this.iProductService.findById(id).isPresent()) {
            return new ResponseEntity<>(new ResponseObject(false, "Id ís not exist!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }
        productDto.setIProductService(iProductService);

        String inputtedProductName = productDto.getName();
        Optional<Product> currentProduct = this.iProductService.findById(id);


        if (!currentProduct.get().getName().equalsIgnoreCase(inputtedProductName)) {
            productDto.validate(productDto, bindingResult);
        }

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

        Category category = new Category();
        BeanUtils.copyProperties(productDto.getCategoryDto(), category);
        product.setCategory(category);


    /*
        Created by HauPV
        Time: 20:20 04/06/2022
        Function: Update QRCode base on Edited Product on local storage => D:/qrcode
    */
//        ProductQRCode productQRCode = new ProductQRCode();
//
//
//        BeanUtils.copyProperties(product, productQRCode);
//        QRCodeUtils.encode(productQRCode);

        this.iProductService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     Created by hieuMMT
     Time: 14:15 1/06/2022
     Function: delete product
     Role : Admin, bussines staff, seller
 */

    @PatchMapping("/delete/{id}")
    public ResponseEntity<?> deleteProductById(Optional<Product> product) {
        if (product.isPresent()) {
            iProductService.deleteFlag(product.get().getId());
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}