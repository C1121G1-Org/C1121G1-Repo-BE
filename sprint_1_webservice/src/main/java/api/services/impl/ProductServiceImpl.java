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

    /*
            Created by tamHT
            Time: 18:15 31/05/2022
            Function: get list product
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
        this.iProductRepository.save(product);
    }

    /*
     Created by tuanPA
     Time: 18:15 31/05/2022
     Function: findById
 */
    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
