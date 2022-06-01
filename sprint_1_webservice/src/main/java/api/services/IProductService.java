package api.services;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    /*
               Created by tamHT
               Time: 18:15 31/05/2022
               Function: get all product
           */
    Page<Product> findAllProduct(Pageable pageable, String key1, String key2);


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
}
