package com.itb.tcc.amazbook.amazbook.modules.endereco.dto;

import lombok.Data;

@Data
public class EnderecoRequest {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Short numero;
}
