package br.com.bancodigital.model.conta;

import br.com.bancodigital.model.pessoa.Cliente;
import br.com.bancodigital.model.pessoa.PessoaFisica;

import java.math.BigDecimal;

public class Conta {
    private String agencia;
    private int numero;
    private BigDecimal saldo;
    private Cliente cliente;

    public Conta(String agencia, int numero, BigDecimal saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
