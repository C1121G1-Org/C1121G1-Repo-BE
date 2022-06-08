package api.services.impl;

import api.models.AccountRole;
import api.models.Position;
import api.repositories.IAccountRoleRepository;
import api.services.IAccountRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountRoleServiceImpl implements IAccountRoleService {
    @Autowired
    IAccountRoleRepository iAccountRoleRepository;
    @Override
    public void save(AccountRole accountRole) {
        iAccountRoleRepository.createAccountRole(accountRole);

    }

    @Override
    public void update(AccountRole accountRole) {
        iAccountRoleRepository.save(accountRole);
    }

    @Override
    public AccountRole findByIdAccount(Long id) {
        return iAccountRoleRepository.findByIdAccount(id);
    }

    @Override
    public void setRoleId(Long id, Integer positionId) {
        iAccountRoleRepository.setRoleId(id, positionId);
    }



}
