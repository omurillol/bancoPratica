package br.com.bancopratica.Banco.Contas.modelo;

import br.com.bancopratica.Banco.Exceptions.modelo.*;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(int numero, int agencia) throws SaldoInsuficienteException {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		//!! Conta corrente - Depósito sem taxas.
		if(valor>=1) {
		super.saldo+=valor;
		}else{
		System.out.println("Não é possível depositar valor menores que R$1."); //implementar excemption aqui o quanto antes possível
		}
		
	}
	
	@Override
	public void saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo-=valor;
		}else {
			// ***!IMPLEMENTAR UMA EXCEPTION AQUI O QUANTO ANTES POSSÍVEL
			System.out.println("Saldo insuficiente");
		}

	}
	
	@Override
	public void transfere(Conta contaDestino, double valor) {
		this.saca(valor);
		try {
			contaDestino.deposita(valor);
			}catch(Exception e) {
				System.out.println(e);
			}
	}

	

}
