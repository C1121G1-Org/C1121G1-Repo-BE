package api.services;

import api.dto.IProductBestsellerDto;
import api.dto.InvoiceDetailDto;
import api.models.InvoiceDetail;
import api.models.Product;

import java.util.List;

public interface IInvoiceDetailService {
    void createNewInvoiceDetail(InvoiceDetail invoiceDetail);

//    void createInvoiceDetail(InvoiceDetailDto invoiceDetailDto);

    //Create by chienLV
//Time: 18h00 31/05/2022
//Function: get list product bestseller from database
    List<IProductBestsellerDto> findListProductBestseller();

    //Create by chienLV
//Time: 7h00 07/06/2022
//Function: get list product newest from database
    List<IProductBestsellerDto> findListProductNewest();

    //Create by chienLV
//Time: 14h00 07/06/2022
//Function: find list product bestseller by category from database
    List<IProductBestsellerDto> findListProductBestsellerByCategory(int id);

    void createInvoiceDetail(Long quantity, Long productId, Long invoceId);
}
