package api.services.impl;
import api.models.Product;
import api.repositories.IProductRepository;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        /*
            Created by tamHT
            Time: 18:15 31/05/2022
            Function: search Products
        */
    @Override
    public Page<Product> findAllProduct(Pageable pageable, String key1, String key2) {
        return iProductRepository.pageFindAll(pageable,key1,key2);
    }

    /*
        Created by tuanPA
        Time: 18:15 31/05/2022
        Function: save product
    */
    @Override
    public void save(Product product) {
        this.iProductRepository.saveProduct(product.getCamera(),product.getCpu(),product.getImage(),product.getMemory(),product.getName(),product.getOtherDescription(),product.getPrice(),product.getQrScan(),product.getScreenSize(),product.getSelfie());
    }

    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: findById
 */
    @Override
    public Product findById(Long id) {
        return iProductRepository.findByProductById(id);
    }

    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: updateProduct
 */
    @Override
    public void updateProduct(Product product) {
        this.iProductRepository.updateProduct(product);
    }
}
