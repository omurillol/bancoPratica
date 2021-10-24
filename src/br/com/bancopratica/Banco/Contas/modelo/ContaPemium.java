package br.com.bancopratica.Banco.Contas.modelo;

import br.com.bancopratica.Banco.Exceptions.modelo.SaldoInsuficienteException;
import br.com.bancopratica.Banco.Exceptions.modelo.SaldoMaiorNecessarioException;

public class ContaPemium extends Conta {
	
	public ContaPemium(int agencia, int numero, int saldoInicial) throws SaldoInsuficienteException {
		//A conta premium é para clientes mais ricos. Logo, requer um primeiro depósito
		//maior do que R$30.000;
		
		super(agencia, numero);
		// TODO Auto-generated constructor stub
		
		if(saldoInicial > 30000) {
			this.deposita(saldoInicial);
		}else{
				
			//criar uma exception aqui o quanto antes possível
			throw new SaldoInsuficienteException("O saldo é insuficiente");
		}
		
	}
	

	@Override
	public void deposita(double valor) throws SaldoInsuficienteException {
		if(valor>=500) {
		this.saldo = valor -(valor* 0.15);
		}else {
			throw new SaldoInsuficienteException("A conta é premium, "
					+ "valor mínimo de depósito: R$500,00");
		}
	}

	/*mexer no transfere depois. Conta premium necessita de um valor em questão
	 para transfere. Valor em mente: Pelo menos R$1.000,00*/
	@Override
	public void transfere(Conta contaDestino, double valor) {
		this.saca(valor);
		try {
			contaDestino.deposita(valor - (valor*0.20));
			}catch(Exception e) {
				System.out.println(e);
			}

	}

	@Override
	public void saca(double valor) {
		if(valor>=500) {
		this.saldo-=valor;
		}else {
			throw new SaldoMaiorNecessarioException("Impossível sacar saldo menor que R$500,00");
		}
	}

}
