package br.com.bancodigital.exception;

public class ContaException extends Exception {
    private String mensagem;
    private CodigoErro codigo;

    public ContaException(String mensagem, CodigoErro codigo){
        this.mensagem = mensagem;
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public CodigoErro getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Erro: "
                + mensagem + "\n" +
                ", codigo=" + codigo;
    }
}
