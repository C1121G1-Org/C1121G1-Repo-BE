package api.dto;

import api.models.Customer;

public interface HistoryInvoiceDto {

    Long getInvoiceId();

    String getCreateTime();

    String getCreateDate();

    Integer getQuantity();

    String getCustomerName();

    String getProductName();

    Double getTotalMoney();

    String getInvoiceDetailId();
}
