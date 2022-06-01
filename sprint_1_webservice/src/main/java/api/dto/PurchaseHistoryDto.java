package api.dto;

/*
       Created by TuanNQ
       Time: 18:15 31/05/2022
       Function: Show detail purchase history of customer
   */
public interface PurchaseHistoryDto {

    Long getId();
    String getName();
    Boolean getGender();
    String getDateOfBirth();
    String getEmail();
    String getPhoneNumber();
    String getPurchaseDate();
    String getPurchaseProducts();
    String getTotalMoney();
}
