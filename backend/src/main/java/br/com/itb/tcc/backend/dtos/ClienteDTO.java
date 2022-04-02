package br.com.itb.tcc.backend.dtos;

import br.com.itb.tcc.backend.entities.Cliente;

import java.time.LocalDate;

public class ClienteDTO {

    private Integer id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String CPF;

    public ClienteDTO(){}

    public ClienteDTO(Integer id, String nome, String email, LocalDate dataNascimento, String CPF) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.CPF = CPF;
    }

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
        dataNascimento = cliente.getDataNascimento();
        CPF = cliente.getCPF();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
