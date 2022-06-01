package api.services.impl;

import api.dto.PurchaseHistoryDto;
import api.dto.ReportCustomerDto;
import api.repositories.ICustomerRepository;
import api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show all list report customer
    */
    @Override
    public Page<ReportCustomerDto> filterAll(Pageable pageable) {
        return iCustomerRepository.filterAll(pageable);
    }

    /*
        Created by TuanNQ
        Time: 18:00 31/05/2022
        Function: Show list of customer reports by age and gender
    */
    @Override
    public Page<ReportCustomerDto> filterByGenderAndAge(Pageable pageable, Boolean gender, String age) {
        return iCustomerRepository.filterByGenderAndAge(pageable, gender, age);
    }

    /*
        Created by TuanNQ
        Time: 18:15 31/05/2022
        Function: Show detail purchase history of customer
    */
    @Override
    public Page<PurchaseHistoryDto> detailPurchaseHistory(Long id, Pageable pageable) {
        return iCustomerRepository.detail(id, pageable);
    }


}
