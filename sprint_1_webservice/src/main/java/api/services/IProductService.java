package api.services;

import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    void save(Product product);

    Product findById(Long id);

    Page<Product> findAllProduct(Pageable pageable, String keyNameValue, String keyPhoneValue);

    Page<Product>findAllProductSearch(Pageable pageable,String keyNameValue,String keyPhoneValue);
}
