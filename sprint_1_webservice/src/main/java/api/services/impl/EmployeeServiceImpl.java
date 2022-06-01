package api.services.impl;

import api.models.Employee;
import api.repositories.IEmployeeRepository;
import api.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findEmployee() = call repo to find Employee by id
    */
    @Override
    public Employee findEmployee(Long createdEmployeeDto) {
        return iEmployeeRepository.findEmployee(createdEmployeeDto);
    }
}
