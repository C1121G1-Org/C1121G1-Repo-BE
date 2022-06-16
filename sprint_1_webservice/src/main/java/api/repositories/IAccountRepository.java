package api.repositories;

import api.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
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

    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: setRoleId
    */
    @Query(value = "SELECT * FROM `sprint-1-db`.`account` WHERE `account`.user_name = :userName",countQuery = "SELECT * FROM account WHERE account.user_name = :userName",nativeQuery = true)
    Account findByUserName(@Param("userName") String userName);

    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: setRoleId
    */
    @Query(value = "SELECT * FROM `sprint-1-db`.`account` WHERE  `account`.email = :email", nativeQuery = true)
    Account findByEmail(@Param("email")String email);

    /*
        Created by KhaiTT
        Time: 22:42 31/05/2022
        Function: Use sql statement to change password under DB.
    */
    @Modifying
    @Query(value = "UPDATE account SET encrypt_password = :encryptPassword WHERE (id = :accountId); ", nativeQuery = true)
    void changPassword(@Param("encryptPassword") String encryptPassword, @Param("accountId") Long accountId);

    /*
        Created by KhaiTT
        Time: 23:15 31/05/2022
        Function: Update vetification code into account under DB.
    */
    @Modifying
    @Query(value = "UPDATE account SET verification_code = :code WHERE (user_name = :username); ", nativeQuery = true)
    void setVetification(@Param("username") String username, @Param("code") String code);

    /*
        Created by KhaiTT
        Time: 23:15 31/05/2022
        Function: refresh vetification code into account under DB.
    */
    @Modifying
    @Query(value = "UPDATE `account` SET verification_code = null WHERE (user_name = :username); ", nativeQuery = true)
    void refreshCode(@Param("username") String username);
}
