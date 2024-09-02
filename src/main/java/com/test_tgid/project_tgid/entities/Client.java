package com.test_tgid.project_tgid.entities;



public class Client {
	Company comp;
	
	private String cpf;
	private double deposity;
	
	public Client() {
	}
	
	public Client(double deposity) {
		super();
		this.deposity = deposity;
	}

	
	public Client(String cpf, double deposity) {
		super();
		this.cpf = cpf;
		comp.addDeposity(deposity);
	}

	public Client(String cpf) {
		super();
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Company getCompany() {
		return comp;
	}

	public double getDeposity() {
		return deposity;
	}
	
	public String toString() {
		return "CPF DO CLIENTE: " + getCpf() + ", SALDO DO CLIENTE: R$" + String.format("%.2f", getDeposity());
	
	}

}
	

