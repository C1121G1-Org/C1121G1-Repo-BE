package api.repositories;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select name, price , cpu , memory from product where delete_flag = false and like concat('%', :name ,'%')" +
            " and price like concat('%', :price ,'%')"
            , nativeQuery = true)
    Page<Product> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("price") String keyWord2);

    @Query(value = "select name, price , cpu , memory, storage.quantity from product inner join storage on product.id = storage.product_id where delete_flag = false and like concat('%', :name ,'%')"+
             "and price like concat('%', :price ,'%')  group by product.id",nativeQuery = true)
    Page<Product> findProductUsingService(Pageable pageable, @Param("name") String keyWord1, @Param("price") String keyWord2);
}
