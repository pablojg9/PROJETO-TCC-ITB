package com.itb.tcc.amazbook.amazbook.modules.user.dto;

import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.endereco.dto.EnderecoResponse;
import com.itb.tcc.amazbook.amazbook.modules.endereco.model.Endereco;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroResponse;
import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Set;

@Data
@Builder
public class UsuarioResponse {

    private Integer id;
    private String nome;
    private String login;
    private String senha;
    private Set<Endereco> enderecos;

    public static UsuarioResponse of(Usuario usuario) {
        return UsuarioResponse
                .builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .enderecos(usuario.getEnderecos())
                .build();
    }
}
