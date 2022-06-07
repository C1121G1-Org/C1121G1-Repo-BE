package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
<<<<<<< HEAD
import javax.validation.constraints.Pattern;

    /*
     Created by LongNHL Hoang
=======
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

    /*
     Created by LongNHL Hoang
<<<<<<< HEAD
>>>>>>> 420924e132898405b15ad91cdb0f80d6afa6338a
>>>>>>> 70e7e596057a3997c8ee0de59be352a38b674093
>>>>>>> manager-product
=======
>>>>>>> 536a668439894a3bc5c179a4dbd01a8c13b6966e
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
<<<<<<< HEAD

    @NotBlank(message = "Vui lòng nhập ngày sinh khách hàng")
=======
    @NotBlank(message = "Vui lòng nhập ngày sinh khách hàng")
    @Pattern(regexp = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", message = "vui lòng nhập đúng định dạng")
    private String dateOfBirth;
>>>>>>> manager-product
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$", message = "vui lòng nhập đúng định dạng")
    private String email;
    @NotBlank(message = "Vui lòng nhập địa chỉ ")
    private String address;
    @NotNull(message = "Vui lòng chọn giới tính")
    private boolean gender;
}
