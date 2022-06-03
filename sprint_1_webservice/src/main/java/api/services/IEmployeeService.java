package api.services;

import api.models.Account;
import api.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAllEmployee(Pageable pageable, String key);

    void save(Employee employee);
  
    void update(Employee employee, Account account);


    void saveDelete(Long id);


    Employee findById(Long id);

}
