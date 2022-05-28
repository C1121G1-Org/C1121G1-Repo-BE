package api.services.impl;

import api.repositories.IStorageRepository;
import api.services.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements IStorageService {
    @Autowired
    IStorageRepository iStorageRepository;
}
