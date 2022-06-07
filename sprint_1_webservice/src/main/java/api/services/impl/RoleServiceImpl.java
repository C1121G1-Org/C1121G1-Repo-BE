package api.services.impl;

import api.models.Role;
import api.repositories.IRoleRepository;
import api.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository iRoleRepository;

    @Override
    public List<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role findById(Integer id) {
        return iRoleRepository.findById(id).orElse(null);
    }
}
