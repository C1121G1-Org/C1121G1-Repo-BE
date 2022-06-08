package api.services;

import api.models.Storage;

import java.util.List;

public interface IStorageService {

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    getAllStorage() = abstract method to get all Storages
                  2/    createStorage() = abstract method to create Storage
    */
    List<Storage> getAllStorage();
    void createStorage(Storage storage);

    /*
     Created by LongNHL
     Time: 22:30 1/06/2022
     Function: find storage by productId after create invoice
     */
    Storage getStorageByIdProduct(Long productId);
        /*
        Created by LongNHL
        Time: 22:30 1/06/2022
        Function: update quantity for product after create invoice
        */
    void updateQuantityProduct(Storage storage);


}
