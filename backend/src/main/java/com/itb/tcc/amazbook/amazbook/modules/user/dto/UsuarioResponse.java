package com.itb.tcc.amazbook.amazbook.modules.user.dto;

import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UsuarioResponse {

    private Integer id;
    private String nome;
    private String login;
    private String senha;

    public static UsuarioResponse of(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        BeanUtils.copyProperties(usuario, usuarioResponse);
        return usuarioResponse;
    }
}
