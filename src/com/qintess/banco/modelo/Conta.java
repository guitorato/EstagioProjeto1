package com.qintess.banco.modelo;

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
			
		}else if (saldo == 0 && limite < 300 && limite >= 0) {
			if (valor-limite > 300) {
				saldo = valor + limite - 302;
				limite = 300;
				
			}else if (valor-limite < 300 && limite+2 < valor) {
				saldo = valor + limite;
				saldo -= 300;
				saldo-=2;
				limite = 300;
			}else if (valor-limite < 300 && limite+2 >= valor) {
				valor-=limite;
				saldo=0;
				limite=300;
				limite-=2;
			}
		}
		 
	}
	
	
	
	public void verificarSalvo () {
		
		System.out.println("Cliente: "+cliente.getNome()+"\n E-mail: "+cliente.getEmail());
		System.out.println("O saldo em conta é R$ "+ saldo);
		System.out.println("Seu limite de cheque especial é de R$ "+ limite+"\n\n");
	}
	
	public void saque (double valorSaque) {
		
		if (saldo >= valorSaque) {
			saldo -=valorSaque;
			saldo -=0.3;
			
		}else if (saldo+limite >= valorSaque) {
			saldo-=valorSaque;
			saldo+=limite;
			saldo -= 0.3;
			limite = saldo;
			saldo = 0;
			
		}else if (saldo+limite < valorSaque) {
			System.out.println("Voçê não possui saldo para saque no momento \n");
		}
	}
	public void transferencia(Conta conta , double valor) {
		
		if(this.getSaldo() < valor) {
		  
			if(this.getSaldo()+this.getLimite() <= valor ) {
				System.out.println("[TRANSFERENCIA INVALIDA] Salvo insuficiente para operação \n");
		 
			}else if(this.getSaldo()+ this.getLimite() > valor) {
				
				
				this.setSaldo(this.getSaldo() - valor);
				this.setLimite(this.getLimite() + this.getSaldo());
				this.setSaldo(0);
				conta.setSaldo(conta.getSaldo()+valor);
			
				}
			}else {
				
				this.setSaldo(this.getSaldo() - valor);
				conta.setSaldo(conta.getSaldo()+valor);
		}
	}
}
