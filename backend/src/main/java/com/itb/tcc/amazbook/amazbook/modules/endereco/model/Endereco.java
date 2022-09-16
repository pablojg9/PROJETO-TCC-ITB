package com.itb.tcc.amazbook.amazbook.modules.endereco.model;


import com.itb.tcc.amazbook.amazbook.modules.endereco.dto.EnderecoRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
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
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_cliente"))
    private Usuario usuario;

    public static Endereco of(EnderecoRequest enderecoRequest, Usuario usuario) {
        Endereco endereco = new Endereco();
        BeanUtils.copyProperties(enderecoRequest, endereco);
        return Endereco
                .builder()
                .id(endereco.getId())
                .cep(enderecoRequest.getCep())
                .logradouro(enderecoRequest.getLogradouro())
                .complemento(enderecoRequest.getComplemento())
                .bairro(enderecoRequest.getBairro())
                .cidade(enderecoRequest.getCidade())
                .estado(enderecoRequest.getEstado())
                .numero(enderecoRequest.getNumero())
                .usuario(usuario)
                .build();
    }
}
