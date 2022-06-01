package api.services.impl;

import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;
import api.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

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
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    @Override
    public Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, String age) {
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


    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2) {
        return iCustomerRepository.pageFindAll(pageable, key1, key2);
    }

    @Override
    public Customer findById(long id) {
        return iCustomerRepository.findById(id).get();
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
