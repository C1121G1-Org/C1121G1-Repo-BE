package api.repositories;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IProductRepository extends JpaRepository<Product, Long> {
    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findProduct() = write a native query to find Product by id
                  2/    getAllProduct() = write a native query to get all Products from DB
    */

    @Query(value = "select * from product where delete_flag = 0 ", nativeQuery = true)
    List<Product> getAllProduct();

    @Query(value = "select * from product where delete_flag = 0 and id = :id ", nativeQuery = true)
    Product findProduct(@Param("id") Long productDto);

     /*
        Created by TamT
        Time: 12:00 2/06/2022
        Function: get id product
    */
     @Query(value = "select * from product where delete_flag = 0 and id = :id ", nativeQuery = true)
    Optional<Product> findById(@Param("id") Long id);

    /*
        Created by TamT
        Time: 18:00 31/05/2022
        Function: get All product and search
    */
    @Query(value = "select * , storage.quantity from product inner join" +
            " storage on product.id = storage.product_id where product.delete_flag = 0 and `name` like  concat('%', :name ,'%')" +
            "and price >= :price  and storage.quantity >= :quantity  group by product.id ",
            countQuery = "select count(*) from product inner join" +
                    " storage on product.id = storage.product_id where product.delete_flag = 0 and `name` like  concat('%', :name ,'%')" +
                    "and price >= :price  and storage.quantity >= :quantity  group by product.id ", nativeQuery = true)
    Page<Product> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("price") String keyWord2, @Param("quantity") String keyWord3);
}
//    select name, price , cpu , memory, storage.quantity from product inner join
//        storage on product.id = storage.product_id where product.delete_flag = false and name like "%sa%"
//        and price >=""and storage.quantity >=50 group by product.id;
