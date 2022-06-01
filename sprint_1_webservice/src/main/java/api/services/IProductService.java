package api.services;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


public interface IProductService {
    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    getAllProduct() = abstract method to get all Products
                  2/    findProduct() = abstract method to find Product by id
    */
    List<Product> getAllProduct();

    Product findProduct(Long productDto);

    /*
               Created by hieuMMT and tamHT
               Time: 18:15 31/05/2022
               Function: get all product
           */
    Page<Product> findAllProduct(Pageable pageable, String key1, String key2 , String key3);


    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: save product
 */
    void save(Product product);


    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: findById
 */
    Product findById(Long id);

    /*
         Created by hieuMMT
         Time: 14:15 1/06/2022
         Function: delete product
     */
    void deleteFlag(Long id);

    void updateProduct(Product product);

}
