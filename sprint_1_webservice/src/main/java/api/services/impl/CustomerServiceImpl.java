package api.services.impl;

import api.models.Customer;
import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;
import api.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    /*
   Created By hoangDH,
   Role: admin, business staff
   Time: 12:38 PM 2022-06-01
   Function: edit object by id from database
    */
    @Override
    public void editCustomer(Customer customer, Long id) {
        iCustomerRepository.editCustomer(customer,id);
    }

    /*
    Created By hoangDH,TamHT
    Time: 13:42 PM 2022-06-01
    Role: admin, business staff
    Function: find customer object by id from database
    */
    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }



    /*
<<<<<<< HEAD
    Created by LongNHL
    Time: 21:30 31/05/2022
    Function: create customer
=======
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show all list report customer
    */
    @Override
    public Page<ReportCustomerDto> filterAll(Pageable pageable) {
        return iCustomerRepository.filterAll(pageable);
    }

    /*
        Created by TuanNQ
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by gender
    */
    @Override
    public Page<ReportCustomerDto> filterByGender(Pageable pageable, Boolean gender) {
        return iCustomerRepository.filterByGender(pageable, gender);
    }

    /*
        Created by TuanNQ
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by age
    */
    @Override
    public Page<ReportCustomerDto> filterByAge(Pageable pageable, Integer age) {
        return iCustomerRepository.filterByAge(pageable, age);
    }

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    @Override
    public Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, Integer age) {
        return iCustomerRepository.filterByGenderAndAge(pageable, gender, age);
    }

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    @Override
    public Page<PurchaseHistoryDto> detailPurchaseHistory(Long id, Pageable pageable) {
        return iCustomerRepository.detail(id, pageable);
    }

    /*
          Created by tamHT
          Time: 18:15 31/05/2022
          Function: get  all page customer and search of customer
      */
    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2) {
        return iCustomerRepository.pageFindAll(pageable, key1, key2);
    }



    /*
        Created by LongNHL
        Time: 21:30 31/05/2022
        Function: create customer
    */
    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.saveCustomer(customer.getCustomerName(), customer.getPhoneNumber(),
                customer.getDateOfBirth(), customer.getEmail(), customer.getAddress(), customer.isGender());
    }
    /*
    Created by LongNHL
    Time: 21:30 31/05/2022
    Function: get customer
    */
    @Override
    public Customer getNewCustomer() {
        return iCustomerRepository.getNewCreateCustomer();
    }




}
