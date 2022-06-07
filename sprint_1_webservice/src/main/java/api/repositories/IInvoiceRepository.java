package api.repositories;

import api.dto.HistoryInvoiceDto;
import api.models.Invoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {
/*
    Created by CongNV
    Date:  06/06/2022
    Function: find all history
*/

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


}

