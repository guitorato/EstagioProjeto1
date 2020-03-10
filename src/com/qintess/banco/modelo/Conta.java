package com.qintess.banco.modelo;

import java.text.DecimalFormat;

public class Conta {
	
	private int agencia;
	private int numero;
	private double saldo;
	private Cliente cliente;
	private double limite;
	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double saldoLimite) {
		
		this.limite = saldoLimite;
	}
	
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Conta(int agencia, int numero, double saldo, Cliente cliente) {
		super();
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
		limite = 300;
	}
	
	public void deposita(double valor) {
		if (limite == 300) {
			saldo+=valor;
			System.out.println("Valor do dep�sito: "+ valor);
			System.out.println("DEP�SITO REALIZADO COM SUCESSO\n");
			
		}else if (saldo == 0 && limite < 300 && limite >= 0) {
			if (valor-limite > 300) {
				saldo = valor + limite - 300;
				limite = 300;
				System.out.println("Valor do dep�sito: "+ valor);
				System.out.println("DEP�SITO REALIZAD0 COM SUCESSO\n");
				
			}else if (valor-limite < 300 && limite+2 < valor) {
				saldo = valor + limite;
				saldo -= 300;
				limite = 300;
				System.out.println("Valor do dep�sito: "+ valor);
				System.out.println("DEP�SITO REALIZADO COM SUCESSO\n");
				
			}else if (valor-limite < 300 && limite+2 >= valor) {
				valor-=limite;
				saldo=0;
				limite=300;
				System.out.println("Valor do dep�sito: "+ valor);
				System.out.println("DEP�SITO REALIZADO COM SUCESSO\n");
				
			}
		}
		 
	}
	
	
	
	public void verificarSaldo () {
		System.out.println("---------------- INFORMA��ES DO CLIENTE ----------------");
		System.out.println("Cliente: "+cliente.getNome()+"\nConta: "+ this.getNumero());
		System.out.println("O saldo em conta � R$ "+ this.formatarDecimal(saldo));
		System.out.println("Seu limite de cheque especial � de R$ "+ limite);
		System.out.println("-------------------------------------------------------");
	}
	
	public void saque (double valorSaque) {
		
		if (saldo >= valorSaque) {
			saldo -=valorSaque;
			saldo -=0.3;
			System.out.println("Valor do saque:"+ valorSaque);
			System.out.println("TRANSA��O REALIZADA COM SUCESSO");
			
		}else if (saldo+limite >= valorSaque) {
			saldo-=valorSaque;
			saldo+=limite;
			saldo -= 2.3;
			limite = saldo;
			saldo = 0;
			System.out.println("Valor do saque:"+ valorSaque);
			System.out.println("TRANSA��O REALIZADA COM SUCESSO\n");
			
		}else if (saldo+limite < valorSaque) {
			System.out.println("Vo�� n�o possui saldo para saque no momento \n");
		}
	}
	public void transferencia(Conta conta , double valor) {
		
		if(this.getSaldo() < valor) {
		  
			if(this.getSaldo()+this.getLimite() <= valor ) {
				System.out.println("[TRANSFERENCIA INVALIDA] Saldo insuficiente para opera��o \n");
		 
			}else if(this.getSaldo()+ this.getLimite() > valor) {
				
				
				this.setSaldo(this.getSaldo() - valor - 6.0);
				this.setLimite(this.getLimite() + this.getSaldo());
				this.setSaldo(0);
				conta.setSaldo(conta.getSaldo()+valor);
				System.out.println("Valor da Transfer�ncia: "+ valor);
				System.out.println("TRANSFER�NCIA REALIZADA COM SUCESSO\n");
				}
			}else if(this.getSaldo() == valor){
				
				this.setSaldo(this.getSaldo() - valor);
				this.setLimite(this.getLimite() - 6);
				conta.setSaldo(conta.getSaldo()+valor);
				System.out.println("Valor da Transfer�ncia: "+ valor);
				System.out.println("TRANSFER�NCIA REALIZADA COM SUCESSO\n");
		}else{
			
			this.setSaldo(this.getSaldo() - valor + 4);
			conta.setSaldo(conta.getSaldo()+valor);
			System.out.println("Valor da Transfer�ncia: "+ valor);
			System.out.println("TRANSFER�NCIA REALIZADA COM SUCESSO\n");
	}
	}
	public String formatarDecimal (double numero){
	
		DecimalFormat df = new DecimalFormat ("#0.00");
		return df.format(numero);
	}
}
