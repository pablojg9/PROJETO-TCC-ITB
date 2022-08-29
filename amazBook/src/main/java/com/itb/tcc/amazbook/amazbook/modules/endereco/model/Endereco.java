package com.itb.tcc.amazbook.amazbook.modules.endereco.model;


import com.itb.tcc.amazbook.amazbook.modules.user.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CEP", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", length = 120, nullable = false)
    private String logradouro;

    @Column(name = "COMPLEMENTO", length = 100, nullable = false)
    private String complemento;

    @Column(name = "BAIRRO", length = 100, nullable = false)
    private String bairro;

    @Column(name = "CIDADE", length = 50, nullable = false)
    private String cidade;

    @Column(name = "ESTADO", length = 100, nullable = false)
    private String estado;

    @Column(name = "NUMERO", nullable = false)
    private Short numero;

    @ManyToOne
    @Column(name = "FK_CLIENTE", nullable = false)
    private Cliente cliente;
}
