package api.services.impl;

import api.models.Customer;
import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;
    /*
   Created By hoangDH,
   Time: 12:38 PM 2022-06-01
   Function: edit object by id from database
    */
    @Override
    public void editCustomer(Customer customer, Long id) {
        iCustomerRepository.editCustomer(customer.getAddress()
                ,customer.getCustomerName(),customer.getDateOfBirth()
                ,customer.getEmail(),customer.isGender()
                ,customer.getPhoneNumber(),id);
    }

    /*
    Created By hoangDH,
    Time: 13:42 PM 2022-06-01
    Function: find customer object by id from database
    */
    @Override
    public Optional<Customer> findById(Long id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2) {
        return iCustomerRepository.pageFindAll(pageable, key1, key2);
    }
}
