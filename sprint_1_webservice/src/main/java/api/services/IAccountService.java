package api.services;

import api.models.Account;

public interface IAccountService {
    Account findByUserName(String username);
}
