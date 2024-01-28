package br.com.bancodigital.model.conta;

import br.com.bancodigital.interfaces.ContaInterface;
import br.com.bancodigital.exception.CodigoErro;
import br.com.bancodigital.exception.ContaException;
import br.com.bancodigital.model.cartao.Cartao;
import br.com.bancodigital.model.pessoa.Cliente;

import java.math.BigDecimal;

public class ContaCorrente extends Conta implements ContaInterface {
    private BigDecimal limiteChequeEspecial;
    private BigDecimal limiteTransferenciaDiaria;
    private Cartao cartao;

    public ContaCorrente(String agencia, int numero, BigDecimal saldo, Cliente cliente,
                         BigDecimal limiteChequeEspecial, BigDecimal limiteTransferenciaDiaria) {
        super(agencia, numero, saldo, cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.limiteTransferenciaDiaria = limiteTransferenciaDiaria;
    }


    public BigDecimal getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(BigDecimal limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public BigDecimal getLimiteTransferenciaDiaria() {
        return limiteTransferenciaDiaria;
    }

    public void setLimiteTransferenciaDiaria(BigDecimal limiteTransferenciaDiaria) {
        this.limiteTransferenciaDiaria = limiteTransferenciaDiaria;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }


    @Override
    public String toString() {
        return "Tipo de Conta: Corrente\n" +
                "Agencia: " + this.getAgencia() +
                "\nNumero: " + this.getNumero() +
                "\nSaldo: " + this.getSaldo() +
                "\nCliente: " + this.getCliente().getNome() + " - " + this.getCliente().getCpf();
    }

    @Override
    public void sacar(BigDecimal valor) {
        try {
            if (valor.compareTo(this.getSaldo()) == 0) {
                throw new ContaException("Saldo insuficiente", CodigoErro.SALDO_INSUFICIENTE);
            }
            this.setSaldo(this.getSaldo().subtract(valor));
        } catch (ContaException exception) {
            System.out.println(exception);
        }
    }

    @Override
    public void extrato() {
        this.toString();
    }

    @Override
    public void depositor(BigDecimal valor) {
        this.setSaldo(this.getSaldo().add(valor));
    }

    @Override
    public void transferir(BigDecimal valor) {
        try {
            if (valor.compareTo(limiteTransferenciaDiaria) == 1) {
                throw new ContaException("Valor é superior ao seu limite de transferência",
                        CodigoErro.LIMITE_INSUFICIENTE_CC);
            }

            if (valor.compareTo(this.getSaldo()) == 1) {
                throw new ContaException("Saldo insuficiente", CodigoErro.SALDO_INSUFICIENTE);
            }

            this.setSaldo(this.getSaldo().subtract(valor));

        } catch (ContaException e) {
            System.out.println(e);
        }
    }
}
