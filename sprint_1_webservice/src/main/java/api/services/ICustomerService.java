package api.services;

import api.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;

import java.util.Optional;

import java.util.Optional;

public interface ICustomerService {

       /*
Created By hoangDH,
Time: 12:38 PM 2022-06-01
Function: edit object by id from database
 */

    void editCustomer(Customer customer, Long id);

    /*
Created By hoangDH, TamHT
Time: 13:42 PM 2022-06-01
Function: find customer object by id from database
 */

    Optional<Customer> findById(Long id);


    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show all list report customer
    */
    Page<ReportCustomerDto> filterAll(Pageable pageable);

    /*
        Created by TuanNQ
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by gender
    */
    Page<ReportCustomerDto> filterByGender(Pageable pageable, Boolean gender);

    /*
        Created by TuanNQ
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by age
    */
    Page<ReportCustomerDto> filterByAge(Pageable pageable, Integer age);

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, Integer age);

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    Page<PurchaseHistoryDto> detailPurchaseHistory(Long id, Pageable pageable);

    /*
          Created by tamHT
          Time: 18:15 31/05/2022
          Function: get  all page customer and search of customer
      */
    Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2);



    /*
       Created by LongNHL
       Time: 21:30 31/05/2022
       Function: get customer
       */

    void createCustomer(Customer customer);

       /*
       Created by LongNHL
       Time: 21:30 31/05/2022
       Function: get customer
       */
    Customer getNewCustomer();



}
