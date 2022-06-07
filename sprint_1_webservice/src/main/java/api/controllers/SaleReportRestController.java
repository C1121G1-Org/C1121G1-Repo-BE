package api.controllers;

/*
    Created by HauPV
    Time: 19:16 31/05/2022
    Function: display list sale report
    Role : Admin , Business Staff
=======
<<<<<<< HEAD
<<<<<<< HEAD
    Role : Admin , Business Staff
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
    Role : Admin , Business Staff
>>>>>>> f1c93deb94322896c6f0a7413dba6a9c11bec107
=======
    Role : Admin , Business Staff
>>>>>>> ac3f8f86f7da4a6b078f7a2b93341c38566f3ea2
>>>>>>> 0cfab175adc0b788c3c20b43da5a74a2d13ae9e9
>>>>>>> manager-product
=======
>>>>>>> 536a668439894a3bc5c179a4dbd01a8c13b6966e
*/

import api.models.ISaleReport;
import api.models.Product;
<<<<<<< HEAD
import api.models.ProductQRCode;
=======
>>>>>>> manager-product
import api.services.ISaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======

>>>>>>> manager-product
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/sale-report")
public class SaleReportRestController {

    @Autowired
    ISaleReportService iSaleReportService;

    @GetMapping("")
    public ResponseEntity<List<ISaleReport>> saleReportList(@RequestParam(required = false, defaultValue = "1990-01-01") String startDay,
                                                            @RequestParam(required = false, defaultValue = "3000-01-01") String endDay,
                                                            @RequestParam(required = false, defaultValue = "") String productId) {
        List<ISaleReport> saleReportList = this.iSaleReportService.findAllSaleReports(startDay, endDay, productId);
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
