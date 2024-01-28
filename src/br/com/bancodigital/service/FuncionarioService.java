package br.com.bancodigital.service;

import br.com.bancodigital.exception.CodigoErro;
import br.com.bancodigital.exception.ContaException;
import br.com.bancodigital.model.pessoa.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {
    private static List<Funcionario> funcionariosList = new ArrayList<>();

    public static void registraFuncionario(Funcionario funcionario) {
        try {
            checaFuncionarioRegistro(funcionario);
            salvaFuncionarioRegistro(funcionario);
        } catch (ContaException e) {
            System.out.println(e);
        }
    }

    private static void salvaFuncionarioRegistro(Funcionario funcionario) {
        funcionariosList.add(funcionario);
    }

    private static void checaFuncionarioRegistro(Funcionario funcionario) throws ContaException {
        if (funcionariosList.contains(funcionario)) {
            throw new ContaException("Funcionario já registrado no sistema", CodigoErro.FUNCIONARIO_REGISTRADO);
        }
        if (funcionario.getCod_funcionario().length() != 5) {
            throw new ContaException("Código inválido", CodigoErro.FUNCIONARIO_COD_INVALIDO);
        }
        if (funcionario.getCpf().length() != 11 || !funcionario.getCpf().matches("[0-9]")){
            throw new ContaException("CPF inválido", CodigoErro.FUNCIONARIO_CPF_INVALIDO);
        }
    }
}
