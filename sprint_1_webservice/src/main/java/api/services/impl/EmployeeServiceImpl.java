package api.services.impl;

import api.models.Employee;
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

    /*
    Created by HuyNH
    Time: 19:00 31/05/2022
    Function:     findAllEmployee = abstract method to find all employee

*/
    @Override
    public Page<Employee> findAllEmployee(Pageable pageable, String key) {
        return iEmployeeRepository.pageFindAll(pageable, key);
    }

    /*
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

*/
    @Override
    public void delete(Long id) {
        iEmployeeRepository.deleteFlag(id);
    }

}
