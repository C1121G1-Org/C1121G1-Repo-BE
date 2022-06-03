package api.controllers;

/*
    Created by HauPV
    Time: 19:16 31/05/2022
    Function: display list sale report
*/

import api.models.ISaleReport;
import api.models.Product;
import api.services.ISaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/sale-report")
public class SaleReportRestController {

    @Autowired
    ISaleReportService iSaleReportService;

    @GetMapping("")
    public ResponseEntity<List<ISaleReport>> saleReportList() {
        List<ISaleReport> saleReportList = this.iSaleReportService.findAllSaleReports();
        if (saleReportList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(saleReportList, HttpStatus.OK);
    }

}
