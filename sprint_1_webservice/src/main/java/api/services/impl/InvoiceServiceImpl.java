package api.services.impl;

import api.models.Customer;
import api.models.Invoice;
import api.models.Product;
import api.repositories.ICustomerRepository;
import api.repositories.IInvoiceRepository;
import api.repositories.IProductRepository;
import api.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IInvoiceRepository iInvoiceRepository;

    @Autowired
    ICustomerRepository iCustomerRepository;

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public Page<Invoice> findAll(String keyword, Pageable pageable) {
         return iInvoiceRepository.findAllByKeyWord(keyword,pageable);
    }

    @Override
    public Invoice findById(Long id) {
        return iInvoiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> listCustomer() {
        return iCustomerRepository.findAll();
    }

    @Override
    public List<Product> listProduct() {
        return iProductRepository.findAll();
    }
}
