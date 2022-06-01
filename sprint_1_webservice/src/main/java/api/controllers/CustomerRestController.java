package api.controllers;

import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    ICustomerService iCustomerService;


    @GetMapping(value = "/list")
    public String listCustomer() {
        return null;
    }

    @PostMapping(value = "/create")
    public String createCustomer() {
        return null;
    }

    @PatchMapping(value = "/update")
    public String updateCustomer() {
        return null;
    }

    @DeleteMapping(value = "/delete") //Nếu dùng deleteFlag thì phải dùng @PatchMapping để update lại deleteFlag
    public String deleteCustomer() {
        return null;
    }

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show all list report customer
    */
    @GetMapping(value = "/report-customer")
    public ResponseEntity<List<ReportCustomerDto>> showListReportCustomer(
            @PageableDefault Pageable pageable) {

        Page<ReportCustomerDto> reportCustomerDtoPage = iCustomerService.filterAll(pageable);

        if (reportCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        List<ReportCustomerDto> reportCustomerDtos = reportCustomerDtoPage.toList();
        return new ResponseEntity<>(reportCustomerDtos, HttpStatus.OK);
    }

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    @GetMapping(value = "/report-customer-search")
    public ResponseEntity<List<ReportCustomerDto>> showListReportCustomerSearch(
            @PageableDefault Pageable pageable, @RequestParam Boolean gender,
            @RequestParam String age) {

        Page<ReportCustomerDto> reportCustomerDtoPage =
                iCustomerService.filterByGenderAndAge(pageable, gender, age);

        if (reportCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        List<ReportCustomerDto> reportCustomerDtos = reportCustomerDtoPage.toList();
        return new ResponseEntity<>(reportCustomerDtos, HttpStatus.OK);
    }

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    @GetMapping(value = "/purchase-history/{id}")
    public ResponseEntity<List<PurchaseHistoryDto>> showDetailPurchaseHistory(
            @PathVariable Long id, @PageableDefault Pageable pageable) {

        Page<PurchaseHistoryDto> purchaseHistoryDtoPage = iCustomerService.detailPurchaseHistory(id, pageable);

        if (purchaseHistoryDtoPage.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            List<PurchaseHistoryDto> purchaseHistoryDtos = purchaseHistoryDtoPage.toList();
            return new ResponseEntity<>(purchaseHistoryDtos, HttpStatus.OK);
        }
    }

}
