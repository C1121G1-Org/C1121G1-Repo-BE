package api.repositories;

import api.dto.PersonalDto;
import api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query(value = "UPDATE employee SET address = :#{#personalDto.address}, date_of_birth = :#{#personalDto.dateOfBirth}," +
            " employee_name = :#{#personalDto.employeeName}, id_card = :#{#personalDto.idCard}, image = :#{#personalDto.image}," +
            " phone_number = :#{#personalDto.phoneNumber} WHERE (id = :#{#personalDto.id}); ", nativeQuery = true)
    void updatePersonalInformation(PersonalDto personalDto);
}
