package br.com.bancopratica.Banco.Arrays;

import java.util.ArrayList;

import br.com.bancopratica.Banco.Contas.modelo.*;
import br.com.bancopratica.Banco.Exceptions.modelo.SaldoInsuficienteException;

public class TesteArrayList {
	public static void main(String[] args) throws SaldoInsuficienteException {
		ArrayList<Conta> lista = new ArrayList<>();
		
		ContaCorrente cc1 = new ContaCorrente(111, 255);
		ContaCorrente cc2 = new ContaCorrente(122, 255);
		ContaCorrente cc3 = new ContaCorrente(133, 255);
		
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		
		
		lista.forEach((conta)->System.out.println( "Numero:" +conta.getNumero()));
		
	}
}
