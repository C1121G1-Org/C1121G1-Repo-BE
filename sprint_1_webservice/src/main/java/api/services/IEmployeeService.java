package api.services;

import api.dto.EmployeeInterface;
import api.models.Account;
import api.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<EmployeeInterface> findAllEmployee(Pageable pageable, String key);

    void save(Employee employee);
  
    void update(Employee employee, Account account);


    void saveDelete(Long id);


//    Employee findById(Long id);

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findEmployee() = abstract method to find Employee by id
    */
    Employee findEmployee(Long createdEmployeeDto);


    Employee findByIdCard(String idCard);

}
