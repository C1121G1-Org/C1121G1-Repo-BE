package api.services;

import api.dto.InvoiceDetailDto;
import api.models.InvoiceDetail;

public interface IInvoiceDetailService {
    void createNewInvoiceDetail(InvoiceDetail invoiceDetail);

    void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto);
}
