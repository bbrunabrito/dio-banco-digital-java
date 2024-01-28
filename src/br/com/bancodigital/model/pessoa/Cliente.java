package br.com.bancodigital.model.pessoa;

import java.time.LocalDate;

public class Cliente extends PessoaFisica {
    private boolean ativo;
    private LocalDate diaInscricao;

    public Cliente(String nome, String cpf, int idade, LocalDate dataNascimento, String estadoCivil) {
        super(nome, cpf, idade, dataNascimento, estadoCivil);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDiaInscricao() {
        return diaInscricao;
    }

    public void setDiaInscricao(LocalDate diaInscricao) {
        this.diaInscricao = diaInscricao;
    }
}
