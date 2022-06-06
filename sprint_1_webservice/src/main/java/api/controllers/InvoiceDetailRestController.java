package api.controllers;

import api.dto.IProductBestsellerDto;
import api.dto.InvoiceDetailDto;

import api.dto.ProductInvoiceDto;
import api.models.*;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
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


    /*
     Created by LongNHL
     Time: 9:30 1/06/2022
     Function: create invoiceDetail
     */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createInvoiceDetail(@Valid @RequestBody InvoiceDetailDto invoiceDetailDto,
                                                              BindingResult bindingResult) {
        System.out.println(invoiceDetailDto);
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
        System.out.println(invoice);

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
    public ResponseEntity<ResponseObject> updateQuantityProduct(@Valid @RequestBody InvoiceDetailDto invoiceDetailDto,BindingResult bindingResult) {
        String errorQuantity = "";
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .stream().forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }
        if (!invoiceDetailDto.getProducts().isEmpty()) {
            for (ProductInvoiceDto productDto : invoiceDetailDto.getProducts()) {
                Storage storage = iStorageService.getStorageByIdProduct(productDto.getId());
                if (productDto.getQuantity() > storage.getQuantity()) {
                    errorQuantity = "Số lượng sản phẩm "+ storage.getProduct().getName() +" trong kho còn: " + storage.getQuantity();
                    errorMap.put("quantity",errorQuantity);
                    return new ResponseEntity<>(new ResponseObject(false,"Failed!",errorMap,new ArrayList()),
                            HttpStatus.BAD_REQUEST);
                } else {
                    storage.setQuantity(storage.getQuantity() - productDto.getQuantity());
                    iStorageService.updateQuantityProduct(storage);
                }
            }
            return new ResponseEntity<>( HttpStatus.OK);
        }
        errorQuantity = "Bạn chưa chọn sản phẩm";
        errorMap.put("productList",errorQuantity);
        return new ResponseEntity<>(new ResponseObject(false,"Failed!",errorMap,new ArrayList()),
                HttpStatus.BAD_REQUEST);
    }

}
