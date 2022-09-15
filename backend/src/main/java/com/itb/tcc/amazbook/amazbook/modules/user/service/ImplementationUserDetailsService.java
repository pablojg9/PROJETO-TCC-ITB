package com.itb.tcc.amazbook.amazbook.modules.user.service;

import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import com.itb.tcc.amazbook.amazbook.modules.user.repository.UsuarioRepository;
import com.itb.tcc.amazbook.amazbook.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImplementationUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ImplementationUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Consultar no banco
        Usuario usuario = usuarioRepository.findUsuarioByLogin(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(MessageUtil.MESSAGE_USER_NOT_FOUND);
        }

        return new User(usuario.getLogin(), usuario.getPassword(), usuario.getAuthorities());
    }
}
