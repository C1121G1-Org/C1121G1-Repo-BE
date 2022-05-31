package api.repositories;

import api.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    /*
        Created by KhaiTT
        Time: 10:28 31/05/2022
        Function: get account object by username from database using naming query method support by JpaRepository.
    */
    Account findByUserName(String username);

    /*
        Created by KhaiTT
        Time: 22:42 31/05/2022
        Function: Use sql statement to change password under DB.
    */
    @Modifying
    @Query(value = "UPDATE account SET encrypt_password = :encryptPassword WHERE (account_id = :accountId); ", nativeQuery = true)
    void changPassword(@Param("encryptPassword") String encryptPassword, @Param("accountId") Long accountId);

    /*
        Created by KhaiTT
        Time: 23:15 31/05/2022
        Function: Update vetification code into account under DB.
    */
    @Modifying
    @Query(value = "UPDATE account SET verification_code = :code WHERE (user_name = :username); ", nativeQuery = true)
    void setVetification(@Param("username") String username, @Param("code") String code);
}
