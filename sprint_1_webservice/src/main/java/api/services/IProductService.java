package api.services;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findAllProduct(Pageable pageable, String key1, String key2);

    Product findById(long id);
}
