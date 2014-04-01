package br.com.codecub.aboutme.validation;

import java.util.HashMap;

/**
 * Uma classe Java simples da qual uma instância irá receber as mensagens de erro do Spring 
 * e será convertida em um JSON para ser enviado para o client-side e será tratado via jQuery.
 */
public class ValidationMap {

	private HashMap<String, String> map;
	
	public ValidationMap() {
		map = new HashMap<String, String>();
	}

	public HashMap<String, String> getMap() {
		return map;
	}

	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
	public void add(String key, String value) {
		map.put(key, value);
	}

}
