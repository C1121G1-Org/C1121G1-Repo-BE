package api.services.impl;

import api.dto.PurchaseProductDto;
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
    Created by LongNHL
    Time: 21:30 31/05/2022
    Function: create customer

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
        Time: 22:50 02/06/2022
        Function: Get info customer in customer report by customer_id
    */
    @Override
    public ReportCustomerDto getInfoCustomer(Long id) {
        return iCustomerRepository.getInfoCustomer(id);
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
    public Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, String age) {
        return iCustomerRepository.filterByGenderAndAge(pageable, gender, age);
    }

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    @Override
    public Page<PurchaseHistoryDto> detailPurchaseHistory(Long id, String startDate, String endDate, Pageable pageable) {
        return iCustomerRepository.detail(id, startDate, endDate, pageable);
    }

    /*
        Created by TuanNQ
        Time: 11:00 02/06/2022
        Function: Show all purchase products by ivoice.id
    */
    @Override
    public Page<PurchaseProductDto> getPurchaseProducts(Long id, Pageable pageable) {
        return iCustomerRepository.getPurchaseProducts(id, pageable);
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
