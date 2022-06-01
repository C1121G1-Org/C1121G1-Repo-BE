package api.services.impl;

import api.models.Product;
import api.repositories.IProductRepository;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Product> findAllProduct(Pageable pageable, String keyNameValue, String keyPhoneValue) {
        return null;
    }

    @Override
    public Page<Product> findAllProductSearch(Pageable pageable, String keyNameValue, String keyPhoneValue) {
        return iProductRepository.findProductUsingService(pageable,keyNameValue,keyPhoneValue);
    }
}
