package api.services.impl;

import api.repositories.IInvoiceRepository;
import api.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    @Autowired
    IInvoiceRepository iInvoiceRepository;
}
