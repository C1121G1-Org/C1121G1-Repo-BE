package api.repositories;

import api.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
    @Transactional
    @Modifying
    @Query(value = " INSERT INTO supplier ( address, email, phone, supplier_name, delete_flag) VALUES " +
            "(:#{#supplier.address}, :#{#supplier.email}, :#{#supplier.phone}, :#{#supplier.supplierName}, :#{#supplier.deleteFlag});", nativeQuery = true)
    void createSupplier(Supplier supplier);

    Supplier findBySupplierName(String supplierName);

}
