package api.repositories;

import api.models.Account;
import api.models.AccountRole;
import api.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountRepository extends JpaRepository<Account, Long> {

    /*
Created by Khoa PTD
Time: 09:00 02/06/2022
Function: setRoleId
*/
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO account (`email`,`encrypt_password`,`is_enabled`,`user_name`,`verification_code`)" +
            " VALUES (:#{#account.email},:#{#account.encryptPassword},:#{#account.isEnabled},:#{#account.userName},:#{#account.verificationCode}); ", nativeQuery = true)
    void createAccount(Account account);

    @Query(value = "SELECT * FROM account WHERE account.user_name = :userName",countQuery = "SELECT * FROM account WHERE account.user_name = :userName",nativeQuery = true)
    Account findByUserName(@Param("userName") String userName);


    @Query(value = "SELECT * FROM account WHERE  account.email = :email", nativeQuery = true)
    Account findByEmail(@Param("email")String email);




}
