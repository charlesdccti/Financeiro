package com.algaworks.financeiro.util;

public class Cpf {

	public static void main(String[] args) {
		
		String cpf = "555.555.555-55";
		System.out.println(cpf);
		
		cpf = cpf.replace(".", "");
		System.out.println(cpf);
		
		cpf = cpf.replace("-", "");
		System.out.println(cpf);
		
		
	}
}
