package com.test_tgid.project_tgid.entities;


public class Company {
	
	Client client;
	
	private String cnpj;
	private double saldo;
	
	public Company() {
	}
	
	public Company(String cnpj, double saldo) {
		super();
		this.cnpj = cnpj;
		addDeposity(saldo);
	}
	
	public Company(double saldo) {
		super();
		this.saldo = saldo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public double getSaldo() {
		return saldo;
	}


	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public double addDeposity(double balance) {
		return this.saldo += balance + 03 / 100 ;
	}
	
	public String toString() {
		return "CNPJ DA EMPRESA: " 
				+ getCnpj() 
				+ ", VALOR INVESTIDO PELO CLIENTE: R$" 
				+ String.format("%.2f", getSaldo());
	}
	
	
	
}
