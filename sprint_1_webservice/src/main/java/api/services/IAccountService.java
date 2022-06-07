package api.services;


import api.models.Account;


public interface IAccountService {
    void save(Account account);


    void update(Account account);

    Account findByUserName(String userName);

    Account findByEmail(String email);

}
