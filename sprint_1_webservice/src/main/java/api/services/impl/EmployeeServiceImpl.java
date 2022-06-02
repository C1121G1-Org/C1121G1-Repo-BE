package api.services.impl;

import api.models.Account;
import api.models.Employee;
import api.models.Position;
import api.repositories.IEmployeeRepository;
import api.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;



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

}
