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

<<<<<<< HEAD
    void saveDelete(Employee employee);

}
=======
    void delete(Long id);
}
>>>>>>> 6689f8a0aa24b8bb1414331091382f11bd2937fe
