package api.services.impl;

import api.models.Customer;
import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

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
