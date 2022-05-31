package api.services;

import api.models.Employee;

import java.util.Optional;

public interface IEmployeeService {
    /*
        Created by KhaiTT
        Date: 22:40 31/05/2022
        Function: find employee object by id.
    */
    Optional<Employee> findById(Long id);
}
