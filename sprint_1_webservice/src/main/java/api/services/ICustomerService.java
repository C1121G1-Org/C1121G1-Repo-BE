package api.services;

import api.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    void editCustomer(Customer customer, Long id);
    Optional<Customer> findById(Long id);
    Page<Customer> findAllCustomer(Pageable pageable, String key1, String key2);


}
