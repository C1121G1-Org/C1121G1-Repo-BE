package api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


    /*
     Created by LongNHL
     Time: 9:30 1/06/2022
     Function: create invoiceDetailDto
     */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailDto {
    private Long id;
    @Valid
    private InvoiceDto invoiceDto;
    @NotNull(message = "Vui lòng chọn sản phẩm muốn mua")
    private List<ProductInvoiceDto> productInvoiceDtoList;
    private Double totalMoney;
    @NotBlank(message = "Vui lòng nhập loại thanh toán")
    private String payments;
    @Valid
    private CustomerDto customerDto;
    @NotNull(message = "Vui lòng chọn sản phẩm muốn mua")
    private List<ProductInvoiceDto> products;
}
