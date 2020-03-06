package com.qintess.banco.executa;

import com.qintess.banco.modelo.Conta;
import com.qintess.banco.modelo.Cliente;

public class ExecutaConta {
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("João","guitorato@gmail.com","123456","324.567.234-34","34.144.028-5");
		Conta conta1 = new Conta (12345,1234567,1000,cliente1);
		
		Cliente cliente2 = new Cliente("Pedro","pedro@gmail.com","1234567","324.567.234-34","34.144.028-5");
		Conta conta2 = new Conta (1245,453454,1000,cliente2);
		
		
		conta1.verificarSalvo();
		
		//conta1.saque(1100);
		//conta1.verificarSalvo();
		
		conta1.deposita(200.00);
		conta1.verificarSalvo();
		
		conta2.verificarSalvo();
		//conta.deposita(100.00);
		//conta.verificarSalvo();
		//conta.saque(100.00);
		//conta.verificarSalvo();
		conta1.transferencia(conta2,1500);
		conta2.verificarSalvo();
		conta1.verificarSalvo();
	
		
		
		
	}
	

}
