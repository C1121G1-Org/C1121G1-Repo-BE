package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
    private Long id;
    private String name;
    @NotNull(message = "Vui lòng nhập số lượng sản phẩm.")
    @Min(value = 1,message = "Số lượng sản phẩm phải lớn hơn 0")
    private Long quantity;
    private Double price;

}
