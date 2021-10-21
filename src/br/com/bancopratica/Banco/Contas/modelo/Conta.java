package br.com.bancopratica.Banco.Contas.modelo;

import br.com.bancopratica.Banco.Exceptions.modelo.SaldoInsuficienteException;

/***
 * Classe abstrata base de todas as contas
 * 
 * @author Murillo França
 * @version 0.1
 *
 */


public abstract class Conta {
	private int agencia;
	private int numero;
	private String titular; //implementar um cliente aqui depois
	protected double saldo;
	private static int total; //classe criada para ver a quantidade de contas no sistema
	
	//abaixo, o construtor
	public Conta(int agencia, int numero) throws SaldoInsuficienteException{
		total++;
		
		
		this.agencia = agencia;
		this.numero = numero;
	}
	
	
	
	public void setSaldo(double valor) {
		this.saldo+=valor;
	}
	
	public double getSaldo() {
		return this.saldo;
		
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public abstract void deposita(double saldo) throws SaldoInsuficienteException;
	
	public abstract void transfere(Conta conta, double valor);
	
	public abstract void saca(double valor);
	
	
	
	
	
	
}
