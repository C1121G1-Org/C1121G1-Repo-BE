package api.services;

import api.models.Account;

public interface IAccountService {
    void save(Account account);


    void update(Account account);
}
