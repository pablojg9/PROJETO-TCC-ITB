package com.itb.tcc.amazbook.amazbook.modules.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itb.tcc.amazbook.amazbook.modules.endereco.model.Endereco;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioRequest;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import java.util.*;

@Entity
@Data
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(nullable = false, length = 50, unique = true)
    @Email
    private String login;

    @Column(nullable = false, length = 70)
    private String senha;

    @JsonIgnore
    private String token = "";

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Endereco> enderecos = new HashSet<>();
    public Usuario(){}

    public Usuario(Integer id, String nome, String email, String senha, String token) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = email;
        this.token = token;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinTable(name = "usuarios_role",uniqueConstraints = @UniqueConstraint(
            columnNames = { "usuario_id", "role_id" },
            name = "unique_role_user"), joinColumns = { @JoinColumn(name = "usuario_id",
            referencedColumnName = "id",
            table = "usuario", foreignKey = @ForeignKey(name = "usuario_fk"))},

            inverseJoinColumns = { @JoinColumn(name = "role_id",
                    referencedColumnName = "id", updatable = false,
                    table = "role", foreignKey = @ForeignKey(name = "role_fk", value = ConstraintMode.CONSTRAINT)
            )})
    private List<Role> roles;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.senha;
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return this.login;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static Usuario of(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioRequest, usuario);
        return usuario;
    }
}