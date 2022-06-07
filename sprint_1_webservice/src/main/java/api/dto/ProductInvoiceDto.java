package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
    /*
     Created by LongNHL
     Time: 9:30 1/06/2022
     Function: create product for invoice
     */
=======
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/*
 Created by LongNHL
 Time: 9:30 1/06/2022
 Function: create product for invoice
 */
>>>>>>> manager-product
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInvoiceDto {
<<<<<<< HEAD
    private Long id;
    private String name;
=======
    private Long productId;
    private Long id;
    private String name;
    @NotNull(message = "Vui lòng nhập số lượng sản phẩm.")
    @Min(value = 1,message = "Số lượng sản phẩm phải lớn hơn 0")
>>>>>>> manager-product
    private Long quantity;
    private Double price;

}
