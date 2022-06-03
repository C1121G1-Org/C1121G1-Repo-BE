package api.repositories;

import api.models.InvoiceDetail;
import api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {

    /*
    Created by LongNHL
    Time: 15:12 01/06/2022
    Function: create invoiceDetail
    */
    @Transactional
    @Modifying
    @Query(value = "insert into invoice_detail (quantity, product_id,invoice_id) value (?1,?2,?3)",nativeQuery = true)
    void createInvoiceDetail(Long quantity, Long productId, Long invoiceId);




    //Create by chienLV
//Time: 18h00 31/05/2022
//Function: get list product bestseller from database
    @Query(value = "select product.id as id, product.camera as camera, product.cpu as cpu, product.image as image, product.memory as memory, product.name as name, " +
            "product.other_description as otherDescription, product.price as price, product.screen_size as screenSize, product.selfie as selfie, " +
            "sum(invoice_detail.quantity) as productQuantity " +
            "from invoice_detail " +
            "inner join product on product.id = invoice_detail.product_id " +
            "inner join invoice on invoice.id = invoice_detail.invoice_id " +
            "group by invoice_detail.product_id " +
            "order by productQuantity desc " +
            "limit 10 ", nativeQuery = true)
    <T> List<T> findListProductBestseller(Class<T> tClass);
}
