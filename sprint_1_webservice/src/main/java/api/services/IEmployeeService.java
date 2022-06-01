package api.services;

import api.models.Employee;

public interface IEmployeeService {

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findEmployee() = abstract method to find Employee by id
    */
    Employee findEmployee(Long createdEmployeeDto);
}
