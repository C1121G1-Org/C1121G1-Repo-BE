package api.controllers;

/*
    Created by HauPV
    Time: 19:16 31/05/2022
    Function: display list sale report
    Role : Admin , Business Staff
*/

import api.models.ISaleReport;
import api.services.ISaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
