package api.controllers;

import api.dto.CustomerDto;
import api.dto.PurchaseHistoryDto;
import api.dto.PurchaseProductDto;
import api.dto.ReportCustomerDto;
import api.models.Customer;
import api.models.ResponseObject;
import api.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

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
    public ResponseEntity<Page<Customer>> listCustomer(@PageableDefault(value =5) Pageable pageable, @RequestParam Optional<String> keyName,
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
    public ResponseEntity<Page<ReportCustomerDto>> showListReportCustomer(
            @PageableDefault(value = 5) Pageable pageable) {

        Page<ReportCustomerDto> reportCustomerDtoPage = iCustomerService.filterAll(pageable);

        if (reportCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(reportCustomerDtoPage, HttpStatus.OK);
    }

    /*
        Created by TuanNQ
        Time: 22:50 02/06/2022
        Function: Get info customer in customer report by customer_id
    */
    @GetMapping(value = "/info-customer/{id}")
    public ResponseEntity<ReportCustomerDto> getInfoCustomer(
            @PathVariable Long id) {

        ReportCustomerDto reportCustomerDto = iCustomerService.getInfoCustomer(id);

        if (reportCustomerDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(reportCustomerDto, HttpStatus.OK);
    }

    /*
        Created by TuanNQ
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by gender
    */
    @GetMapping(value = "/report-customer-search-gender")
    public ResponseEntity<Page<ReportCustomerDto>> showListReportCustomerSearchGender(
            @PageableDefault(value = 5) Pageable pageable, @RequestParam Boolean gender) {

        Page<ReportCustomerDto> reportCustomerDtoPage =
                iCustomerService.filterByGender(pageable, gender);

        if (reportCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(reportCustomerDtoPage, HttpStatus.OK);
    }

    /*
        Created by TuanNQ
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by age
    */
    @GetMapping(value = "/report-customer-search-age")
    public ResponseEntity<Page<ReportCustomerDto>> showListReportCustomerSearchAge(
            @PageableDefault(value = 5) Pageable pageable, @RequestParam Integer age) {

        Page<ReportCustomerDto> reportCustomerDtoPage =
                iCustomerService.filterByAge(pageable, age);

        if (reportCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(reportCustomerDtoPage, HttpStatus.OK);
    }

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    @GetMapping(value = "/report-customer-search")
    public ResponseEntity<Page<ReportCustomerDto>> showListReportCustomerSearch(
            @PageableDefault(value = 5) Pageable pageable, @RequestParam Boolean gender,
            @RequestParam Integer age) {

        Page<ReportCustomerDto> reportCustomerDtoPage =
                iCustomerService.filterByGenderAndAge(pageable, gender, age);

        if (reportCustomerDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(reportCustomerDtoPage, HttpStatus.OK);
    }

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    @GetMapping(value = "/purchase-history/{id}")
    public ResponseEntity<Page<PurchaseHistoryDto>> showDetailPurchaseHistory(
            @PathVariable(value = "id") Long id,
            @RequestParam(value = "startDate", defaultValue = "01-01-1900") String startDate,
            @RequestParam(value = "endDate", defaultValue = "31-12-2100") String endDate,
            @PageableDefault(value = 5) Pageable pageable) {

        Page<PurchaseHistoryDto> purchaseHistoryDtoPage =
                iCustomerService.detailPurchaseHistory(id, startDate, endDate, pageable);

        if (purchaseHistoryDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(purchaseHistoryDtoPage, HttpStatus.OK);
        }
    }

    /*
        Created by TuanNQ
        Time: 11:00 02/06/2022
        Function: Show all purchase products by ivoice.id
    */
    @GetMapping(value = "/purchase-products/{id}")
    public ResponseEntity<Page<PurchaseProductDto>> showPurchaseProducts(
            @PathVariable Long id, @PageableDefault(value = 5) Pageable pageable) {

        Page<PurchaseProductDto> purchaseProductDtoPage = iCustomerService.getPurchaseProducts(id, pageable);

        if (purchaseProductDtoPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(purchaseProductDtoPage, HttpStatus.OK);
        }
    }

}
