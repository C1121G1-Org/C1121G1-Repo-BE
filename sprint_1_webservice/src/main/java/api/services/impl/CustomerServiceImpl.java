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
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }
}