package com.edu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomAccountCredentialsDetailService implements UserDetailsService {

    @Autowired
    private  AccountCredentialsRepository accountCredentialsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountCredentials accountCredentials =  Optional.ofNullable(accountCredentialsRepository.findByUsername(username))
                                                 .orElseThrow( () -> new UsernameNotFoundException("Usuario não encontrado"));

        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new User(accountCredentials.getUsername(), accountCredentials.getPassword(), accountCredentials.isAdmin() ? authorityListAdmin : authorityListUser);
    }
}
