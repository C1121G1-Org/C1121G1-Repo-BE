package api.services;

import api.models.Product;

public interface IProductService {
    void save(Product product);

    Product findById(Long id);
}
