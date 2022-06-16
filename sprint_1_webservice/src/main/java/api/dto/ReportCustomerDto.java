package api.dto;

/*
    Created by TuanNQ
    Time: 18:00 31/05/2022
    Function: Show all list report customer and Show list of customer reports by age and gender
*/
public interface ReportCustomerDto {
//    private Integer id;
//    private String name;
//    private Boolean gender;
//    private String dateOfBirth;
//    private String email;
//    private String phoneNumber;
//    private Long purchaseTimes;

    Long getId();
    String getName();
    Boolean getGender();
    String getDateOfBirth();
    String getEmail();
    String getPhoneNumber();
    Long getPurchaseTimes();
    Integer getAge();
}
