package api.services;


import api.models.Invoice;
import api.models.Customer;
import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IInvoiceService {

    Page<Invoice> findAll(String keyword, Pageable pageable);
    void saveNewInvoice(Invoice invoice);

    Invoice findById(Long id);
    List<Customer> listCustomer();
    List<Product> listProduct();



    Invoice getNewInvoice();
}
