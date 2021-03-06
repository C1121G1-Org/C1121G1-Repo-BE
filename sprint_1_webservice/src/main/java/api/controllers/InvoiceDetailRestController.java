package api.controllers;

import api.dto.IProductBestsellerDto;
import api.dto.InvoiceDetailDto;
import api.dto.ProductInvoiceDto;
import api.models.Customer;
import api.models.Invoice;
import api.models.ResponseObject;
import api.models.Storage;
import api.services.ICustomerService;
import api.services.IInvoiceDetailService;
import api.services.IInvoiceService;
import api.services.IStorageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/invoiceDetail")
public class InvoiceDetailRestController {
    @Autowired
    private IInvoiceDetailService iInvoiceDetailService;
    @Autowired
    private IInvoiceService iInvoiceService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IStorageService iStorageService;

    //Create by chienLV
    //Time: 18h00 31/05/2022
    //Function: get list product bestseller from database
    @GetMapping("/listProductBestseller")
    public ResponseEntity<List<IProductBestsellerDto>> getListProductBestseller() {
        List<IProductBestsellerDto> productBestsellers = iInvoiceDetailService.findListProductBestseller();
        if (productBestsellers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productBestsellers, HttpStatus.OK);
    }

    //Create by chienLV
    //Time: 7h00 07/06/2022
    //Function: get list product newest from database
    @GetMapping("/listProductNewest")
    public ResponseEntity<List<IProductBestsellerDto>> getListProductNewest() {
        List<IProductBestsellerDto> productNewests = iInvoiceDetailService.findListProductNewest();
        if (productNewests.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productNewests, HttpStatus.OK);
    }

    //Create by chienLV
    //Time: 14h00 07/06/2022
    //Function: find list product bestseller by category from database
    @GetMapping("/listProductBestseller/{id}")
    public ResponseEntity<List<IProductBestsellerDto>> getListProductBestsellerByCategory(@PathVariable int id) {
        List<IProductBestsellerDto> productBestsellerByCategories = iInvoiceDetailService.findListProductBestsellerByCategory(id);
        if (productBestsellerByCategories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productBestsellerByCategories, HttpStatus.OK);
    }

    /*
         Created by LongNHL
         Time: 9:30 1/06/2022
         Function: create invoiceDetail
         Role: Admin, seller
     */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createInvoiceDetail(@Valid @RequestBody InvoiceDetailDto invoiceDetailDto,
                                                              BindingResult bindingResult) {
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .stream().forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(invoiceDetailDto.getCustomerDto(), customer);
        if (invoiceDetailDto.getCustomerDto().getId() == null) {
            iCustomerService.createCustomer(customer);
            customer = iCustomerService.getNewCustomer();
        }
        Invoice invoice = new Invoice();
        invoice.setTotalMoney(invoiceDetailDto.getTotalMoney());
        invoice.setPayments(invoiceDetailDto.getPayments());
        invoice.setCustomer(customer);
        iInvoiceService.saveNewInvoice(invoice);

        Invoice newInvoice = iInvoiceService.getNewInvoice();
        List<ProductInvoiceDto> list = invoiceDetailDto.getProducts();
        for (int i = 0; i < list.size(); i++) {
            Long quantity = list.get(i).getQuantity();
            Long productId = list.get(i).getId();
            iInvoiceDetailService.createInvoiceDetail(quantity, productId, newInvoice.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /*
     Created by LongNHL
     Time: 22:30 1/06/2022
     Function: update quantity product
     */
    @PatchMapping("/updateQuantityProduct")
    public ResponseEntity<ResponseObject> updateQuantityProduct(@Valid @RequestBody InvoiceDetailDto invoiceDetailDto, BindingResult bindingResult) {
        String errorQuantity = "";
        Map<String, String> errorMap = new HashMap<>();
        if (!bindingResult.hasErrors()) {
            if (!invoiceDetailDto.getProducts().isEmpty()) {
                errorMap = checkListProduct(invoiceDetailDto.getProducts());
                if (errorMap.isEmpty()) {
                    for (ProductInvoiceDto productDto : invoiceDetailDto.getProducts()) {
                        Optional<Storage> storages = iStorageService.getStorageByIdProduct(productDto.getId());
                        Storage storage = storages.orElse(null);
                        storage.setQuantity(storage.getQuantity() - productDto.getQuantity());
                        iStorageService.updateQuantityProduct(storage);
                    }
                    return new ResponseEntity<>(HttpStatus.OK);
                }else {
                    return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList()),
                            HttpStatus.BAD_REQUEST);
                }
            } else {
                errorQuantity = "B???n ch??a ch???n s???n ph???m";
                errorMap.put("productList", errorQuantity);
                return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList()),
                        HttpStatus.BAD_REQUEST);
            }
        } else {
            errorQuantity = "Vui l??ng nh???p ????? th??ng tin";
            errorMap.put("validProduct", errorQuantity);
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }
    }
    public Map<String,String> checkListProduct(List<ProductInvoiceDto> productList){
        String errorMesseger ="";
        Map<String, String> errorMap = new HashMap<>();
        for (int i = 0; i <= productList.size() - 1; i++) {
            Optional<Storage> storages = iStorageService.getStorageByIdProduct(productList.get(i).getId());
            Storage storage = storages.orElse(null);
            if (storage == null) {
                errorMesseger = "S??? l?????ng s???n ph???m " + productList.get(i).getName() + " kh??ng c?? trong kho. Vui l??ng ch???n s???n ph???m kh??c!";
                errorMap.put(String.valueOf(i), errorMesseger);
            } else if (productList.get(i).getQuantity() > storage.getQuantity()) {
                errorMesseger = "S??? l?????ng s???n ph???m " + storage.getProduct().getName() + " trong kho c??n: " + storage.getQuantity();
                errorMap.put(String.valueOf(i), errorMesseger);
            }
        }
        return errorMap;
    }
}