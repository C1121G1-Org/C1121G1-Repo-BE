package api.repositories;

import api.dto.HistoryInvoiceDto;
import api.models.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
/*
    Created by CongNV
    Date:  06/06/2022
    Function: find all history
*/

        /*
        Created by CongNv
        Time: 21:30 31/05/2022
        Function: create invoice
        */

//
//    @Query(value = "SELECT invoice.id,create_date,create_time,name,total_money " +
//            "FROM  invoice " +
//            "   join invoice_detail on invoice.id = invoice_detail.invoice_id " +
//            "   join product on invoice_detail.product_id = product.id " +
//            "   join customer on invoice.customer_id = customer.id " +
//            "   where create_time like concat('%',:keyword,'%') " +
//            "or  create_date like concat('%',:keyword,'%') " +
//            "or  total_money like concat('%',:keyword,'%') " +
//            "or  customer_id like concat('%',:keyword,'%') " +
//            "or  product_id like concat('%',:keyword,'%') ",
//             nativeQuery = true)
////            "order by " +
////            "case when :sorts = 'sortDateAsc' then create_date end desc ," +
////            "case when :sorts = 'sortCustomerAsc' then customer_id end desc ," +
////            "case when :sorts = 'sortProductAsc' then product_id end desc ," +
////            "case when :sorts = 'sortTotalMoneyAsc' then total_money end desc"
//

    @Query(value = "SELECT invoice.id as invoiceId, create_date as createDate,create_time as createTime,`name`as productName, customer_name as customerName,total_money as totalMoney , quantity , invoice_detail.id as invoiceDetailId FROM  invoice " +
            "join invoice_detail on invoice.id = invoice_detail.invoice_id " +
            "join product on invoice_detail.product_id = product.id " +
            "join customer on invoice.customer_id = customer.id " +
            "   where create_time like concat('%',:keyword,'%') " +
            "or  create_date like concat('%',:keyword,'%') " +
            "or  total_money like concat('%',:keyword,'%') " +
            "or  customer_name like concat('%',:keyword,'%') " +
            "or  `name` like concat('%',:keyword,'%') " +
            "order by " +
            "case when :sorts = 'sortDateDesc' then create_date end desc ," +
            "case when :sorts = 'sortDateAsc' then create_date end asc ," +
            "case when :sorts = 'sortCustomerDesc' then customer_id end desc ," +
            "case when :sorts = 'sortCustomerAsc' then customer_id end asc ," +
            "case when :sorts = 'sortTotalMoneyDesc' then total_money end desc ," +
            "case when :sorts = 'sortTotalMoneyAsc' then total_money end asc",
            countQuery = "SELECT invoice.id as invoiceId,create_date as createDate,create_time as createTime,`name`as productName, customer_name as customerName,total_money as totalMoney,quantity,invoice_detail.id as invoiceDetailId FROM  invoice " +
                    "join invoice_detail on invoice.id = invoice_detail.invoice_id " +
                    "join product on invoice_detail.product_id = product.id " +
                    "join customer on invoice.customer_id = customer.id " +
                    "where create_time like concat('%',:keyword,'%') " +
                    "or  create_date like concat('%',:keyword,'%') " +
                    "or  total_money like concat('%',:keyword,'%') " +
                    "or  customer_name like concat('%',:keyword,'%') " +
                    "or  `name` like concat('%',:keyword,'%') " +
                    "order by " +
                    "case when :sorts = 'sortDateDesc' then create_date end desc ," +
                    "case when :sorts = 'sortDateAsc' then create_date end asc ," +
                    "case when :sorts = 'sortCustomerDesc' then customer_id end desc ," +
                    "case when :sorts = 'sortCustomerAsc' then customer_id end asc ," +
                    "case when :sorts = 'sortTotalMoneyDesc' then total_money end desc ," +
                    "case when :sorts = 'sortTotalMoneyAsc' then total_money end asc"
            , nativeQuery = true)
    Page<HistoryInvoiceDto> findAllByKeyWord(@Param("keyword") String keyword, Pageable pageable, @Param("sorts") String sort);

    /*
    Created by LongNHL
    Time: 21:30 31/05/2022
    Function: create invoice
    */
    @Transactional
    @Modifying
    @Query(value = "insert into invoice (create_date, create_time,total_money ,payments, customer_id) value (?1,?2,?3,?4,?5);", nativeQuery = true)
    void saveInvoice(String createDate, String createTime,Double totalMoney, String payments, Long customerId);

    @Query(value = "select * from invoice order by id desc limit 1;",nativeQuery = true)
    Invoice getNewInvoice();


//    @Query(value = "select * from land_information join direction on direction.id = land_information.direction_id " +

//            "where price like concat('%', :prices ,'%')" +
//            " and area like concat('%', :areas ,'%')" +
//            " and direction.`name` like concat('%', :directions ,'%')" +
//            " order by case when :sorts = 'sortDateAsc' then start_date end asc , " +
//            "case when :sorts = 'sortDateDesc' then start_date end desc ," +
//            "case when :sorts ='sortPriceAsc'then price end asc , " +
//            "case when :sorts ='sortPriceDesc' then price end desc ",
//            countQuery = "select count(*) from land_information" +
//                    " join direction on direction.id = land_information.direction_id " +
//                    "where price like concat('%', :prices ,'%')" +
//                    "and area like concat('%', :areas ,'%') " +
//                    "and direction.`name` like concat('%', :directions ,'%') " +
//                    "order by case when :sorts = 'sortDateAsc' then start_date end asc , " +
//                    "case when :sorts = 'sortDateDesc' then start_date end desc," +
//                    "case when :sorts ='sortPriceAsc'then price end asc ," +
//                    "case when :sorts ='sortPriceDesc' then price end desc ", nativeQuery = true)
}

