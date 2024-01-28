package br.com.bancodigital.interfaces;

import br.com.bancodigital.model.conta.Conta;

import java.math.BigDecimal;

public abstract interface ContaInterface {
    void sacar(BigDecimal valor);
    void extrato();
    void depositor(BigDecimal valor);
    void transferir(BigDecimal valor);

}
