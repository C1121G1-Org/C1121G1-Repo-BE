package api.services;


import api.models.Account;


public interface IAccountService {
    void save(Account account);

    void update(Account account);

    Account findByUserName(String userName);

    Account findByEmail(String email);

    /*
        Created by KhaiTT
        Date: 22:40 31/05/2022
        Function: This changePassword() method change account password.
    */
    void changePassword(String encryptPassword, Long accountId);

    /*
        Created by KhaiTT
        Date: 23:17 31/05/2022
        Function: This setVetificationCode() method use to set verification code to account.
    */
    String setVetificationCode(Account account);

    /*
        Created by KhaiTT
        Date: 23:17 31/05/2022
        Function: This refreshCode() method use to refresh change password code after 60s.
    */
    void refreshCode(String username);
}
