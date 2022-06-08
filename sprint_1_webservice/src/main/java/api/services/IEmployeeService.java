package api.services;

import api.dto.EmployeeInterface;
import api.dto.PersonalDto;
import api.models.Account;
import api.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<EmployeeInterface> findAllEmployee(Pageable pageable, String key);

    void save(Employee employee);

    void update(Employee employee, Account account);


    void saveDelete(Long id);

    /*
        Created by KhaiTT
        Date: 22:40 31/05/2022
        Function: find employee object by id.
    */
    Optional<Employee> findById(Long id);

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findEmployee() = abstract method to find Employee by id
    */
    Employee findEmployee(Long createdEmployeeDto);


    Employee findByIdCard(String idCard);

    /*
        Created by KhaiTT
        Date: 15:33 01/06/2022
        Function: update personal information of employee to DB.
    */
    void updatePersonalInforamation(PersonalDto personalDto);
}
