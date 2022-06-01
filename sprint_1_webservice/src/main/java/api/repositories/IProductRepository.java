package api.repositories;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findProduct() = write a native query to find Product by id
                  2/    getAllProduct() = write a native query to get all Products from DB
    */

    @Query(value = "select * from product where delete_flag = 1 ", nativeQuery = true)
    List<Product> getAllProduct();

    @Query(value = "select * from product where delete_flag = 1 and id = :id ", nativeQuery = true)
    Product findProduct(@Param("id") Long productDto);

    /*
      Created by hieuMMT and tamHT
      Time: 14:00 1/06/2022
      Function: get All product and search
    */

    @Query(value = "select name, price , cpu , memory, storage.quantity from product inner join" +
            " storage on product.id = storage.product_id where product.delete_flag = false and like name concat('%', :name ,'%')" +
            "and price like concat('%', :price ,'%')  and storage.quantity like concat('%', :quality ,'%')  group by product.id", nativeQuery = true)
    Page<Product> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("price") String keyWord2, @Param("quality") String keyWord3);

    /*
     Created by hieuMMT
     Time: 14:15 1/06/2022
     Function: delete product
 */
    @Query(value = "update product SET delete_flag = 1 WHERE product_id = ?;", nativeQuery = true)
    void deleteFlag(@PathVariable("id") Long id);
}