package api.services;

import api.models.Supplier;

import java.util.List;

public interface ISupplierService {
//    List<Supplier> findAll();

    /*
    Created by NgocTTB
    Time: 09:00 31/05/2022
    Function: void save + Supplier findBySupplierNam
    */

    void save(Supplier supplier);

    Supplier findBySupplierName(String supplierName);
}
