package api.controllers;

import api.dto.StorageDto;
import api.models.*;
import api.services.IEmployeeService;
import api.services.IProductService;
import api.services.IStorageService;
import api.services.ISupplierService;
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
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/storage")
public class StorageRestController {

    @Autowired
    IStorageService iStorageService;

    @Autowired
    IProductService iProductService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    ISupplierService iSupplierService;

    /*
        Created by khoaVC
        Role: Storekeeper, Admin
        Time: 21:54 31/05/2022
        Function:
                  1/    createStorage() = create Storage
    */

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseObject> createStorage(@Valid @RequestBody StorageDto storageDto, BindingResult bindingResult) {
        storageDto.validate(storageDto, bindingResult);
        Map<String, String> errorMap = new HashMap<>();
        if (bindingResult.hasFieldErrors()) {
            bindingResult
                    .getFieldErrors()
                    .stream()
                    .forEach(f -> errorMap.put(f.getField(), f.getDefaultMessage()));
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        } else {
            Storage storage = new Storage();
            BeanUtils.copyProperties(storageDto, storage);
            Employee employee = iEmployeeService.findEmployee(storageDto.getCreatedEmployeeDto());
            Product product = iProductService.findProduct(storageDto.getProductDto());
            Supplier supplier = iSupplierService.findSupplier(storageDto.getSupplierDto());
            if (employee != null && product != null && supplier != null) {
                storage.setCreatedEmployee(employee);
                storage.setProduct(product);
                storage.setSupplier(supplier);
                if (!storageDto.getQuantity().trim().equals("")) {
                    storage.setQuantity(Long.parseLong(storageDto.getQuantity()));
                }
                iStorageService.createStorage(storage);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new ResponseObject(false, "Failed!", errorMap, new ArrayList<>()), HttpStatus.BAD_REQUEST);
    }
}
