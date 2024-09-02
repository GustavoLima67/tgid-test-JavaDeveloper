package com.test_tgid.project_tgid;

import java.util.Locale;
import java.util.Scanner;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test_tgid.project_tgid.entities.Company;

import com.test_tgid.project_tgid.notication.CallbackSender;

import com.test_tgid.project_tgid.notication.EmailNotification;
import com.test_tgid.project_tgid.entities.Client;
import com.test_tgid.project_tgid.validators.ValidatorCnpj;
import com.test_tgid.project_tgid.validators.ValidatorCpf;


@SpringBootApplication
public class ProjectTgidApplication {

	public static Scanner sc = new Scanner(System.in);
	public static Company comp = new Company();
	public static Client client = new Client();
	
	public static void main(String[] args) {
		
		
		obterInformacoesCliente();
			
		obterInformacoesEmpresa();
		
		obterInformacoesExtras();
		
		finalizandoPrograma();
	}
	
	public static void setUsLocale() {
		Locale.setDefault(Locale.US);
	}
	
	public static void obterInformacoesCliente() {
		try {
			
			setUsLocale();
			obterCpfValid();
			
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao obter as informações do cliente: " + e.getMessage());
			e.printStackTrace();
		}

	}
	
	public static void obterCpfValid() {
		setUsLocale();
		
		try {
			System.out.print("CPF do Cliente: ");
			String cpf = sc.next();
			
			if(!ValidatorCpf.isCpf(cpf)) {
				System.out.println("O cpf informado não é valido!");
				System.exit(0);
			}
			
			System.out.print("Primeiro deposito do Cliente: ");
			double deposity = sc.nextDouble();
			
			client = new Client(cpf);
			
			comp.addDeposity(deposity);
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao obter as informações do cliente: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	public static void obterInformacoesEmpresa() {
		
		try {
			setUsLocale();
			obterCnpjEmpresa();
			
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao obter as informaçõs da empresa: " + e.getMessage());
			e.printStackTrace();
		}
		
	
	}
	
	public static void obterCnpjEmpresa() {
		
		try {
			System.out.print("CNPJ da Empresa: ");
			String cnpj = sc.next();
			
			if(!ValidatorCnpj.isCnpj(cnpj)) {
				System.out.println("O Cnpj informado não é válido!");
				System.exit(0);
			}
			
			System.out.print("Esse é o seu primeiro investimento na Empresa? (y/n): ");
			char response = sc.next().charAt(0);
			
			if (response == 'y') {
				System.out.println();
				System.out.print("Entre com o valor investido incial: ");
				double initialSaldo = sc.nextDouble();
				comp = new Company(cnpj, initialSaldo);
				
				enviandoNotificacaoEmpresa();
				
			} 
			
		} catch (Exception e) {
				System.err.println("Ocorreu um erro ao obter as informaçõs da empresa: " + e.getMessage());
				e.printStackTrace();
			}
	}
	
	public static void finalizandoPrograma() {
		try {
			System.out.println();
			System.out.print("Gostaria de investir novamente na Empresa? (y/n): ");
			char response = sc.next().charAt(0);
			
			if (response == 'y') {
				System.out.println();
				System.out.print("Entre com o valor investido desejado: ");
				double saldo = sc.nextDouble();
				comp = new Company(saldo);
				
				enviandoNotificacaoEmpresa();
			}
			
			if (response == 'n') {
				System.out.println("Obrigrado por Investir!!");
				System.exit(0);
			}
			
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao obter as informaçõs da empresa: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	public static void obterInformacoesExtras() {
		
		try {
			obterInformCliente();
			obterInformEmpresa();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao obter as informações extras: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void obterInformCliente() {
		System.out.println();
		System.out.println("Informações do Cliente: ");
		System.out.println(client);
	}
	
	public static void obterInformEmpresa() {
		System.out.println();
		System.out.println("Informações da Empresa: ");
		System.out.println(comp);
		
	}
	
	public static void enviandoNotificacaoEmpresa() {
		 String webhookUrl = "https://webhook.site/8dbf5fe7-eb4a-44c6-92c3-b6980b85af4f"; 
	        String jsonPayload = "{ \"transaction\": \"completed\", \"status\": \"success\" }";
	        
	        System.out.print("Entre com seu email: (funcional) ");
	        String emailDestinatirio = sc.next();
	        
	        String emailTo = emailDestinatirio; 
	        String emailSubject = "Notificação de Transação";
	        String emailBody = "Sua transação foi concluída com sucesso.";

	        try {
	           
	            CallbackSender.enviarCallback(webhookUrl, jsonPayload);
	            EmailNotification.enviarEmail(emailTo, emailSubject, emailBody);
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
