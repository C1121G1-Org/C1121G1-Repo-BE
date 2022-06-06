package api.repositories;

import api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findEmployee() = write a native query to find Employee by id
    */

    @Query(value = "select * from employee where delete_flag = 0 and id = :id ", nativeQuery = true)
    Employee findEmployee(@Param("id") Long createdEmployeeDto);

}
