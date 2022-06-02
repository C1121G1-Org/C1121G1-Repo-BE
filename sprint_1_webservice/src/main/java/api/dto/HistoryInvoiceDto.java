package api.dto;

import api.models.Customer;

public interface HistoryInvoiceDto {

    Long getInvoiceId();

    String getCreateTime();

    String getCreateDate();

    String getPayments();

    String getQuantity();

    String getCustomerName();

    String getProductName();

    String getTotalMoney();
}
