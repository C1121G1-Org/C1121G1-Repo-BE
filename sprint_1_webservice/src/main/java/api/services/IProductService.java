package api.services;

import api.models.Product;

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
}
