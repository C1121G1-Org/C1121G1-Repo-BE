package api.dto;


import api.models.Invoice;
import api.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailDto {
    private Long id;
    @Valid
    private InvoiceDto invoiceDto;



    private List<ProductInvoiceDto> productInvoiceDtoList;
}
