package com.test_tgid.project_tgid.entities;

public class Empresa {
	
    private String cnpj;
    private double saldo;

    public Empresa() {}

    public Empresa(String cnpj, double saldo) {
        this.cnpj = cnpj;
        this.saldo = saldo;
    }
    
    public Empresa(String cnpj) {
        this.cnpj = cnpj;
    }
    

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void receberInvestimento(Cliente cliente, double valor) throws Exception {
        cliente.investir(valor);  
        this.saldo += valor;      
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "CNPJ DA EMPRESA: " + getCnpj() + ", VALOR INVESTIDO PELO CLIENTE: R$" + String.format("%.2f", getSaldo());
    }
}
