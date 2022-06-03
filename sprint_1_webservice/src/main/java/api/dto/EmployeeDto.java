package api.dto;

import api.models.Account;
import api.models.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String employeeName;
    private String dateOfBirth;
    private String address;
    private String idCard;
    private String phoneNumber;
    private String image;
    private Position position;
    private Account account;
}
