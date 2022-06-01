package api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

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
    private Long id;
    @NotBlank
    private String employeeName;
    private String dateOfBirth;
    private String address;
    private String idCard;
    private String phoneNumber;
    private String image;
}