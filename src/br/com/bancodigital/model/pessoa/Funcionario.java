package br.com.bancodigital.model.pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends PessoaFisica {
    private String cod_funcionario;
    private BigDecimal salario;
    private LocalDate admissao;
    private boolean ativo;
    private String setor;

    public Funcionario(String nome, String cpf, int idade, LocalDate dataNascimento, String estadoCivil,
                       String cod_funcionario, BigDecimal salario, LocalDate admissao, boolean ativo,
                       String setor) {
        super(nome, cpf, idade, dataNascimento, estadoCivil);
        this.cod_funcionario = cod_funcionario;
        this.salario = salario;
        this.admissao = admissao;
        this.ativo = ativo;
        this.setor = setor;
    }

    public String getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(String cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getAdmissao() {
        return admissao;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "cod_funcionario='" + cod_funcionario + '\'' +
                ", salario=" + salario +
                ", admissao=" + admissao +
                ", ativo=" + ativo +
                ", setor='" + setor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(cod_funcionario, that.cod_funcionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cod_funcionario);
    }
}
