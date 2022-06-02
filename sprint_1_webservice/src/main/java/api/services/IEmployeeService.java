package api.services;

import api.models.Account;
import api.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable, String key);

    void save(Employee employee);
  
    void update(Employee employee, Account account);

    Employee findById(long id);

    void delete(Long id);
}