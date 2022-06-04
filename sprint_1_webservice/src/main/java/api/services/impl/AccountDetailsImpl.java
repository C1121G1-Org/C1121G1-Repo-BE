package api.services.impl;

import api.models.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
    Created by KhaiTT
    Date: 10:17 31/05/2022
    Function: class AccountDetailsImpl implements interface UserDetails to override all method
              of interface UserDetails to store account information which is later encapsulated
              into Authentication objects.
*/
public class AccountDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String username;
    private Boolean enabled;
    private String imageLink;
    @JsonIgnore
    private String password;
    List<GrantedAuthority> authorities = null;

    public AccountDetailsImpl(Long id, String username, Boolean enabled, String password, String imageLink, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.enabled = enabled;
        this.password = password;
        this.imageLink = imageLink;
        this.authorities = authorities;
    }

    /*
        Function: method build(Account account) is used to convert the Account object
                  to an AccountDetailsImpl object which implements the UserDetails interface.
    */
    public static AccountDetailsImpl build(Account account) {
        List<GrantedAuthority> authorities = account.getAccountRoleSet().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().getRoleName()))
                .collect(Collectors.toList());
        return new AccountDetailsImpl(
                account.getId(),
                account.getEmployee().getEmployeeName(),
                account.getIsEnabled(),
                account.getEncryptPassword(),
                account.getEmployee().getImage(),
                authorities);
    }

    public Long getId() {
        return id;
    }

    public String getImageLink() {
        return imageLink;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        AccountDetailsImpl account = (AccountDetailsImpl) o;
        return Objects.equals(id, account.id);
    }

}
