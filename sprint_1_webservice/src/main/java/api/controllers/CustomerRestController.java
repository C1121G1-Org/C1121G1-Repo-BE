package api.controllers;


import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;

import api.models.Customer;

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
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/customer")
public class CustomerRestController {

    @Autowired
    ICustomerService iCustomerService;

    /*
          Created by tamHT
          Time: 18:15 31/05/2022
          Function: get  all page customer and search of customer
      */
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Customer>> listCustomer(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> keyName,
                                                       @RequestParam Optional<String> keyPhone) {
        String keyNameValue = keyName.orElse("");
        String keyPhoneValue = keyPhone.orElse("");

        Page<Customer> customerPage = iCustomerService.findAllCustomer(pageable, keyNameValue, keyPhoneValue);
        if (customerPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }
    /*
          Created by tamHT
          Time: 18:15 31/05/2022
          Function: get customer By ID
      */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id) {
        Customer customer = iCustomerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
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
