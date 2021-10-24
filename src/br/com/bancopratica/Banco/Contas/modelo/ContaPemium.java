package br.com.bancopratica.Banco.Contas.modelo;

import br.com.bancopratica.Banco.Exceptions.modelo.SaldoInsuficienteException;
import br.com.bancopratica.Banco.Exceptions.modelo.SaldoMaiorNecessarioException;

public class ContaPemium extends Conta {
	
	public ContaPemium(int agencia, int numero, int saldoInicial) throws SaldoInsuficienteException {
		//A conta premium � para clientes mais ricos. Logo, requer um primeiro dep�sito
		//maior do que R$30.000;
		
		super(agencia, numero);
		// TODO Auto-generated constructor stub
		
		if(saldoInicial > 30000) {
			this.deposita(saldoInicial);
		}else{
				
			//criar uma exception aqui o quanto antes poss�vel
			throw new SaldoInsuficienteException("O saldo � insuficiente");
		}
		
	}
	

	@Override
	public void deposita(double valor) throws SaldoInsuficienteException {
		if(valor>=500) {
		this.saldo = valor -(valor* 0.15);
		}else {
			throw new SaldoInsuficienteException("A conta � premium, "
					+ "valor m�nimo de dep�sito: R$500,00");
		}
	}

	/*mexer no transfere depois. Conta premium necessita de um valor em quest�o
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
			throw new SaldoMaiorNecessarioException("Imposs�vel sacar saldo menor que R$500,00");
		}
	}

}
