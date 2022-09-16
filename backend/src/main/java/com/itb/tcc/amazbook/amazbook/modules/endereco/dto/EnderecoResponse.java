package com.itb.tcc.amazbook.amazbook.modules.endereco.dto;

import com.itb.tcc.amazbook.amazbook.modules.endereco.model.Endereco;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Set;

@Data
@Builder
public class EnderecoResponse {

    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Short numero;
    private UsuarioResponse usuario;

    public static EnderecoResponse of(Endereco endereco) {
        return EnderecoResponse
                .builder()
                .id(endereco.getId())
                .cep(endereco.getCep())
                .logradouro(endereco.getLogradouro())
                .complemento(endereco.getComplemento())
                .bairro(endereco.getBairro())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .numero(endereco.getNumero())
                .usuario(UsuarioResponse.of(endereco.getUsuario()))
                .build();
    }
}
