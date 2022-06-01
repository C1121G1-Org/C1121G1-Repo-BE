package api.dto;


import api.models.Invoice;
import api.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailDto {
    private Long id;


    private Long quantity;


    private Long invoiceId;


    private Long productId;
}
