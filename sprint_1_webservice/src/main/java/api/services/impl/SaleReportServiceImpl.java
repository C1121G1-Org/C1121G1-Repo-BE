package api.services.impl;
import api.models.ISaleReport;
import api.models.Product;
import api.repositories.ISaleReportRepository;
import api.services.ISaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
/*
    Created by HauPV
    Time: 19:27 31/05/2022
    Function: implement interface sale report service
*/
@Service
public class SaleReportServiceImpl implements ISaleReportService {
    @Autowired
    ISaleReportRepository iSaleReportRepository;
    @Override
    public List<ISaleReport> findAllSaleReports(String startDay, String endDay, String productId) {
        return this.iSaleReportRepository.findAllSaleReport(ISaleReport.class, startDay, endDay, productId);
    }
    @Override
    public Product getLatestProduct() {
        return this.iSaleReportRepository.getLatestProduct();
    }
    @Override
    public List<Product> getListProduct() {
        return this.iSaleReportRepository.getListProduct();
    }
    @Override
    public Product findProductByIdNamePrice(Long id, String name, Double price) {
        return iSaleReportRepository.findProductByIdNamePrice(id, name, price);
    }
}