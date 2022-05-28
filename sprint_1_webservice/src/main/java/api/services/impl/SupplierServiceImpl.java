package api.services.impl;

import api.repositories.ISupplierRepository;
import api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    ISupplierRepository iSupplierRepository;
}
