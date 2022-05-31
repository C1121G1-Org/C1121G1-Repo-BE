package api.services.impl;

import api.models.Account;
import api.repositories.IAccountRepository;
import api.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountRepository iAccountRepository;

    @Override
    public Account findByUserName(String username) {
        return iAccountRepository.findByUserName(username);
    }
}
