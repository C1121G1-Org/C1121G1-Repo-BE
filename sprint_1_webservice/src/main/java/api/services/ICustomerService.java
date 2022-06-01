package api.services;

import api.models.Customer;

public interface ICustomerService {
    void createCustomer(Customer customer);

    Customer findCustomer(Customer customer);
}
