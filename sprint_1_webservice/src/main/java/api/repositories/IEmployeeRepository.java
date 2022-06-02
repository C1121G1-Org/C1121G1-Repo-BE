package api.repositories;

import api.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    /*
   Created by HuyNH
   Time: 19:00 31/05/2022
   Function:     pageFindAll = abstract method to find all employee and pagination and search
*/
    @Query(value = "select * from employee where delete_flag = 1 and employee_name like concat('%', :name ,'%') "
            , nativeQuery = true,
            countQuery = "select count(*) from employee where delete_flag = 1 and employee_name like concat('%', :name ,'%') ")
    Page<Employee> pageFindAll(Pageable pageable, @Param("name") String keyword);

    /*
   Created by HuyNH
   Time: 19:00 31/05/2022
   Function:     deleteFlag = abstract method to delete flag a employee
*/
    @Query(value = "update employee set delete_flag = 1 where employee.id = :id ", nativeQuery = true)
    void deleteFlag(Long id);

}
