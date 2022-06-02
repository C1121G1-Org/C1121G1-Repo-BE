package api.services.impl;

import api.models.Storage;
import api.repositories.IStorageRepository;
import api.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements IStorageService {
    @Autowired
    IStorageRepository iStorageRepository;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    getAllStorage() = call repo to get all Storages
                  2/    createStorage() = call repo to create Storage
    */

    @Override
    public List<Storage> getAllStorage() {
        return iStorageRepository.getAllStorage();
    }

    @Override
    public void createStorage(Storage storage) {
        iStorageRepository.createStorage(storage);
    }
}
