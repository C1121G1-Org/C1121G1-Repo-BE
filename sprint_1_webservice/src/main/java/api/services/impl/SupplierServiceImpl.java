package api.services.impl;

import api.models.Supplier;
import api.repositories.ISupplierRepository;
import api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    ISupplierRepository iSupplierRepository;

//    @Override
//    public List<Supplier> findAll() {
//        return iSupplierRepository.findAll();
//    }

    @Override
    public void save(Supplier supplier) {
        iSupplierRepository.createSupplier(supplier);
    }

//    @Override
//    public void save(Supplier supplier) {
//        iSupplierRepository.save(supplier);
//    }

    @Override
    public Supplier findBySupplierName(String supplierName) {
        return iSupplierRepository.findBySupplierName(supplierName);
    }
}
