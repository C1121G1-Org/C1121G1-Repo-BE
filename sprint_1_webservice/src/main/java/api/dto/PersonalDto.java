package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/*
    Created by KhaiTT
    Date: 15:08 01/06/2022
    Function: PersonalDto object use to change personal information.
*/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalDto {
    @NotNull
    private Long id;
    @NotBlank
    private String employeeName;
    @NotBlank
    @Pattern(regexp = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$", message = "Vui lòng nhập đúng định dạng ngày tháng.")
    private String dateOfBirth;
    private String address;
    private String idCard;
    private String phoneNumber;
    private String image;
}