package api.services.impl;

import api.models.Account;
import api.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
    Created by KhaiTT
    Time: 10:30 31/05/2022
    Function: class AccountDetailsServiceImpl implements interface UserDetailsService to override method
              loadUserByUsername(String username), this method use interface IAccountRepository to get account
              object by username, after that use method build from class AccountDetailsImpl to tranfer account
              object to UserDetails object, if the account is not found, an exception is returned.
*/
@Service
public class AccountDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    @Transactional
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username: " + username);
        Account account = iAccountRepository.findByUserName(username);
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        System.out.println("loadUserByUsername() at AccountDetailsServiceImpl in service package.");
        return AccountDetailsImpl.build(account);
    }
}
