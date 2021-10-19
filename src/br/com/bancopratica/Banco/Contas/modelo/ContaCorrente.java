package br.com.bancopratica.Banco.Contas.modelo;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(int numero, int agencia) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		//!! Conta corrente - Dep�sito sem taxas.
		if(valor>=1) {
		super.saldo+=valor;
		}else{
		System.out.println("N�o � poss�vel depositar valor menores que R$1."); //implementar excemption aqui o quanto antes poss�vel
		}
		
	}
	
	@Override
	public void saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo-=valor;
		}else {
			// ***!IMPLEMENTAR UMA EXCEPTION AQUI O QUANTO ANTES POSS�VEL
			System.out.println("Saldo insuficiente");
		}

	}
	
	@Override
	public void transfere(Conta contaDestino, double valor) {
		this.saca(valor);
		contaDestino.deposita(valor);
	}

	

}
