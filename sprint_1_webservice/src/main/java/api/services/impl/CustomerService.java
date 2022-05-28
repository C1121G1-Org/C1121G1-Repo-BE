package api.services.impl;

import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;
}
