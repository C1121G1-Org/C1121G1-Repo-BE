package api.repositories;

import api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/*
    Created by HauPV
    Time: 19:27 31/05/2022
    Function: get sale report from database
*/
public interface ISaleReportRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT invoice.id as id , invoice.create_date as `date` , count(invoice_id) as invoiceQuantity , sum(invoice.total_money) as totalMoney  FROM `sprint-1-db`.invoice \n" +
            "JOIN product ON product.id = invoice.product_id\n" +
            "JOIN invoice_detail ON invoice_detail.id = invoice.id\n" +
            "GROUP BY invoice.create_date ; ",
            nativeQuery = true)
    <T> List<T> findAllSaleReport(Class<T> t);
}
