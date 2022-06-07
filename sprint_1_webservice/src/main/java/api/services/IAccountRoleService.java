package api.services;

import api.models.AccountRole;


public interface IAccountRoleService {

    void save(AccountRole accountRole);

    void update(AccountRole accountRole);

    AccountRole findByIdAccount(Long id);

    void setRoleId(Long id, Integer positionId);

}
