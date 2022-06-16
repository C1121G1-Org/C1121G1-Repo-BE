package api.services.impl;

import api.dto.EmployeeInterface;
import api.dto.PersonalDto;
import api.models.Account;
import api.models.Employee;
import api.repositories.IEmployeeRepository;
import api.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public void save(Employee employee) {
        iEmployeeRepository.createEmployee(employee);
    }

    @Override
    public void update(Employee employee, Account account) {
        iEmployeeRepository.updateEmployee(employee, account);
    }

//    @Override
//    public Employee findById(Long id) {
//        return iEmployeeRepository.findEmployeeById(id);
//    }

    /*
        Created by HuyNH
        Time: 19:00 31/05/2022
        Function: findAllEmployee = abstract method to find all employee.
    */
    @Override
    public Page<EmployeeInterface> findAllEmployee(Pageable pageable, String key) {
        return iEmployeeRepository.pageFindAll(pageable, key);

    }

    @Override
    public void saveDelete(Long id) {
        iEmployeeRepository.saveDelete(id);
    }

    /*
        Created by KhaiTT
        Date: 22:40 31/05/2022
        Function: find employee object by id.
    */
    @Override
    public Optional<Employee> findById(Long id) {
        return iEmployeeRepository.findById(id);
    }

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findEmployee() = call repo to find Employee by id
    */
    @Override
    public Employee findEmployee(Long createdEmployeeDto) {
        return iEmployeeRepository.findEmployee(createdEmployeeDto);
    }

    @Override
    public Employee findByIdCard(String idCard) {
        return iEmployeeRepository.findByIdCard(idCard);
    }

    /*
        Created by KhaiTT
        Date: 15:33 01/06/2022
        Function: update personal information of employee to DB.
    */
    @Override
    public void updatePersonalInforamation(PersonalDto personalDto) {
        iEmployeeRepository.updatePersonalInformation(personalDto);
    }
}
