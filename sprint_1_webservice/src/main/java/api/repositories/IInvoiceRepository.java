package api.repositories;

import api.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface IInvoiceRepository extends JpaRepository<Invoice, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into invoice (create_date,payments, customer_id) value (?1,?2,?3);", nativeQuery = true)
    void saveInvoice(String createDate, String payments, Long customerId);
}
