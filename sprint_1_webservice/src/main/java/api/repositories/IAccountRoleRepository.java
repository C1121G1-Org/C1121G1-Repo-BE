package api.repositories;

import api.models.AccountRole;
import api.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface IAccountRoleRepository extends JpaRepository<AccountRole, Integer> {

    /*
        Created by Khoa PTD
        Time: 09:00 02/06/2022
        Function: Create AcountRole
    */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO account_role (`account_id`,`role_id`)" +
            " VALUES (:#{#accountRole.account.id},:#{#accountRole.role.id});", nativeQuery = true)
    void createAccountRole(AccountRole accountRole);

    /*
    Created by Khoa PTD
    Time: 09:00 02/06/2022
    Function: find By Id Account
    */
    @Query(value = "select account_role.id, account_role.account_id, account_role.role_id from account_role " +
            "inner join role on account_role.role_id = role.id " +
            "where account_role.account_id = :id",
            nativeQuery = true)
    AccountRole findByIdAccount(Long id);


    /*
    Created by Khoa PTD
    Time: 09:00 02/06/2022
    Function: setRoleId
    */
    @Transactional
    @Modifying
    @Query(value = "UPDATE `account_role` SET `role_id` = :positionId WHERE account_role.`id` = :id", nativeQuery = true)
    void setRoleId(Long id, Integer positionId);
}
