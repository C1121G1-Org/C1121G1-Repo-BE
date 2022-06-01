package api.repositories;

import api.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface IProductRepository extends JpaRepository<Product, Long> {
    /*
Created by TuanPA
Date: 17:08 31/05/2022
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
    Date: 17:08 31/05/2022
    Function: Query edit product
*/
    @Query(value = "SELECT product.id, product.camera,product.`cpu`,product.delete_flag,product.image," +
            "product.memory,product.`name`,product.other_description, product.price,product.qr_scan,product.screen_size,product.selfie " +
            "FROM product " +
            "WHERE product.id = :id", nativeQuery = true)
    Product findByProductById(@Param("id") Long id);
    /*
    Created by TuanPA
    Date: 17:08 31/05/2022
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


}


