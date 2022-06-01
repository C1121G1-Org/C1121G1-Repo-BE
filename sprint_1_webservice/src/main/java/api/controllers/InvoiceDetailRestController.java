package api.controllers;

import api.dto.IProductBestsellerDto;
import api.dto.InvoiceDetailDto;
import api.dto.ProductInvoiceDto;
import api.models.*;
import api.services.ICustomerService;
import api.services.IInvoiceDetailService;
import api.services.IInvoiceService;
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
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors()
                    .stream().forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }
        if (invoiceDetailDto.getProductInvoiceDtoList().isEmpty()){
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(invoiceDetailDto.getInvoiceDto().getCustomerDto(), customer);
        if (invoiceDetailDto.getInvoiceDto().getCustomerDto().getId() == null) {
            iCustomerService.createCustomer(customer);
            customer = iCustomerService.getNewCustomer();
        }
            Invoice invoice = new Invoice();
            BeanUtils.copyProperties(invoiceDetailDto.getInvoiceDto(), invoice);
            invoice.setCustomer(customer);
            iInvoiceService.saveNewInvoice(invoice);
            Invoice newInvoice = iInvoiceService.getNewInvoice();

            List<ProductInvoiceDto> list = invoiceDetailDto.getProductInvoiceDtoList();
            for (int i = 0; i < list.size(); i++) {
                Long quantity = list.get(i).getQuantity();
                Long productId = list.get(i).getProductId();
                iInvoiceDetailService.createInvoiceDetail(quantity, productId, newInvoice.getId());
            }
            return new ResponseEntity<>(HttpStatus.OK);

    }
}
