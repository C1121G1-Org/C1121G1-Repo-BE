package api.services.impl;

import api.models.Account;
import api.models.Employee;
import api.repositories.IAccountRepository;
import api.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public void update(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public Account findByUserName(String userName) {
        return iAccountRepository.findByUserName(userName);
    }

    @Override
    public Account findByEmail(String email) {
        return iAccountRepository.findByEmail(email);
    }



}
