package api.repositories;

import api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    @Query(value = "insert into customer(customer_name, phone_number, date_of_birth, email, address, gender) " +
            "values (?1,?2,?3,?4,?5,?6);",nativeQuery = true)
    void saveCustomer(String customerName, String phoneNumber, String dateOfBirth, String email,String address, boolean gender);


//    @Query(value = "select * from customer where customer_name = ?1 and phone_number = ?2 and date_of_birth = ?3;",nativeQuery = true)
//    Customer findCustomer(String customerName, String phoneNumber, String DateOfBirth);




    @Query(value = "select product.*, storage.quantity from product inner join storage on product.id = storage.product_id",nativeQuery = true)
    <T> List<T> findProductUsingService(Class<T> classType);
}
