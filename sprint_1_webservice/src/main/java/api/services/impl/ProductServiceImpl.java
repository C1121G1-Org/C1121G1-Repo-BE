package api.services.impl;
import api.dto.IProductDto;
import api.models.Product;
import api.repositories.IProductRepository;
import api.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Created by hieuMMT and tamHT
        Time: 18:15 31/05/2022
        Function: search Products
    */
    @Override
    public Page<IProductDto> findAllProduct(Pageable pageable, String key1, String key2, String key3) {
        return iProductRepository.pageFindAll(IProductDto.class,pageable,key1, key2 , key3);
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
    public Optional<Product> findById(Long id) {
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


    /*
    Created by tuanPA
    Time: 18:15 2/06/2022
    Function: updateProduct
*/
    @Override
    public Product findProductByName(String name) {
        return this.iProductRepository.findProductByName(name);
    }

    /*
         Created by hieuMMT
         Time: 14:15 1/06/2022
         Function: delete product
     */
    @Override
    public void deleteFlag(Long id) {
        this.iProductRepository.deleteFlag(id);
    }

    /*
      Created by LongNHL
     Time: 15:00 2/06/2022
     Function: use test create invoice
      */
    @Override
    public List<Product> findAllTest() {
        return iProductRepository.findAll();
    }



}
