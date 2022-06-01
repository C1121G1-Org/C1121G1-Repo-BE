package api.models;

/*
    Created by HauPV
    Time: 19:50 31/05/2022
    Function: Interface Model to get sale report from Database
*/

public interface ISaleReport {
    Long getId();
    String getDate();
    Integer getInvoiceQuantity();
    String getTotalMoney();
}
