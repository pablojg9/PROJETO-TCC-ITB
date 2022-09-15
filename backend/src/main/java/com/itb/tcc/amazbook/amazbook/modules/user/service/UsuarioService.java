package com.itb.tcc.amazbook.amazbook.modules.user.service;


import com.itb.tcc.amazbook.amazbook.exceptions.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioResponse;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import com.itb.tcc.amazbook.amazbook.modules.user.repository.UsuarioRepository;
import com.itb.tcc.amazbook.amazbook.utils.ErrorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioResponse save(UsuarioRequest usuarioRequest){

        String passwordCripto = new BCryptPasswordEncoder().encode(usuarioRequest.getSenha());
        usuarioRequest.setSenha(passwordCripto);

        Usuario usuario = usuarioRepository.save(Usuario.of(usuarioRequest));
        return UsuarioResponse.of(usuario);
    }

    private void validateClienteDataInformed(UsuarioRequest usuarioRequest) {
        if(isEmpty(usuarioRequest.getNome())){
            throw new ValidationException(ErrorUtil.CLIENTE_NAME_EMPTY);
        }

        if(isEmpty(usuarioRequest.getLogin())){
            throw new ValidationException(ErrorUtil.CLIENTE_EMAIL_EMPTY);
        }
        if(isEmpty(usuarioRequest.getSenha())){
            throw new ValidationException(ErrorUtil.CLIENTE_PASSWORD_EMPTY);
        }
    }
    private void validateInformedId(Integer id) {
        if(isEmpty(id)){
            throw new ValidationException(ErrorUtil.ID_EMPTY);
        }
    }
}
