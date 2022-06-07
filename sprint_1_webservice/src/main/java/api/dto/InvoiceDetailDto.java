package api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

<<<<<<< HEAD
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
=======

import javax.validation.constraints.NotBlank;
>>>>>>> manager-product
import javax.validation.constraints.NotNull;
import java.util.List;


    /*
     Created by LongNHL
     Time: 9:30 1/06/2022
     Function: create invoiceDetailDto
     */
<<<<<<< HEAD

=======
>>>>>>> manager-product
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetailDto {
    private Long id;
    @Valid
<<<<<<< HEAD
=======
    private InvoiceDto invoiceDto;
    @NotNull(message = "Vui lòng chọn sản phẩm muốn mua")
    private List<ProductInvoiceDto> productInvoiceDtoList;
>>>>>>> manager-product
    private Double totalMoney;
    @NotBlank(message = "Vui lòng nhập loại thanh toán")
    private String payments;
    @Valid
    private CustomerDto customerDto;
    @NotNull(message = "Vui lòng chọn sản phẩm muốn mua")
    private List<ProductInvoiceDto> products;
<<<<<<< HEAD
=======

>>>>>>> manager-product
}
