package api.repositories;

import api.models.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ISupplierRepository extends JpaRepository<Supplier, Long> {
    @Transactional
    @Modifying
    /*
        Created by NgocTTB
        Time: 19:00 31/05/2022
        Function: 1/    createSupplier() = write query to add new supplier
                  2/    findBySupplierName()
                  3/    findByEmail()
    */
    @Query(value = " INSERT INTO supplier ( address, email, phone, supplier_name, delete_flag) VALUES " +
            "(:#{#supplier.address}, :#{#supplier.email}, :#{#supplier.phone}, :#{#supplier.supplierName}, :#{#supplier.deleteFlag});", nativeQuery = true)
    void createSupplier(Supplier supplier);

    @Query(value = "SELECT * FROM supplier WHERE delete_flag =0 and supplier.supplier_name = :supplierName", nativeQuery = true)
    Supplier findBySupplierName(@Param("supplierName") String supplierName);

    @Query(value = "SELECT * FROM supplier WHERE delete_flag =0 and supplier.email = :email", nativeQuery = true)
    Supplier findByEmail(@Param("email") String email);

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    getAllSupplierPagingAndSearch() = write a native query to search Suppliers and paging
                  2/    findSupplier() = write a native query to find Supplier by id
                  3/    getAllSupplier() = write a native query to get all Suppliers
    */

    @Query(value = "select * from supplier where delete_flag = 0 and supplier_name like concat('%',:supplier,'%') and " +
            "address like concat('%',:address,'%') and phone like concat('%',:phone,'%') and email like concat('%',:email,'%') ",
            nativeQuery = true,
            countQuery = "select count(*) from supplier where delete_flag = 0 and supplier_name like concat('%',:supplier,'%') and " +
                    "address like concat('%',:address,'%') and phone like concat('%',:phone,'%') and email like concat('%',:email,'%') ")
    Page<Supplier> getAllSupplierPagingAndSearch(Pageable pageable, @Param("supplier") String supplier, @Param("address") String address,
                                                 @Param("phone") String phone, @Param("email") String email);

    @Query(value = "select * from supplier where delete_flag = 0 and id = :id ", nativeQuery = true)
    Supplier findSupplier(@Param("id") Long supplierDto);

    @Query(value = "select * from supplier where delete_flag = 0 ", nativeQuery = true)
    List<Supplier> getAllSupplier();


    @Query(value = " INSERT INTO supplier ( address, email, phone_number, supplier_name, delete_flag) VALUES (?, ?, ?, ?, ?);", nativeQuery = true)
    void createSupplier(String supplierName, String address, String phone, String email,boolean deleteFlag );
}
