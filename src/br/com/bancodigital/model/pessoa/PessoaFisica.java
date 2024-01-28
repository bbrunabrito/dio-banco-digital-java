package br.com.bancodigital.model.pessoa;

import java.time.LocalDate;
import java.util.Objects;

public class PessoaFisica {
    private String nome;
    private String cpf;
    private int idade;
    private LocalDate dataNascimento;
    private String estadoCivil;

    //Constructor
    public PessoaFisica(String nome, String cpf, int idade, LocalDate dataNascimento, String estadoCivil) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
        this.estadoCivil = estadoCivil;
    }


    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                ", dataNascimento=" + dataNascimento +
                ", estadoCivil='" + estadoCivil + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaFisica pessoaFisica = (PessoaFisica) o;
        return Objects.equals(cpf, pessoaFisica.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
