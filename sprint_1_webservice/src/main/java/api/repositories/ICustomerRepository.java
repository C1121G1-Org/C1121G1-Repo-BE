package api.repositories;

import api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import javax.transaction.Transactional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    /*
   Created by LongNHL
   Time: 21:30 31/05/2022
   Function: Query create customer.
   */
    @Transactional
    @Modifying
    @Query(value = "insert into customer( customer_name, phone_number, date_of_birth, email, address, gender) " +
            "values (?1,?2,?3,?4,?5,?6);",nativeQuery = true)
    void saveCustomer(String customerName, String phoneNumber, String dateOfBirth, String email,String address, boolean gender);
    /*
       Created by LongNHL
       Time: 21:30 31/05/2022
       Function: check id  new create customer.
       */
    @Query(value = "select * from customer order by id desc limit 1;",nativeQuery = true)
    Customer getNewCreateCustomer();

    /*
           Created by LongNHL
           Time: 21:30 31/05/2022
           Function: find customer id.
           */
    @Query(value = "select * from customer where customer.id =:id; ",nativeQuery = true)
    Customer findCustomerById(@Param("id") Long id);


    @Query(value = "select product.*, storage.quantity from product inner join storage on product.id = storage.product_id",nativeQuery = true)
    <T> List<T> findProductUsingService(Class<T> classType);


}
