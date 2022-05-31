package api.controllers;

import api.models.Supplier;
import api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/supplier")
public class SupplierRestController {

    @Autowired
    ISupplierService iSupplierService;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    getAllSupplier() = list all Suppliers from DB
                  2/    listSupplier() = list all Suppliers from DB with paging and search
    */
    private List<Supplier> getAllSupplier(){
        return iSupplierService.getAllSupplier();
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Supplier>> listSupplier(@PageableDefault(value = 3) Pageable pageable,
                                                      @RequestParam(name = "su", required = false, defaultValue = "") String supplier,
                                                      @RequestParam(name = "ad", required = false, defaultValue = "") String address,
                                                      @RequestParam(name = "ph", required = false, defaultValue = "") String phone,
                                                      @RequestParam(name = "em", required = false, defaultValue = "") String email){
        Page<Supplier> suppliers =iSupplierService.getAllSupplierPagingAndSearch(pageable, supplier, address, phone, email);
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public String createSupplier(){
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateSupplier(){
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteSupplier(){
        return null;
    }
}
