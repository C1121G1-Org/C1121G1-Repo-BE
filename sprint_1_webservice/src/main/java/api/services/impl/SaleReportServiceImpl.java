package api.services.impl;

import api.models.ISaleReport;
import api.repositories.ISaleReportRepository;
import api.services.ISaleReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<ISaleReport> findAllSaleReports() {
        return this.iSaleReportRepository.findAllSaleReport(ISaleReport.class);
    }
}
