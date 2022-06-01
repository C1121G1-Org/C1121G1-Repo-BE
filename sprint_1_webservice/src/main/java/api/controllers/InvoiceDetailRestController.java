package api.controllers;

import api.dto.InvoiceDetailDto;
import api.models.Invoice;
import api.models.InvoiceDetail;
import api.models.ResponseObject;
import api.services.IInvoiceDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/invoiceDetail")
public class InvoiceDetailRestController {
    @Autowired
    private IInvoiceDetailService iInvoiceDetailService;

    /*
     Created by LongNHL
     Time: 21:30 31/05/2022
     Function: create invoiceDetail
     */
    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createInvoiceDetail(@RequestBody InvoiceDetailDto invoiceDetailDto,
                                                              BindingResult bindingResult){
        Map<String, String> errorMap = new HashMap<>();
        if(bindingResult.hasErrors()){
            bindingResult.getFieldErrors()
                    .stream().forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false,"Failed!", errorMap, new ArrayList()),
                    HttpStatus.BAD_REQUEST);
        }
//        InvoiceDetail invoiceDetail = new InvoiceDetail();
//        BeanUtils.copyProperties(invoiceDetailDto, invoiceDetail);
//        iInvoiceDetailService.createNewInvoiceDetail(invoiceDetail);
         iInvoiceDetailService.createInvoiceDetail(invoiceDetailDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
