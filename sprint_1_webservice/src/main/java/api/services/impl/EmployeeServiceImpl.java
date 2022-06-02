package api.services.impl;

import api.models.Account;
import api.models.Employee;
import api.models.Position;
import api.repositories.IEmployeeRepository;
import api.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

<<<<<<< HEAD
    /*
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function:     findAllEmployee = abstract method to find all employee
=======
    @Override
    public void save(Employee employee) {
        iEmployeeRepository.createEmployee(employee);
    }

    @Override
    public void update(Employee employee, Account account) {
        iEmployeeRepository.updateEmployee(employee,account);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findEmployeeById(id);
    }
  
    /*
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function: findAllEmployee = abstract method to find all employee.
>>>>>>> 6689f8a0aa24b8bb1414331091382f11bd2937fe
    */
    @Override
    public Page<Employee> findAllEmployee(Pageable pageable, String key) {
        return iEmployeeRepository.pageFindAll(pageable, key);
    }

    /*
<<<<<<< HEAD
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function:     findAllEmployee = abstract method to save a employee
    */
    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public Employee findById(long id) {
        return null;
    }

    /*
       Created by HuyNH
       Time: 19:00 31/05/2022
       Function:     findAllEmployee = abstract method to delete a employee
=======
       Created by HuyNH
       Time: 19:00 31/05/2022
       Function: findAllEmployee = abstract method to delete a employee
>>>>>>> 6689f8a0aa24b8bb1414331091382f11bd2937fe
    */
    @Override
    public void saveDelete(Employee employee) {
        iEmployeeRepository.saveDelete(employee);
    }
}
