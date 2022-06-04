package api.services;

import api.dto.IProductDto;
import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

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
               Created by tamHT
               Time: 18:15 31/05/2022
               Function: get all product
           */
    Page<IProductDto> findAllProduct(Pageable pageable, String key1, String key2 , String key3);


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
   Optional<Product> findById(Long id);

}
