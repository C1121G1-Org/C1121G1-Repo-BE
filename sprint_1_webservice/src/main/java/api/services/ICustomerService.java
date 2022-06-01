package api.services;


import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;

import api.models.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show all list report customer
    */
    Page<ReportCustomerDto> filterAll(Pageable pageable);

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, String age);

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    Page<PurchaseHistoryDto> detailPurchaseHistory(Long id, Pageable pageable);

    Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2);

    Customer findById(long id);

}
