package api.repositories;

import api.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = " INSERT INTO supplier ( address, email, phone_number, supplier_name, delete_flag) VALUES (?, ?, ?, ?, ?);", nativeQuery = true)
    void createSupplier(String supplierName, String address, String phone, String email,boolean deleteFlag );
    Supplier findBySupplierName(String supplierName);
}
