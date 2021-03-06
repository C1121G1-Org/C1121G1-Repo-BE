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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
        Created by LongNHL
        Time: 21:30 31/05/2022
        Function: create invoice
        */
    @Override
    public void saveNewInvoice(Invoice invoice) {
        invoice.setCreateDate(LocalDate.now().toString());
        invoice.setCreateTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        iInvoiceRepository.saveInvoice(invoice.getCreateDate(), invoice.getCreateTime(),invoice.getTotalMoney(), invoice.getPayments(), invoice.getCustomer().getId());
    }


    @Override
    public Page<HistoryInvoiceDto> findAll(String keyword, Pageable pageable, String sort) {
         return iInvoiceRepository.findAllByKeyWord(keyword,pageable,sort);
    }

    @Override
    public Page<HistoryInvoiceDto> findProductsInvoice(Pageable pageable, Long id) {
        return iInvoiceRepository.findProductsInvoice(pageable, id);
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

        /*
        Created by LongNHL
        Time: 21:30 31/05/2022
        Function: get invoice after create
        */

    @Override
    public Invoice getNewInvoice() {
        return iInvoiceRepository.getNewInvoice();
    }
}
