package com.qintess.banco.executa;

import com.qintess.banco.modelo.Conta;

import java.util.Scanner;

import com.qintess.banco.modelo.Cliente;


public class ExecutaConta {
	
	public static Cliente cliente1 = new Cliente("João","guitorato@gmail.com","gui123","324.567.234-34","34.144.028-5");
	public static Conta conta1 = new Conta (123,12341,1000,cliente1);
	
	public static Cliente cliente2 = new Cliente("Pedro","pedro@gmail.com","1234567","324.567.234-34","34.144.028-5");
	public static Conta conta2 = new Conta (124,123,1000,cliente2);
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MenuBanco();
		
		
	}
	public static void MenuBanco() {
		int op = 0;
		
		double valor;
		int verificadorAgencia ,verificadorConta;
		String verificadorSenha;
		
		System.out.println("Digite o número de senha: ");
		verificadorSenha = sc.nextLine();
		
		
		
		if (verificadorSenha.equals(cliente1.getSenha())) {
			System.out.println("-------------- BEM VINDO "+cliente1.getNome()+"--------------");
			
			
			while(op != 5) {
				
				System.out.println("Informe qual a opção desejada: ");
				System.out.println("1 - EXTRATO ");
				System.out.println("2 - SACAR");
				System.out.println("3 - DEPOSITO ");
				System.out.println("4 - TRANSFERENCIA ");
				System.out.println("5 - SAIR ");
				op = sc.nextInt();
				
				if (op == 1) {
					conta1.verificarSaldo();
					
				}else if (op == 2) {
					System.out.println("Digite o valor para saque:");
					valor = sc.nextDouble();
					conta1.saque(valor);
				}else if (op == 3) {
					System.out.println("Digite o valor para Deposito: ");
					valor = sc.nextDouble();
					conta1.deposita(valor);
				}else if (op == 4) {
					System.out.println("Digite agencia do favorecido para Transferencia: ");
					verificadorAgencia = sc.nextInt();
					System.out.println("Digite a conta do favorecido para Transferencia: ");
					verificadorConta = sc.nextInt();
					
					if (verificadorAgencia == conta2.getAgencia() && verificadorConta == conta2.getNumero()) {
						System.out.println("NOME DO FAVORECIDO: "+cliente2.getNome());
						System.out.println("Digite o valor da Transferencia");
						valor = sc.nextDouble();
						conta1.transferencia(conta2,valor);
						
					}else {
						System.out.println("Conta ou Agencia inválida");
					}
					
				} if (op == 5) {
					System.out.println("SESSÃO ENCERRADA ...");
				}else if(op > 5) {
					System.out.println("OPÇÃO INVÁLIDA");
				}
			}//FINAL WhilE
		}else {
			System.out.println("\nSENHA INVÁLIDA");
			System.out.println("SESSÃO ENCERRADA ...");
		}
		
	}
}
