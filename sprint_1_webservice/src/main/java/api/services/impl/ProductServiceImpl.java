package api.services.impl;

import api.models.Product;
import api.repositories.IProductRepository;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void save(Product product) {
        this.iProductRepository.saveProduct(product.getCamera(),product.getCpu(),product.getImage(),product.getMemory(),product.getName(),product.getOtherDescription(),product.getPrice(),product.getQrScan(),product.getScreenSize(),product.getSelfie());
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findByProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        this.iProductRepository.updateProduct(product);
    }
}
