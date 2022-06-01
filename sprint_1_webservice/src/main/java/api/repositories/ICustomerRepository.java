package api.repositories;

import api.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "select * from customer where customer_name like concat('%', :name ,'%')" +
            " and phone_number like concat('%', :phone,'%')"
            , nativeQuery = true)
    Page<Customer> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("phone") String keyWord2);

    /*
    Created By hoangDH,
    Time: 12:38 PM 2022-06-01
    Function: edit object by id from database
     */
    /*@Query( value = "UPDATE `sprint-1-db`.`customer` SET " +
           "`address` = ?1," +
           " `customer_name` = ?2," +
           " `date_of_birth` = ?3," +
            " `email` = ?4," +
            " `gender` = ?5," +
           " `phone_number` = ?6 WHERE (`id` =:id);",nativeQuery = true)
   void editCustomer(String address, String customerName, String dateOfBirth,
                     String email, Boolean gender, String phoneNumber,@Param("id") Long id);*/




    @Transactional
    @Modifying
    @Query(value = "UPDATE `sprint-1-db`.`customer` Set `customer` (`address`, `customer_name`, `date_of_birth`, `email`, `gender`, `phone_number`) " +
            "values (:#{#customer.address}, :#{#customer.customerName}, :#{#customer.dateOfBirth}, :#{#customer.email}, " +
            ":#{#customer.gender}, :#{#customer.phoneNumber}) WHERE (`id`=:id)", nativeQuery = true)
            void editCustomer(Customer customer,@Param("id") Long id);

    /*
    Created By hoangDH,
    Time: 13:42 PM 2022-06-01
    Function: find customer object by id from database
     */
    @Query(nativeQuery=true,value="select * from `sprint-1-db`.`customer` where `id`=:id")
    Optional<Customer> findById(@Param("id") Long id);




}
