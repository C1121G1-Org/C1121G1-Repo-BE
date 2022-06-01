package api.repositories;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.transaction.annotation.Transactional;



import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.transaction.annotation.Transactional;



import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    /*

Created by TuanPA
Date: 14:01 01/06/2022
Function: Query Create product
*/
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product(camera,`cpu`,image,`memory`,`name`,other_description,price,qr_scan,screen_size,selfie) " +
            "VALUES(:camera,:cpu,:image,:memory,:name,:otherDescription,:price,:qrScan,:screenSize,:selfie)", nativeQuery = true)
    void saveProduct(@Param("camera") String camera, @Param("cpu") String cpu, @Param("image") String image, @Param("memory") String memory, @Param("name") String name, @Param("otherDescription") String otherDescription,
                     @Param("price") Double price, @Param("qrScan") String qrScan, @Param("screenSize") String screenSize, @Param("selfie") String selfie);

    /*
    Created by TuanPA
    Date: 14:01 01/06/2022
    Function: Query edit product
*/
    @Query(value = "SELECT product.id, product.camera,product.`cpu`,product.delete_flag,product.image," +
            "product.memory,product.`name`,product.other_description, product.price,product.qr_scan,product.screen_size,product.selfie " +
            "FROM product " +
            "WHERE product.id = :id", nativeQuery = true)
    Product findByProductById(@Param("id") Long id);
    /*
    Created by TuanPA
    Date: 14:01 01/06/2022
    Function: update product
*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE product " +
            "SET camera =:#{#product.camera},cpu=:#{#product.cpu}, delete_flag = :#{#product.deleteFlag}, image = :#{#product.image}, " +
            "memory = :#{#product.memory},name= :#{#product.name},other_description = :#{#product.otherDescription}, " +
            "price = :#{#product.price},qr_scan= :#{#product.qrScan},screen_size= :#{#product.screenSize},selfie= :#{#product.selfie} " +
            "WHERE id =:#{#product.id}", nativeQuery = true)
    void updateProduct(Product product);

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
<<<<<<< HEAD
    */


    @Query(value = "select * , storage.quantity from product inner join" +
            " storage on product.id = storage.product_id where product.delete_flag = 0 and `name` like  concat('%', :name ,'%')" +
            "and price like concat('%', :price ,'%')  and storage.quantity like concat('%', :quatity ,'%')  group by product.id ",
            countQuery = "select count(*) from product inner join" +
                    " storage on product.id = storage.product_id where product.delete_flag = 0 and `name` like  concat('%', :name ,'%')" +
                    "and price like concat('%', :price ,'%')  and storage.quantity like concat('%', :quatity ,'%')  group by product.id ", nativeQuery = true)
    Page<Product> pageFindAll(Pageable pageable, @Param("name") String keyWord1, @Param("price") String keyWord2, @Param("quatity") String keyWord3);

    /*
     Created by hieuMMT
     Time: 14:15 1/06/2022
     Function: delete product
 */
    @Query(value = "update product SET delete_flag = 1 WHERE product_id = ?;", nativeQuery = true)
    void deleteFlag(@PathVariable("id") Long id);

}


