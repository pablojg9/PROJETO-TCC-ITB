package com.itb.tcc.amazbook.amazbook.modules.endereco.dto;

import com.itb.tcc.amazbook.amazbook.modules.endereco.model.Endereco;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class EnderecoResponse {

    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Short numero;

    public static EnderecoResponse of(Endereco endereco) {
        EnderecoResponse enderecoResponse = new EnderecoResponse();
        BeanUtils.copyProperties(endereco, enderecoResponse);
        return enderecoResponse;
    }
}
