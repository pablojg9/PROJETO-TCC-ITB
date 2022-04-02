package br.com.itb.tcc.backend.exceptions;

public class ExceptionResponse {

    private String message;
    private String descricao;

    public ExceptionResponse(String message, String descricao) {
        this.message = message;
        this.descricao = descricao;
    }

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessagem() {
        return message;
    }

    public void setMessagem(String messagem) {
        this.message = messagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
