package com.test_tgid.project_tgid.execptions;

public class ExcecaoCliente extends Exception {

	private static final long serialVersionUID = 1L;

    public ExcecaoCliente() {
        super("Ocorreu um erro ao obter as informações do cliente.");
    }

    public ExcecaoCliente(String mensagem) {
        super(mensagem);
    }

    public ExcecaoCliente(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ExcecaoCliente(Throwable causa) {
        super(causa);
    }
}