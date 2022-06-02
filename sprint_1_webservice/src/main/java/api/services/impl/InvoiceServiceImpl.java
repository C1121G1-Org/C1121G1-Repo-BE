package api.services.impl;

import api.dto.HistoryInvoiceDto;
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

    /*
    Created by CongNV
    Date:  01/06/2022
    Function: find all history
*/

    @Override
    public Page<HistoryInvoiceDto> findAll(String keyword, Pageable pageable, String sort) {
         return iInvoiceRepository.findAllByKeyWord(keyword,pageable,sort);
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
