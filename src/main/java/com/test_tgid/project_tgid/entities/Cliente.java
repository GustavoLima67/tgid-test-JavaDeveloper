package com.test_tgid.project_tgid.entities;

public class Cliente {
    private String cpf;
    private double saldo;
    
    public Cliente() {
    }

    public Cliente(String cpf, double saldoInicial) {
        this.cpf = cpf;
        this.saldo = saldoInicial;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double quantia) {
        if (quantia > 0) {
            saldo += quantia;
        }
    }

    public void investir(double valorInvestido) throws Exception {
        if (valorInvestido > saldo) {
            throw new Exception("Saldo insuficiente para investimento.");
        } else {
            saldo -= valorInvestido;
        }
    }

    @Override
    public String toString() {
        return "CPF DO CLIENTE: " + getCpf() + ", SALDO DO CLIENTE: R$" + String.format("%.2f", getSaldo());
    }
}
