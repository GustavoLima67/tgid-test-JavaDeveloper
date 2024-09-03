package com.test_tgid.project_tgid.execptions;

public class ExececaoEmpresa extends Exception {

	private static final long serialVersionUID = 1L;

    public ExececaoEmpresa() {
        super("Ocorreu um erro ao obter as informações da Empresa.");
    }

    public ExececaoEmpresa(String mensagem) {
        super(mensagem);
    }

    public ExececaoEmpresa(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ExececaoEmpresa(Throwable causa) {
        super(causa);
    }
}
