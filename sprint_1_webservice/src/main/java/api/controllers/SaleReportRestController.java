package api.controllers;

import api.models.ISaleReport;
import api.models.Product;
import api.models.ResponseObject;
import api.services.IProductService;
import api.services.ISaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
    Created by HauPV
    Time: 19:16 31/05/2022
    Function: display list sale report
    Role : Admin , Business Staff
*/



import java.util.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/sale-report")
public class SaleReportRestController {

    @Autowired
    ISaleReportService iSaleReportService;

    @Autowired
    IProductService iProductService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> saleReportList(@RequestParam(required = false, defaultValue = "1990-01-01") String startDay,
                                                         @RequestParam(required = false, defaultValue = "3000-01-01") String endDay,
                                                         @RequestParam(required = false, defaultValue = "") String productId) {
        if (productId.equals("")) {
            List<ISaleReport> saleReportList = this.iSaleReportService.findAllSaleReports(startDay, endDay, productId);
            if (saleReportList.size() < 1) {
                return new ResponseEntity<>(new ResponseObject(false, "Failed!", null, null), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(new ResponseObject(true, "OK", saleReportList), HttpStatus.OK);
        }

        if (!productId.matches("^(([0]*[1-9][0-9]*)|[1-9][0-9]*)$")) {
            Map<String, String> error = new HashMap<>();
            error.put("productId", "not found");
            return new ResponseEntity<>(new ResponseObject(false, "Not found Product", error, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }

        Optional<Product> product = this.iProductService.findById(Long.valueOf(productId));
        if (!product.isPresent() || product.get() == null) {
            Map<String, String> error = new HashMap<>();
            error.put("productId", "not found");
            return new ResponseEntity<>(new ResponseObject(false, "Not found Product", error, new ArrayList<>()), HttpStatus.BAD_REQUEST);
        }

        List<ISaleReport> saleReportList = this.iSaleReportService.findAllSaleReports(startDay, endDay, productId);
        if (saleReportList.size() < 1) {
            return new ResponseEntity<>(new ResponseObject(false, "Failed!", null, null), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new ResponseObject(true, "OK", saleReportList), HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<Product> getLatestProduct() {
        Product product = this.iSaleReportService.getLatestProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
