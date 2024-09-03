package com.test_tgid.project_tgid;

import java.util.Locale;
import java.util.Scanner;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test_tgid.project_tgid.entities.Empresa;
import com.test_tgid.project_tgid.execptions.ExcecaoCliente;
import com.test_tgid.project_tgid.execptions.ExececaoEmpresa;
import com.test_tgid.project_tgid.execptions.InformacoesAdicionais;
import com.test_tgid.project_tgid.notication.CallbackSender;

import com.test_tgid.project_tgid.notication.EmailNotification;
import com.test_tgid.project_tgid.entities.Cliente;
import com.test_tgid.project_tgid.validators.ValidatorCnpj;
import com.test_tgid.project_tgid.validators.ValidatorCpf;


@SpringBootApplication
public class ProjectTgidApplication {

	public static Scanner sc = new Scanner(System.in);
	public static Empresa comp = new Empresa();
	public static Cliente client = new Cliente();
	
	public static void main(String[] args) {
		
		try {
			setUsLocale();
			obterInformacoesCliente();
				
			obterInformacoesEmpresa();
			
			obterInformacoesExtras();
			
			finalizandoPrograma();
		} catch (Exception e){
			System.err.println("Erro na execução!" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void setUsLocale() {
		Locale.setDefault(Locale.US);
	}
	
	public static void obterInformacoesCliente() throws ExcecaoCliente {
		try {
			
			setUsLocale();
			obterCpfValido();
			
		} catch (Exception e) {
			throw new ExcecaoCliente("Corrija suas credencias corretamente.", e);
		}

	}
	
	public static void obterCpfValido() throws ExcecaoCliente {
		setUsLocale();
		
		try {
			System.out.print("CPF do Cliente: ");
			String cpf = sc.next();
			
			if(!ValidatorCpf.isCpf(cpf)) {
				throw new ExcecaoCliente("O CPF informado não é válido.");
			}
			
			enviandoNotificacaoEmpresa();
			
			System.out.print("Saldo do Cliente: ");
			double deposity = sc.nextDouble();
			
			client = new Cliente(cpf, deposity);		
			
		} catch (Exception e) {
			 throw new ExcecaoCliente("Erro ao obter CPF válido.", e);
		}
		
	}
	
	
	public static void obterInformacoesEmpresa() throws ExececaoEmpresa{
		
		try {
			setUsLocale();
			obterCnpjEmpresa();
			
		} catch (Exception e) {
			throw new ExececaoEmpresa("Erro ao obter informações da empresa, corrija suas credenciais.", e);
		}
		
	
	}
	
	public static void obterCnpjEmpresa() throws ExececaoEmpresa {
		
		try {
			System.out.print("CNPJ da Empresa: ");
			String cnpj = sc.next();
			
			if(!ValidatorCnpj.isCnpj(cnpj)) {
				throw new ExcecaoCliente("O CNPJ informado não é válido.");
			}
			
			if (comp == null) {
                comp = new Empresa(cnpj);
            }
			
			System.out.print("Esse é o seu primeiro investimento na Empresa? (y/n): ");
			char response = sc.next().charAt(0);
			
			
			if (response == 'y') {
				
				System.out.println();
				System.out.print("Entre com o valor investido incial: ");
				double initialSaldo = sc.nextDouble();
	            try {
	                comp.receberInvestimento(client, initialSaldo);
	            } catch (Exception e) {
	                System.out.println(e.getMessage());
	            }
	            
	            comp = new Empresa(cnpj, initialSaldo);

			} 
			
			
		} catch (Exception e) {
			throw new ExececaoEmpresa("Erro ao obter CNPJ da empresa.", e);
		}
	}
	
	public static void finalizandoPrograma() throws ExececaoEmpresa{
		try {
            System.out.print("Gostaria de investir novamente na Empresa? (y/n): ");
            char response = sc.next().charAt(0);

            if (response == 'y') {
                System.out.print("Entre com o valor investido desejado: ");
                double valorInvestido = sc.nextDouble();
                
                try {
                    comp.receberInvestimento(client, valorInvestido);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                obterInformCliente();
                obterInformEmpresa();
                
            } else if (response == 'n') {
                System.out.println("Obrigado por investir!");
            }
        } catch (Exception e) {
            throw new ExececaoEmpresa("Erro ao investir novamente na empresa.", e);
        }
	}
	
	public static void obterInformacoesExtras() throws InformacoesAdicionais{
		
		try {
			obterInformCliente();
			obterInformEmpresa();
		} catch (Exception e) {
			throw new InformacoesAdicionais("Erro ao obter as informações adicionais.", e);
		}
	}
	
	public static void obterInformCliente() {
		System.out.println();
		System.out.println("Informações do Cliente: ");
		System.out.println(client.toString());
	}
	
	public static void obterInformEmpresa() {
		System.out.println();
		System.out.println("Informações da Empresa: ");
		System.out.println(comp.toString());
		
	}
	
	public static void enviandoNotificacaoEmpresa() {
		 
			String webhookUrl = "https://webhook.site/8dbf5fe7-eb4a-44c6-92c3-b6980b85af4f"; 
	        String jsonPayload = "{ \"transaction\": \"completed\", \"status\": \"success\" }";
	        
	        System.out.print("Entre com seu email: (funcional) ");
	        String emailDestinatario = sc.next();
	        
	        String emailTo = emailDestinatario; 
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
