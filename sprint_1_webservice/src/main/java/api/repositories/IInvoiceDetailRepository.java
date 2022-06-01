package api.repositories;

import api.models.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IInvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into invoice_detail (quantity,invoice_id, product_id) value (?1,?2,?3)",nativeQuery = true)
    void createInvoiceDetail(Long quantity, Long id, Long id1);
}
