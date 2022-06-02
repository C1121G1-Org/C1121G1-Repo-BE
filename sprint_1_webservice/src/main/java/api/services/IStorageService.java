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
}
