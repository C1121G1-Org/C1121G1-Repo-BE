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

    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.saveCustomer(customer.getCustomerName(), customer.getPhoneNumber(),
                customer.getDateOfBirth(), customer.getEmail(), customer.getAddress(), customer.isGender());
    }

    @Override
    public Customer findCustomer(Customer customer) {
        return iCustomerRepository.findCustomer(customer.getCustomerName(),customer.getPhoneNumber(),customer.getDateOfBirth());
    }
}
