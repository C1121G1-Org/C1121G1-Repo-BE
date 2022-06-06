package api.repositories;

import api.models.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IStorageRepository extends JpaRepository<Storage, Long> {

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    createStorage() = write a native query to create Storage
                  2/    getAllStorage() = write a native query to get all Storages from DB
    */

    @Query(value = "select * from storage where delete_flag = 0 ", nativeQuery = true)
    List<Storage> getAllStorage();

    @Transactional
    @Modifying
    @Query(value = "insert into storage (`id`, `created_date`, `quantity`, `status`, `employee_id`, `product_id`, `supplier_id`) " +
            "values (:#{#storage.id}, :#{#storage.createdDate}, :#{#storage.quantity}, :#{#storage.status}, " +
            ":#{#storage.createdEmployee.id}, :#{#storage.product.id}, :#{#storage.supplier.id}) ", nativeQuery = true)
    void createStorage(Storage storage);


    /*
    Created by LongNHL
    Time: 22:30 1/06/2022
    Function: find storage by productId after create invoice
    */

    @Query(value = "select * from `storage` where product_id = :id", nativeQuery = true)
    Storage getStorageByIdProduct(@Param("id") Long productId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE `storage` SET `quantity` = ?1 WHERE (`id` = ?2)",nativeQuery = true)
    void updateQuantityProduct(Long quantity, Long id);
}
