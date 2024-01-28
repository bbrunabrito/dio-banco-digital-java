package br.com.bancodigital.service;

import br.com.bancodigital.exception.CodigoErro;
import br.com.bancodigital.exception.ContaException;
import br.com.bancodigital.model.cartao.Cartao;
import br.com.bancodigital.model.conta.Conta;
import br.com.bancodigital.model.conta.ContaCorrente;
import br.com.bancodigital.model.conta.ContaPoupanca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContaService {
    private static List<ContaPoupanca> contaPoupancaList = new ArrayList<>();
    private static List<ContaCorrente> contaCorrentesList = new ArrayList<>();
    private static List<Cartao> cartaoList = new ArrayList<>();


    public static void registraCartaoContaCorrente(ContaCorrente corrente) {
        try {
            gerarCartaoContaCorrente(corrente);
            checaSeCartaoExiste(corrente);
            cartaoList.add(corrente.getCartao());
        }
        catch (ContaException e) {
            System.out.println(e);
        }
    }

    private static void gerarCartaoContaCorrente(ContaCorrente corrente) {
        Random random = new Random();
        StringBuilder numero = new StringBuilder();
        StringBuilder codSec = new StringBuilder();

        for(int i = 0; i < 16; i++) {
            numero.append(String.valueOf(random.nextInt(0, 10)));
        }
        for(int i = 0; i < 3; i++) {
            codSec.append(String.valueOf(random.nextInt(0, 10)));
        }

        Cartao cartaoCC = new Cartao(String.valueOf(numero), corrente.getCliente().getNome(), corrente,
                "Débito/Crédito", String.valueOf(codSec), LocalDate.now().plusYears(10));

        corrente.setCartao(cartaoCC);
    }

    private static void checaSeCartaoExiste(ContaCorrente contaCC) throws ContaException {
        if(cartaoList.contains(contaCC.getCartao())) {
            throw new ContaException("Cartão gerado possui informações de outro cartão", CodigoErro.ERRO_GERACAO_CARTAO);
        }
    }
}
