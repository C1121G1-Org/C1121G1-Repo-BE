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
    @Query(value = "SELECT invoice.id as id , date_format(invoice.create_date,'%m-%Y') as `date` , count(invoice_id) as invoiceQuantity , sum(product.price * invoice_detail.quantity) as totalMoney  FROM `sprint-1-db`.invoice \n" +
            "JOIN invoice_detail ON invoice_detail.id = invoice.id\n" +
            "JOIN product ON product.id = invoice_detail.product_id \n" +
            "WHERE ( str_to_date(invoice.create_date,'%Y-%m-%d') between :#{#startDay}  and :#{#endDay}  ) \n" +
            "AND product.id LIKE :productId \n" +
            "GROUP BY date_format(invoice.create_date,'%m-%Y') \n" +
            "ORDER BY str_to_date(invoice.create_date,'%Y-%m-%d') ;",
            nativeQuery = true)
    <T> List<T> findAllSaleReport(Class<T> t, String startDay, String endDay, @Param("productId") String productId);
    @Query(value = " select * from product where delete_flag = 0 order by id desc limit 1 ; ",
            nativeQuery = true)
    Product getLatestProduct();
    @Query(value = "SELECT * FROM `sprint-1-db`.product where delete_flag = 0 ; ",
            nativeQuery = true)
    List<Product> getListProduct();
    @Query(value = "SELECT * FROM `sprint-1-db`.product where id = :#{#id} " +
            "and name = :#{#name} " +
            "and price = :#{#price} " +
            "and  delete_flag = 0;",
            nativeQuery = true)
    Product findProductByIdNamePrice(Long id, String name, Double price);
}