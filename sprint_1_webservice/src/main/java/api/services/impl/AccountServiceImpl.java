package api.services.impl;

import api.models.Account;
import api.repositories.IAccountRepository;
import api.services.IAccountService;
import net.bytebuddy.utility.RandomString;
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

    @Override
    public void changePassword(String encryptPassword, Long accountId) {
        iAccountRepository.changPassword(encryptPassword, accountId);
    }

    @Override
    public String setVetificationCode(Account account) {
        String code = RandomString.make(6);
        iAccountRepository.setVetification(account.getUserName(), code);
        return code;
    }
}
