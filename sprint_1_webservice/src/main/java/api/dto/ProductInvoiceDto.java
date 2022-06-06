package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    /*
     Created by LongNHL
     Time: 9:30 1/06/2022
     Function: create product for invoice
     */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInvoiceDto {
    private Long productId;
    private Long quantity;
    private Long id;
    private String name;
    private Double price;

}
