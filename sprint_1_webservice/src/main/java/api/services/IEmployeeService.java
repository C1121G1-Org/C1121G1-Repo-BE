package api.services;

import api.models.Account;
import api.models.Employee;

public interface IEmployeeService {
    void save(Employee employee);

    void update(Employee employee, Account account);


    Employee findById(Long id);

}
