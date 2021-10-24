package br.com.bancopratica.Banco.Contas.modelo;
import br.com.bancopratica.Banco.Exceptions.modelo.*;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(int agencia, int numero) throws SaldoInsuficienteException{
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) throws SaldoInsuficienteException {
		//!! Conta Poupança - Depósito com taxa de 10%.
		if(valor>=1) {
		this.saldo+=(valor - (valor*0.1));
		}else{
			throw new SaldoInsuficienteException("O saldo é insuficiente");
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

	@Override
	public void saca(double valor) {
		// Conta Poupança - Imposto de 5% no saque.
		this.saldo -= (valor-(valor*0.5));

	}

}
