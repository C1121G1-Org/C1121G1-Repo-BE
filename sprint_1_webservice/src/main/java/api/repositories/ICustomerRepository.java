package api.repositories;

import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;
import api.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


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
            "WHERE gender = :gender and (year(now()) - year(STR_TO_DATE(customer.date_of_birth, '%d-%m-%Y'))) like concat('%', :age, '%') " +
            "GROUP BY customer.id",
            nativeQuery = true)
    Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, String age);
}
