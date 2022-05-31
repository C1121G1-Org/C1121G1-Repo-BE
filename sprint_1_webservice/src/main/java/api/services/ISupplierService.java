package api.services;

import api.models.Supplier;

import java.util.List;

public interface ISupplierService {
//    List<Supplier> findAll();

    void save(Supplier supplier);

    Supplier findBySupplierName(String supplierName);
}
