package api.services.impl;

import api.models.Product;
import api.repositories.IProductRepository;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    getAllProduct() = call repo to get all Products
                  2/    findProduct() = call repo to find Product by id
    */

    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.getAllProduct();
    }

    @Override
    public Product findProduct(Long productDto) {
        return iProductRepository.findProduct(productDto);
    }
}
