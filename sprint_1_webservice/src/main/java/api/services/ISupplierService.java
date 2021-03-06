package api.services;

import api.models.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISupplierService {

    /*
        Created by khoaVC
        Time: 21:54 31/05/2022
        Function: 1/    findSupplier() = abstract method to find Supplier by id
                  2/    getAllSupplier() = abstract method to get all Suppliers
                  3/    getAllSupplierPagingAndSearch() = abstract method to search Supplier and paging
    */
    Supplier findSupplier(Long supplierDto);
    List<Supplier> getAllSupplier();
    Page<Supplier> getAllSupplierPagingAndSearch(Pageable pageable, String supplier, String address, String phone, String email);

    /*
    Created by NgocTTB
    Time: 09:00 31/05/2022
    Function: 1/ void save
              2/ Supplier findBySupplierNam
    */

    void save(Supplier supplier);

    Supplier findBySupplierName(String supplierName);

    Supplier findByEmail(String email);
}
