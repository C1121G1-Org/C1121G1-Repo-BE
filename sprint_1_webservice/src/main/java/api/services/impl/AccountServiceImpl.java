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

    /*
        Created by KhaiTT
        Date: 22:40 31/05/2022
        Function: This changePassword() method change account password.
    */
    @Override
    public void changePassword(String encryptPassword, Long accountId) {
        iAccountRepository.changPassword(encryptPassword, accountId);
    }

    /*
        Created by KhaiTT
        Date: 23:17 31/05/2022
        Function: This setVetificationCode() method use to set verification code to account.
    */
    @Override
    public String setVetificationCode(Account account) {
        String code = RandomString.make(6);
        iAccountRepository.setVetification(account.getUserName(), code);
        return code;
    }

    /*
            Created by KhaiTT
            Date: 23:17 31/05/2022
            Function: This refreshCode() method use to refresh change password code after 60s.
        */
    @Override
    public void refreshCode(String username) {
        iAccountRepository.refreshCode(username);
    }

}
