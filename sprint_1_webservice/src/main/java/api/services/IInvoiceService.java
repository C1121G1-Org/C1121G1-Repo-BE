package api.services;

import api.dto.InvoiceDto;
import api.models.Invoice;

public interface IInvoiceService {
    void saveNewInvoice(Invoice invoice);
}
