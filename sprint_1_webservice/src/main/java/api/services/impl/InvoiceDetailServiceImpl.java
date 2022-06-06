package api.services.impl;

import api.dto.IProductBestsellerDto;
import api.dto.InvoiceDetailDto;
import api.models.InvoiceDetail;
import api.models.Product;
import api.repositories.IInvoiceDetailRepository;
import api.services.IInvoiceDetailService;
import api.services.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements IInvoiceDetailService {
    @Autowired
    IInvoiceDetailRepository iInvoiceDetailRepository;

    /*
    Created by LongNHL
    Time: 21:30 31/05/2022
    Function: create invoiceDetail
    */
    @Override
    public void createNewInvoiceDetail(InvoiceDetail invoiceDetail) {
        iInvoiceDetailRepository.createInvoiceDetail(invoiceDetail.getQuantity(),invoiceDetail.getInvoice().getId(),invoiceDetail.getProduct().getId());

    }

    /*
    Created by LongNHL
    Time: 15:00 01/05/2022
    Function: create invoiceDetail
    */
    @Override
    public void createInvoiceDetail(Long quantity, Long productId, Long invoiceId) {
        iInvoiceDetailRepository.createInvoiceDetail(quantity,productId, invoiceId);
    }

//    @Override
//    public void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto) {
//        iInvoiceDetailRepository.createInvoiceDetail(invoiceDetailDto.getQuantity(), invoiceDetailDto.getInvoiceId(), invoiceDetailDto.getProductId());
//    }

    //Create by chienLV
//Time: 18h00 31/05/2022
//Function: get list product bestseller from database
    @Override
    public List<IProductBestsellerDto> findListProductBestseller() {
        return iInvoiceDetailRepository.findListProductBestseller(IProductBestsellerDto.class);
    }

}
