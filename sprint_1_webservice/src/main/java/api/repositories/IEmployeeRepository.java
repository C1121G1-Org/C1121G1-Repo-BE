package api.repositories;

import api.dto.EmployeeInterface;
import api.dto.PersonalDto;
import api.models.Account;
import api.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
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
       Created by HuyNH
       Time: 19:00 31/05/2022
       Function:     pageFindAll = abstract method to find all employee and pagination and search
    */
    @Query(value = "select employee.id as id, employee_name as name, date_of_birth as dateOfBirth," +
            " address as address, phone_number as phoneNumber ,position.id as idPosition," +
            " position.position_name as namePosition" +
            " from employee join position on employee.position_id = position.id" +
            " where delete_flag = 0 and employee_name like concat('%', :name ,'%') "
            ,
            countQuery = "select employee.id as id, employee_name as name, date_of_birth as dateOfBirth," +
                    " address as address, phone_number as phoneNumber ,position.id as idPosition," +
                    " position.position_name as namePosition" +
                    " from employee join position on employee.position_id = position.id" +
                    " where delete_flag = 0 and employee_name like concat('%', :name ,'%') ",
            nativeQuery = true )
    Page<EmployeeInterface> pageFindAll(Pageable pageable, @Param("name") String keyword);

    /*
       Created by HuyNH
       Time: 19:00 31/05/2022
       Function:     deleteFlag = abstract method to delete flag a employee
    */
    @Transactional
    @Modifying
    @Query(value = "update employee set delete_flag = 1 where employee.id = :id ; ", nativeQuery = true)
    void saveDelete(@PathVariable("id") Long id);

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findEmployee() = write a native query to find Employee by id
    */
    @Query(value = "select * from employee where delete_flag = 0 and id = :id ", nativeQuery = true)
    Employee findEmployee(@Param("id") Long createdEmployeeDto);

    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: find Employee by idCard.
    */
    @Query(value = "select * from `sprint-1-db`.employee where employee.id_card = :idCard ", nativeQuery = true)
    Employee findByIdCard(@Param("idCard") String idCard);

    /*
        Created by KhaiTT
        Date: 15:33 01/06/2022
        Function: update personal information of employee to DB.
    */
    @Transactional
    @Modifying
    @Query(value = "UPDATE employee SET address = :#{#personalDto.address}, date_of_birth = :#{#personalDto.dateOfBirth}," +
            " employee_name = :#{#personalDto.employeeName}, id_card = :#{#personalDto.idCard}, image = :#{#personalDto.image}," +
            " phone_number = :#{#personalDto.phoneNumber} WHERE (id = :#{#personalDto.id}); ", nativeQuery = true)
    void updatePersonalInformation(PersonalDto personalDto);
}
