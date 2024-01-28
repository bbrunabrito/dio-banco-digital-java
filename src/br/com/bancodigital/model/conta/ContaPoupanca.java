package br.com.bancodigital.model.conta;

import br.com.bancodigital.interfaces.ContaInterface;
import br.com.bancodigital.exception.CodigoErro;
import br.com.bancodigital.exception.ContaException;
import br.com.bancodigital.model.cartao.Cartao;
import br.com.bancodigital.model.pessoa.Cliente;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta implements ContaInterface {
    private BigDecimal taxaJuros;
    private BigDecimal jurosAcumulados;
    private Cartao cartao;

    public ContaPoupanca(String agencia, int numero, BigDecimal saldo, Cliente cliente,
                         BigDecimal taxaJuros, BigDecimal jurosAcumulados) {
        super(agencia, numero, saldo, cliente);
        this.taxaJuros = taxaJuros;
        this.jurosAcumulados = jurosAcumulados;
    }

    public BigDecimal getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(BigDecimal taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public BigDecimal getJurosAcumulados() {
        return jurosAcumulados;
    }

    public void setJurosAcumulados(BigDecimal jurosAcumulados) {
        this.jurosAcumulados = jurosAcumulados;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    @Override
    public String toString() {
        return "Tipo de Conta: Poupança\n" +
                "Agencia: " + this.getAgencia() +
                "\nNumero: " + this.getNumero() +
                "\nSaldo: " + this.getSaldo() +
                "\nCliente: " + this.getCliente().getNome() + " - " + this.getCliente().getCpf();
    }

    @Override
    public void sacar(BigDecimal valor) {
        try {
            if (valor.compareTo(this.getSaldo()) == 0) {
                throw new ContaException("Saldo Insuficiente", CodigoErro.SALDO_INSUFICIENTE);
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
            if (valor.compareTo(this.getSaldo()) == 1) {
                throw new ContaException("Saldo insuficiente", CodigoErro.SALDO_INSUFICIENTE);
            }
            this.setSaldo(this.getSaldo().subtract(valor));
        }
        catch (ContaException exception) {
            System.out.println(exception);
        }
    }
}
