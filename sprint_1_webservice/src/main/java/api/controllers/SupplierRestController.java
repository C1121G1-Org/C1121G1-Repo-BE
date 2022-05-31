//package api.controllers;
//
//import api.services.ISupplierService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin("http://localhost:4200")
//@RequestMapping("/api/supplier")
//public class SupplierRestController {
//
//    @Autowired
//    ISupplierService iSupplierService;
//
//    @GetMapping(value = "/list")
//    public String listSupplier(){
//        return null;
//    }
//
//    @PostMapping(value = "/create")
//    public String createSupplier(){
//        return null;
//    }
//
//    @PatchMapping(value = "/update")
//    public String updateSupplier(){
//        return null;
//    }
//
//    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
//    public String deleteSupplier(){
//        return null;
//    }
//}

package api.controllers;


import api.dto.SupplierDto;
import api.models.ResponseObject;
import api.models.Supplier;
import api.services.ISupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin
@RequestMapping("/api/supplier")
public class SupplierRestController {

    @Autowired
    private ISupplierService iSupplierService;


//    @GetMapping("/list")
//    public ResponseEntity<List<Supplier>> getSupplierList() {
//        List<Supplier> supplierList = iSupplierService.findAll();
//        if (supplierList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(supplierList, HttpStatus.OK);
//    }

    /*
    Created by NgocTTB
    Time: 09:00 31/05/2022
    Function: Create Supplier
    */

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createSupplier(@Valid @RequestBody SupplierDto supplierDto,
                                                         BindingResult bindingResult) {
        supplierDto.setIsupplierService(iSupplierService);
        supplierDto.validate(supplierDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = bindingResult.getFieldErrors()
                    .stream().collect(Collectors.toMap(
                            e -> e.getField(), e -> e.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Supplier supplier = new Supplier();
        BeanUtils.copyProperties(supplierDto, supplier);
        iSupplierService.save(supplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @PatchMapping(value = "update/{id}")
//    public ResponseEntity<Map<String, String>> updateArticle(@PathVariable("id") Long id,
//                                                             @Valid @RequestBody SupplierDto supplierDto,
//                                                             BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errorMap = bindingResult.getFieldErrors()
//                    .stream().collect(Collectors.toMap(
//                            e -> e.getField(), e -> e.getDefaultMessage()));
//            return new ResponseEntity<>(errorMap, HttpStatus.OK);
//        }
//        Supplier supplier = new Supplier();
//        BeanUtils.copyProperties(supplierDto, supplier);
//        supplier.setId(id);
//        iSupplierService.save(supplier);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
//    public String deleteSupplier() {
//        return null;
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> findCustomerById(@PathVariable Long id) {
//        Supplier supplier = iSupplierService.findById(id);
//        if (supplier == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(supplier, HttpStatus.OK);
//    }
}
