package api.services;

import api.models.ISaleReport;
import api.models.Product;

import java.util.List;
import java.util.Optional;

/*
    Created by HauPV
    Time: 19:27 31/05/2022
    Function: interface sale report service
*/
public interface ISaleReportService {
    List<ISaleReport> findAllSaleReports(String startDay, String endDay,String productId);

    Product getLatestProduct();

    List<Product> getListProduct();
}
