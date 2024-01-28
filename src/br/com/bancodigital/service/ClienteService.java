package br.com.bancodigital.service;

import br.com.bancodigital.exception.CodigoErro;
import br.com.bancodigital.exception.ContaException;
import br.com.bancodigital.model.pessoa.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private static List<Cliente> clientesRegistrados = new ArrayList<Cliente>();

    public static void registraCliente(Cliente cliente) {
        try {
            checaSeClienteRegistrado(cliente);
            salvaCliente(cliente);
        } catch (ContaException e) {
            System.out.println(e);
        }
    }

    private static void salvaCliente(Cliente cliente) {
        cliente.setAtivo(true);
        cliente.setDiaInscricao(LocalDate.now());
        clientesRegistrados.add(cliente);
    }


    private static void checaSeClienteRegistrado(Cliente cliente) throws ContaException {
        if(clientesRegistrados.contains(cliente)) {
            throw new ContaException("Cliente ja cadastrado no sistema", CodigoErro.CLIENTE_REGISTRADO);
        }

        if(cliente.getCpf().length() != 11 || !cliente.getCpf().matches("[0-9]")) {
            throw new ContaException("CPF inválido", CodigoErro.CLIENTE_CPF_INVALIDO);
        }
    }
}
