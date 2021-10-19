package br.com.bancopratica.Banco.Contas.modelo;

public class ContaPemium extends Conta {
	
	public ContaPemium(int agencia, int numero, int saldoInicial) {
		//A conta premium é para clientes mais ricos. Logo, requer um primeiro depósito
		//maior do que R$300.000;
		
		super(agencia, numero);
		// TODO Auto-generated constructor stub
		
		if(saldoInicial > 3000000) {
			this.deposita(saldoInicial);
		}else {
			//criar uma exception aqui o quanto antes possível
			System.out.println("É necessário um valor maior ou igual a 300k para instanciar"
					+ "uma conta premium");
		}
	}
	

	@Override
	public void deposita(double valor) {
		this.saldo = valor -(valor* 0.15);

	}

	@Override
	public void transfere(Conta conta, double valor) {
		this.saca(valor);
		conta.deposita(valor - (valor*0.20));

	}

	@Override
	public void saca(double valor) {
		// TODO Auto-generated method stub

	}

}
