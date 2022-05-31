package api.services.impl;

import api.models.Customer;
import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2) {
        return iCustomerRepository.pageFindAll(pageable, key1, key2);
    }

    @Override
    public Customer findById(long id) {
        return iCustomerRepository.findById(id).get();
    }
}
