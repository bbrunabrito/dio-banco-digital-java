package br.com.bancodigital.model.cartao;

import br.com.bancodigital.model.conta.Conta;

import java.time.LocalDate;
import java.util.Objects;

public class Cartao {
    private String numero;
    private String nomeCartao;
    private Conta conta;
    private String tipo; //Débito, crédito
    private String codigoSeguranca;
    private LocalDate dataValidade;

    public Cartao(String numero, String nomeCartao, Conta conta, String tipo, String codigoSeguranca, LocalDate dataValidade) {
        this.numero = numero;
        this.nomeCartao = nomeCartao;
        this.conta = conta;
        this.tipo = tipo;
        this.codigoSeguranca = codigoSeguranca;
        this.dataValidade = dataValidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigoSeguranca() {
        return codigoSeguranca;
    }

    public void setCodigoSeguranca(String codigoSeguranca) {
        this.codigoSeguranca = codigoSeguranca;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cartao cartao)) return false;
        return Objects.equals(numero, cartao.numero) && Objects.equals(codigoSeguranca, cartao.codigoSeguranca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, codigoSeguranca);
    }
}
