package api.repositories;

import api.models.Account;
import api.models.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

    /*
       Created by Khoa PTD
       Time: 09:00 02/06/2022
       Function: createEmployee
    */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO employee (`id`,`employee_name`, `date_of_birth`, " +
            "`delete_flag`,`address`, `id_card`,`phone_number`,`image`," +
            "`account_id`,`position_id`)" +
            " VALUES (:#{#employee.id},:#{#employee.employeeName},:#{#employee.dateOfBirth}," +
            ":#{#employee.deleteFlag},:#{#employee.address},:#{#employee.idCard}," +
            ":#{#employee.phoneNumber},:#{#employee.image},:#{#employee.account.id}," +
            ":#{#employee.position.id});", nativeQuery = true)
    void createEmployee(Employee employee);

    /*
       Created by Khoa PTD
       Time: 09:00 02/06/2022
       Function: updateEmployee
    */
    @Transactional
    @Modifying
    @Query(value = "update employee join `account`on employee.account_id = `account`.`id` " +
            "join `account_role` " +
            "set employee.`address`=:#{#employee.address}, " +
            "employee.`date_of_birth`=:#{#employee.dateOfBirth}, " +
            "employee.`employee_name` = :#{#employee.employeeName}, " +
            "employee.`id_card`= :#{#employee.idCard}, " +
            "employee.`image`= :#{#employee.image}, " +
            "employee.`phone_number`= :#{#employee.phoneNumber}, " +
            "employee.`position_id`= :#{#employee.position}, " +
            "`account`.`email`= :#{#account.email}, " +
            "`account`.`encrypt_password`= :#{#account.encryptPassword}, " +
            "`account`.`user_name`= :#{#account.userName} " +
            "where employee.`id`= :#{#employee.id}", nativeQuery = true)
    void updateEmployee(Employee employee, Account account);


    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: find Employee by id.
    */
    @Query(value = "SELECT * FROM employee  WHERE employee.id= :id", nativeQuery = true)
    Employee findEmployeeById(@Param("id") Long id);

    /*
       Created by HuyNH
       Time: 19:00 31/05/2022
       Function:     pageFindAll = abstract method to find all employee and pagination and search
    */
    @Query(value = "select * from employee where delete_flag = 0 and employee_name like concat('%', :name ,'%') "
            , nativeQuery = true,
            countQuery = "select count(*) from employee where delete_flag = 0 and employee_name like concat('%', :name ,'%') ")
    Page<Employee> pageFindAll(Pageable pageable, @Param("name") String keyword);

    /*
       Created by HuyNH
       Time: 19:00 31/05/2022
       Function:     deleteFlag = abstract method to delete flag a employee
    */


    @Transactional
    @Modifying
    @Query(value = "update employee set delete_flag = 1 where employee.id = :id ; ", nativeQuery = true)
    void saveDelete(@PathVariable("id") Long id);
}
