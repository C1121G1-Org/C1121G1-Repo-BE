package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

    /*
     Created by LongNHL
     Time: 9:30 1/06/2022
     Function: create CustomerDto
     */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private Long id;

    @NotBlank(message = "Vui lòng nhập tên khách hàng ")
    @Pattern(regexp = "^([^0-9]*)$", message = "Tên khách hàng sai định dạng ")
    private String customerName;

    @NotBlank(message = "Vui lòng nhập số điện thoại ")
    @Pattern(regexp = "^(090\\d{7})|(091\\d{7})|(\\(\\+84\\)90\\d{7})|(\\(\\+84\\)91\\d{7})$", message = "Số điện thoại sai định dạng ")
    private String phoneNumber;

    @NotBlank(message = "Vui lòng nhập ngày sinh khách hàng")
    private String dateOfBirth;

    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$", message = "vui lòng nhập đúng định dạng")
    private String email;
    @NotBlank(message = "Vui lòng nhập địa chỉ ")
    private String address;

    //    @NotNull(message = "Chọn giới tính")
    private boolean gender;
}
