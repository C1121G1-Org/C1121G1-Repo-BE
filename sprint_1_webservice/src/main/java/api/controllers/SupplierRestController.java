
package api.controllers;

import api.dto.SupplierDto;
import api.models.ResponseObject;
import api.models.Supplier;
import api.services.ISupplierService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/supplier")
public class SupplierRestController {

    @Autowired
    private ISupplierService iSupplierService;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    getAllSupplier() = list all Suppliers from DB
                  2/    listSupplier() = list all Suppliers from DB with paging and search
    */
    private List<Supplier> getAllSupplier() {
        return iSupplierService.getAllSupplier();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Supplier>> listSupplier(@PageableDefault(value = 3) Pageable pageable,
                                                       @RequestParam(name = "su", required = false, defaultValue = "") String supplier,
                                                       @RequestParam(name = "ad", required = false, defaultValue = "") String address,
                                                       @RequestParam(name = "ph", required = false, defaultValue = "") String phone,
                                                       @RequestParam(name = "em", required = false, defaultValue = "") String email) {
        Page<Supplier> suppliers = iSupplierService.getAllSupplierPagingAndSearch(pageable, supplier, address, phone, email);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    /*
    Created by NgocTTB
    Time: 09:00 31/05/2022
    Function: Create Supplier
    */

    //    @PostMapping(value = "/create")
//    public ResponseEntity<ResponseObject> createSupplier(@Valid @RequestBody SupplierDto supplierDto,
//                                                         BindingResult bindingResult) {
//        Map<String, String> errorMap = bindingResult.getFieldErrors()
//                .stream().collect(Collectors.toMap(
//                        e -> e.getField(), e -> e.getDefaultMessage()));
//        supplierDto.setIsupplierService(iSupplierService);
//        supplierDto.validate(supplierDto, bindingResult);
////        supplierDto.validateEmail(supplierDto, bindingResult);
////        bindingResult.addError(new FieldError("supplierDto", "email", "Same email"));
//        if (bindingResult.hasErrors()) {
//            errorMap = bindingResult.getFieldErrors()
//                    .stream().collect(Collectors.toMap(
//                            e -> e.getField(), e -> e.getDefaultMessage()));
//        }
//        String supplierName = supplierDto.getSupplierName();
//        Supplier supplier = this.iSupplierService.findBySupplierName(supplierDto.getSupplierName());
//
//        if (supplier != null && supplier.getSupplierName().equals(supplierName)) {
//            errorMap.put("supplierName", "Tên nhà cung cấp đã tồn tại!");
//        }
//        String email = supplierDto.getSupplierName();
//       supplier = this.iSupplierService.findByEmail(supplierDto.getEmail());
//        if (supplier != null && supplier.getEmail().equals(email)) {
//                errorMap.put("email", "Email đã tồn tại!");
//                return new ResponseEntity<>(new ResponseObject(false, "Failed", errorMap, new ArrayList<>()), HttpStatus.INTERNAL_SERVER_ERROR);
//        }else {
//            supplier = new Supplier();
//            BeanUtils.copyProperties(supplierDto, supplier);
//            iSupplierService.save(supplier);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//
//    }
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
}