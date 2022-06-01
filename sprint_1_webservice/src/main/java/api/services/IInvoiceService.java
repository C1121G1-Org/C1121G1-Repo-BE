package api.services;

import api.dto.InvoiceDto;
import api.models.Invoice;
import api.models.Customer;
import api.models.Invoice;
import api.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IInvoiceService {
    void saveNewInvoice(Invoice invoice);
    Page<Invoice> findAll(String keyword, Pageable pageable ,String sort);
    Invoice findById(Long id);
    List<Customer> listCustomer();
    List<Product> listProduct();

    void createInvoice(InvoiceDto invoiceDto);

    Invoice getNewInvoice();
}
