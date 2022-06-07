package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/*
 Created by LongNHL
 Time: 9:30 1/06/2022
 Function: create invoiceDto
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;
    private String createTime;
    private String createDate;
    private Double totalMoney;
    @NotBlank(message = "Vui lòng nhập loại thanh toán")
    private String payments;
    @Valid
    private CustomerDto customerDto;

}
