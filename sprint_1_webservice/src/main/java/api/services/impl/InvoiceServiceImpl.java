package api.services.impl;

import api.models.Invoice;
import api.repositories.IInvoiceRepository;
import api.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IInvoiceRepository iInvoiceRepository;

    @Override
    public void saveNewInvoice(Invoice invoice) {
        invoice.setCreateDate(LocalDateTime.now().toString());
        iInvoiceRepository.saveInvoice(invoice.getCreateDate(),invoice.getPayments(),invoice.getCustomer().getId());
    }
}
