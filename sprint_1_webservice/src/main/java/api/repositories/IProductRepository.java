package api.repositories;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


public interface IProductRepository extends JpaRepository<Product, Long> {

    /*
Created by TuanPA
Date: 14:01 01/06/2022
Function: Query Create product
*/

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO product(camera,`cpu`,image,`memory`,`name`,other_description,price,qr_scan,screen_size,selfie,delete_flag) " +
            "VALUES(:camera,:cpu,:image,:memory,:name,:otherDescription,:price,:qrScan,:screenSize,:selfie,0)", nativeQuery = true)
    void saveProduct(@Param("camera") String camera, @Param("cpu") String cpu, @Param("image") String image, @Param("memory") String memory, @Param("name") String name, @Param("otherDescription") String otherDescription,
                     @Param("price") Double price, @Param("qrScan") String qrScan, @Param("screenSize") String screenSize, @Param("selfie") String selfie);

    /*
    Created by TuanPA
    Date: 14:01 01/06/2022
    Function: Query findById product
*/

    @Query(value = "select * from product where delete_flag = 0 and id = :id ", nativeQuery = true)
    Optional<Product> findById(@Param("id") Long id);




    @Query(value = "SELECT product.id, product.camera,product.`cpu`,product.delete_flag,product.image," +
            "product.memory,product.`name`,product.other_description, product.price,product.qr_scan,product.screen_size,product.selfie " +
            "FROM product " +
            "WHERE product.id = :id", nativeQuery = true)
    Optional<Product> findByProductById(@Param("id") Long id);


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
    Created by TuanPA
    Date: 14:01 02/06/2022
    Function: update product
*/

    @Query(value = "SELECT * FROM product WHERE delete_flag =0 and product.name = :name", nativeQuery = true)
    Product findProductByName(@Param("name") String name);


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






/*     Created by hieuMMT
     Time: 14:15 1/06/2022
     Function: delete product
 */

    @Query(value = "update product SET delete_flag = 0 WHERE product_id = ?;", nativeQuery = true)
    void deleteFlag(@PathVariable("id") Long id);





    /*
           Created by hieuMMT and tamHT
        Time: 18:00 31/05/2022
        Function: get All product and search
    */


    @Query(value = "select id, name, price , cpu , memory,camera,image,other_description,qr_scan, screen_size,selfie, quantity from (select product.id, name, price , cpu , memory,camera,image,other_description,qr_scan, " +
            "screen_size,selfie, ifnull(storage.quantity, 0) as quantity from product left join `storage` " +
            "on product.id = storage.product_id where product.delete_flag = 0 and `name` like  concat('%', :name ,'%') " +
            "and price >= :price group by product.id " +
            ") as temp where quantity >= :quantity ",
            countQuery = "select id, name, price , cpu , memory,camera,image,other_description,qr_scan, screen_size,selfie, quantity from (select product.id, name, price , cpu , memory,camera,image,other_description,qr_scan, " +
                    "screen_size,selfie, ifnull(storage.quantity, 0) as quantity from product left join `storage` " +
                    "on product.id = storage.product_id where product.delete_flag = 0 and `name` like  concat('%', :name ,'%') " +
                    "and price >= :price group by product.id " +
                    ") as temp where quantity >= :quantity ", nativeQuery = true)
    <T> Page<T> pageFindAll(Class<T> tClass, Pageable pageable, @Param("name") String keyWord1, @Param("price") String keyWord2, @Param("quantity") String keyWord3);

}



