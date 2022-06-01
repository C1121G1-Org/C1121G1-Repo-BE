package api.services;

import api.dto.PersonalDto;
import api.models.Employee;

import java.util.Optional;

public interface IEmployeeService {
    /*
        Created by KhaiTT
        Date: 22:40 31/05/2022
        Function: find employee object by id.
    */
    Optional<Employee> findById(Long id);

    /*
        Created by KhaiTT
        Date: 15:33 01/06/2022
        Function: update personal information of employee to DB.
    */
    void updatePersonalInforamation(PersonalDto personalDto);
}
