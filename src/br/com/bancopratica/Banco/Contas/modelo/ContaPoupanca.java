package br.com.bancopratica.Banco.Contas.modelo;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		//!! Conta Poupan�a - Dep�sito com taxa de 10%.
		if(valor>=1) {
		super.saldo+=(valor - (valor*0.1));
		}else{
		System.out.println("N�o � poss�vel depositar valor menores que R$1.");
		//implementar excemption aqui o quanto antes poss�vel
		}
	}

	@Override
	public void transfere(Conta contaDestino, double valor) {
		this.saca(valor);
		contaDestino.deposita(valor);
		

	}

	@Override
	public void saca(double valor) {
		// Conta Poupan�a - Imposto de 5% no saque.
		this.saldo -= (valor-(valor*0.5));

	}

}
