package api.repositories;

import api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select product.*, storage.quantity from product inner join storage on product.id = storage.product_id",nativeQuery = true)
    <T> List<T> findProductUsingService(Class<T> classType);
}
