package api.services;


import api.dto.HistoryInvoiceDto;
import api.models.Customer;
import api.models.Invoice;
import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IInvoiceService {
    /*
    Created by CongNV
    Date:  06/06/2022
    Function: find all history
*/

    Page<HistoryInvoiceDto> findAll(String keyword, Pageable pageable , String sort);
    Page<HistoryInvoiceDto> findProductsInvoice(Pageable pageable, Long id);

    Invoice findById(Long id);
    List<Customer> listCustomer();
    List<Product> listProduct();

    void saveNewInvoice(Invoice invoice);

    Invoice getNewInvoice();
}
