package api.controllers;

/*
    Created by HauPV
    Time: 19:16 31/05/2022
    Function: display list sale report
<<<<<<< HEAD
    Role : Admin , Business Staff
=======
<<<<<<< HEAD
=======
    Role : Admin , Business Staff
>>>>>>> f1c93deb94322896c6f0a7413dba6a9c11bec107
>>>>>>> eae306551dcd0a1721df875f610f33e8c48c5190
*/

import api.models.ISaleReport;
import api.models.Product;
import api.models.ProductQRCode;
import api.services.ISaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

>>>>>>> eae306551dcd0a1721df875f610f33e8c48c5190

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/sale-report")
public class SaleReportRestController {

    @Autowired
    ISaleReportService iSaleReportService;

    @GetMapping("")
<<<<<<< HEAD
=======

>>>>>>> eae306551dcd0a1721df875f610f33e8c48c5190
    public ResponseEntity<List<ISaleReport>> saleReportList(@RequestParam(required = false, defaultValue = "1990-01-01") String startDay,
                                                            @RequestParam(required = false, defaultValue = "3000-01-01") String endDay,
                                                            @RequestParam(required = false, defaultValue = "") String productId) {
        List<ISaleReport> saleReportList = this.iSaleReportService.findAllSaleReports(startDay, endDay, productId);
<<<<<<< HEAD
=======

>>>>>>> eae306551dcd0a1721df875f610f33e8c48c5190
        if (saleReportList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(saleReportList, HttpStatus.OK);
    }

    @GetMapping("/latest")
    public ResponseEntity<Product> getLatestProduct() {
        Product product = this.iSaleReportService.getLatestProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

}
