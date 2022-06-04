package api.services;

import api.dto.PurchaseHistoryDto;
import api.dto.PurchaseProductDto;
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
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by gender
    */
    Page<ReportCustomerDto> filterByGender(Pageable pageable, Boolean gender);

    /*
        Created by TuanNQ
        Time: 22:50 02/06/2022
        Function: Get info customer in customer report by customer_id
    */
    ReportCustomerDto getInfoCustomer(Long id);

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
    Page<PurchaseHistoryDto> detailPurchaseHistory(Long id, String startDate, String endDate, Pageable pageable);

    /*
        Created by TuanNQ
        Time: 11:00 02/06/2022
        Function: Show all purchase products by ivoice.id
    */
    Page<PurchaseProductDto> getPurchaseProducts(Long id, Pageable pageable);

    /*
          Created by tamHT
          Time: 18:15 31/05/2022
          Function: get  all page customer and search of customer
      */
    Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2);

    /*
             Created by tamHT
             Time: 18:15 31/05/2022
             Function: get customer By ID
         */
    Customer findById(long id);

    void createCustomer(Customer customer);

    Customer findCustomer(Customer customer);


}
