package api.repositories;

import api.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    /*
        Created by KhaiTT
        Time: 10:28 31/05/2022
        Function: get account object by username from database using naming query method support by JpaRepository.
    */
    Account findByUserName(String username);
}
