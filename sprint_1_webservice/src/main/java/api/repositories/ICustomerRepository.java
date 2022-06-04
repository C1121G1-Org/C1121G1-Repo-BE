package api.repositories;

import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;
import api.models.Customer;
import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show all list report customer
    */
    @Query(value = "SELECT customer.id as id, customer.customer_name as name, " +
            "customer.gender as gender, customer.date_of_birth as dateOfBirth, " +
            "customer.email as email, customer.phone_number as phoneNumber, " +
            "count(invoice.id) as purchaseTimes " +
            "FROM customer " +
            "INNER JOIN invoice ON customer.id = invoice.customer_id " +
            "GROUP BY customer.id",
            nativeQuery = true)
    Page<ReportCustomerDto> filterAll(Pageable pageable);

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    @Query(value = "SELECT customer.customer_name as name, customer.date_of_birth as dateOfBirth, " +
            "customer.gender as gender, customer.email as email, " +
            "customer.phone_number as phoneNumber, invoice.total_money as totalMoney, " +
            "invoice.create_date as purchaseDate, " +
            "GROUP_CONCAT(DISTINCT product.name) as purchaseProducts " +
            "FROM customer " +
            "INNER JOIN invoice ON customer.id = invoice.customer_id " +
            "INNER JOIN invoice_detail on invoice.id = invoice_detail.invoice_id " +
            "INNER JOIN product ON invoice_detail.product_id = product.id " +
            "WHERE customer.id = :id " +
            "GROUP BY invoice_detail.invoice_id",
            nativeQuery = true)
    Page<PurchaseHistoryDto> detail(Long id, Pageable pageable);

    /*
       Created by TuanNQ
       Time: 17:00 01/06/2022
       Function: Show list of customer reports by gender
   */
    @Query(value = "SELECT customer.id as id, customer.customer_name as name, " +
            "(year(now()) - year(STR_TO_DATE(customer.date_of_birth, '%d-%m-%Y'))) as age, " +
            "customer.gender as gender, customer.date_of_birth as dateOfBirth, " +
            "customer.email as email, customer.phone_number as phoneNumber, " +
            "count(invoice.id) as purchaseTimes " +
            "FROM customer " +
            "INNER JOIN invoice ON customer.id = invoice.customer_id " +
            "WHERE gender = :gender " +
            "GROUP BY customer.id",
            nativeQuery = true)
    Page<ReportCustomerDto> filterByGender(Pageable pageable, Boolean gender);

    /*
        Created by TuanNQ
        Time: 17:00 01/06/2022
        Function: Show list of customer reports by age
    */
    @Query(value = "SELECT customer.id as id, customer.customer_name as name, " +
            "(year(now()) - year(STR_TO_DATE(customer.date_of_birth, '%d-%m-%Y'))) as age, " +
            "customer.gender as gender, customer.date_of_birth as dateOfBirth, " +
            "customer.email as email, customer.phone_number as phoneNumber, " +
            "count(invoice.id) as purchaseTimes " +
            "FROM customer " +
            "INNER JOIN invoice ON customer.id = invoice.customer_id " +
            "WHERE (year(now()) - year(STR_TO_DATE(customer.date_of_birth, '%d-%m-%Y'))) = :age " +
            "GROUP BY customer.id",
            nativeQuery = true)
    Page<ReportCustomerDto> filterByAge(Pageable pageable, Integer age);

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    @Query(value = "SELECT customer.id as id, customer.customer_name as name, " +
            "(year(now()) - year(STR_TO_DATE(customer.date_of_birth, '%d-%m-%Y'))) as age, " +
            "customer.gender as gender, customer.date_of_birth as dateOfBirth, " +
            "customer.email as email, customer.phone_number as phoneNumber, " +
            "count(invoice.id) as purchaseTimes " +
            "FROM customer " +
            "INNER JOIN invoice ON customer.id = invoice.customer_id " +
            "WHERE gender = :gender and (year(now()) - year(STR_TO_DATE(customer.date_of_birth, '%d-%m-%Y'))) = :age " +
            "GROUP BY customer.id",
            nativeQuery = true)
    Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, Integer age);

    /*
     Created by TamT
     Time: 18:00 31/05/2022
     Function: get All customer and search
 */
    @Query(value = "select  id , address , customer_name , date_of_birth , email , gender , phone_number from customer where customer_name like concat('%', :name ,'%')" +
            " and phone_number like concat('%', :phone,'%')",
            countQuery = "select  id , address , customer_name , date_of_birth , email , gender , phone_number from customer where customer_name like concat('%', :name ,'%')" +
                    "and phone_number like concat('%', :phone,'%')"
            , nativeQuery = true)
    Page<Customer> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("phone") String keyWord2);

    /*
  Created by LongNHL
  Time: 21:30 31/05/2022
  Function: Query create customer.
  */
    @Transactional
    @Modifying
    @Query(value = "insert into customer(customer_name, phone_number, date_of_birth, email, address, gender) " +
            "values (?1,?2,?3,?4,?5,?6);", nativeQuery = true)
    void saveCustomer(String customerName, String phoneNumber, String dateOfBirth, String email, String address, boolean gender);


    @Query(value = "select * from customer where customer_name = ?1 and phone_number = ?2 and date_of_birth = ?3;", nativeQuery = true)
    Customer findCustomer(String customerName, String phoneNumber, String DateOfBirth);


    @Query(value = "select product.*, storage.quantity from product inner join storage on product.id = storage.product_id", nativeQuery = true)
    <T> List<T> findProductUsingService(Class<T> classType);


}
