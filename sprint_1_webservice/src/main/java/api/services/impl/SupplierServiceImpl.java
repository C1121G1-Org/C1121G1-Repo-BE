package api.services.impl;

import api.models.Supplier;
import api.repositories.ISupplierRepository;
import api.services.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
