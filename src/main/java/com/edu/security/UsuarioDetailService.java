package com.edu.security;

import com.edu.usuario.Usuario;
import com.edu.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Usuario accountCredentials =  Optional.ofNullable(usuarioRepository.findByUsername(username))
//                                                 .orElseThrow( () -> new UsernameNotFoundException("Usuario não encontrado"));

        Usuario accountCredentials = new Usuario();
        accountCredentials.setUsername("admin");
        accountCredentials.setPassword(new BCryptPasswordEncoder().encode("admin"));

        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new User(accountCredentials.getUsername(), accountCredentials.getPassword(), accountCredentials.isAdmin() ? authorityListAdmin : authorityListUser);
    }
}
