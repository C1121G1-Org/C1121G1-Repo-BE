package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

    /*
     Created by LongNHL Hoang
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
    @Pattern(regexp = "^([A-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[A-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$", message = "Tên khách hàng sai định dạng ")
    private String customerName;

    @NotBlank(message = "Vui lòng nhập số điện thoại ")
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", message = "Số điện thoại sai định dạng ")
    private String phoneNumber;

    @NotBlank(message = "Vui lòng nhập ngày sinh khách hàng")
    @Pattern(regexp = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$", message = "vui lòng nhập đúng định dạng")
    private String dateOfBirth;

    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$", message = "vui lòng nhập đúng định dạng")
    private String email;
    @NotBlank(message = "Vui lòng nhập địa chỉ ")
    private String address;

    //    @NotNull(message = "Chọn giới tính")
    private boolean gender;
}
