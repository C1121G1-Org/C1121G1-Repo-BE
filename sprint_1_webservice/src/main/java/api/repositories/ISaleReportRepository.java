package api.repositories;

import api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/*
    Created by HauPV
    Time: 19:27 31/05/2022
    Function: get sale report from database
*/
public interface ISaleReportRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT invoice.id as id , invoice.create_date as `date` , count(invoice_id) as invoiceQuantity , sum(invoice.total_money) as totalMoney  FROM `sprint-1-db`.invoice  " +
            "JOIN invoice_detail ON invoice_detail.id = invoice.id " +
            "JOIN product ON product.id = invoice_detail.product_id  " +
            "WHERE ( str_to_date(invoice.create_date,'%d/%m/%Y') between :#{#startDay}  and :#{#endDay}  )  " +
            "AND product.id LIKE concat('%', :productId ,'%') " +
            "GROUP BY invoice.create_date ;",
            nativeQuery = true)
    <T> List<T> findAllSaleReport(Class<T> t, String startDay, String endDay, @Param("productId") String productId);

    @Query(value = " select * from product where delete_flag = 0 order by id desc limit 1 ; ",
            nativeQuery = true)
    Product getLatestProduct();

}
