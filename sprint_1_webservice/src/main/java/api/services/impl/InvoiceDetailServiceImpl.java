package api.services.impl;

import api.dto.InvoiceDetailDto;
import api.models.InvoiceDetail;
import api.repositories.IInvoiceDetailRepository;
import api.services.IInvoiceDetailService;
import api.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailServiceImpl implements IInvoiceDetailService {
    @Autowired
    IInvoiceDetailRepository iInvoiceDetailRepository;
    @Override
    public void createNewInvoiceDetail(InvoiceDetail invoiceDetail) {
        iInvoiceDetailRepository.createInvoiceDetail(invoiceDetail.getQuantity(),invoiceDetail.getInvoice().getId(),invoiceDetail.getProduct().getId());

    }

    @Override
    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) {
        iInvoiceDetailRepository.createInvoiceDetail(invoiceDetailDto.getQuantity(), invoiceDetailDto.getInvoiceId(), invoiceDetailDto.getProductId());
    }
}
