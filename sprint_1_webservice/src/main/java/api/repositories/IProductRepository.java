package api.repositories;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
        Created by TamT
        Time: 18:00 31/05/2022
        Function: get All product and search
    */
    @Query(value = "select name, price , cpu , memory from product where delete_flag = false and like concat('%', :name ,'%')" +
            " and price like concat('%', :price ,'%')"
            , nativeQuery = true)
    Page<Product> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("price") String keyWord2);
}
