package api.services.impl;

import api.models.Supplier;
import api.repositories.ISupplierRepository;
import api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class SupplierServiceImpl implements ISupplierService {
    @Autowired
    ISupplierRepository iSupplierRepository;

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findSupplier() = call repo to find Supplier by id
                  2/    getAllSupplier() = call repo to get all Suppliers
                  3/    getAllSupplierPagingAndSearch() = call repo to search Suppliers and paging
    */

    @Override
    public Supplier findSupplier(Long supplierDto) {
        return iSupplierRepository.findSupplier(supplierDto);
    }

    @Override
    public List<Supplier> getAllSupplier() {
        return iSupplierRepository.getAllSupplier();
    }

    @Override
    public Page<Supplier> getAllSupplierPagingAndSearch(Pageable pageable, String supplier, String address, String phone, String email) {
        return iSupplierRepository.getAllSupplierPagingAndSearch(pageable, supplier, address, phone, email);
    }
    /*
            Created by ngocTTB
            Time: 19:00 31/05/2022
            Function: 1/    save(Supplier supplier) = store relative supplier
                      2/    findBySupplierName(String supplierName) = find the supplier name field to check

        */
    @Override
    public void save(Supplier supplier) {

        iSupplierRepository.createSupplier(supplier);
    }

    @Override
    public Supplier findBySupplierName(String supplierName) {
        return iSupplierRepository.findBySupplierName(supplierName);
    }

    @Override
    public Supplier findByEmail(String email) {
        return iSupplierRepository.findByEmail(email);
    }
}
