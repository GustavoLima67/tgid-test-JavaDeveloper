package com.test_tgid.project_tgid.execptions;

public class InformacoesAdicionais extends Exception{
	private static final long serialVersionUID = 1L;
	
	public InformacoesAdicionais() {
        super("Ocorreu um erro ao obter informações adicionais.");
    }

    public InformacoesAdicionais(String mensagem) {
        super(mensagem);
    }

    public InformacoesAdicionais(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public InformacoesAdicionais(Throwable causa) {
        super(causa);
    }

}
