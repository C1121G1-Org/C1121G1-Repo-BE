package api.dto;

import api.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    private Long id;
    private String createDate;

    @NotEmpty(message = "Vui lòng nhập loại thanh toán")
    private String payments;

    private Customer customer;
}
