package br.com.codecub.aboutme.testes;

import br.com.codecub.aboutme.negocio.Criptografia;

public class CriarSenhasCriptografadas {
	
	public static void main(String[] args) {
		System.out.println(Criptografia.md5("_da&geo_"));
	}

}
