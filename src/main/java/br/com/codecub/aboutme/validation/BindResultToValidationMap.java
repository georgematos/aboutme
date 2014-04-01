package br.com.codecub.aboutme.validation;

import org.springframework.validation.BindingResult;

/**
 * Esta classe cria e retorna um objeto do tipo ValidationMap, que � um objeto que guarda as mensagens 
 * de erros de valida��o obtidas atrav�s da classe BindingResult do Spring Validation.
 * */
public class BindResultToValidationMap {
	
	// Cria vari�vel do tipo ValidationMap
	private ValidationMap map;
	
	// Cria vari�vel do tipo BindingResult
	private BindingResult result;

	/** Contrutor da classe recebe uma inst�ncia de BindingResult e a atribui � vari�vel result e
	 * cria uma int�ncia de ValidationMap e a atribui � vari�vel map
	 * 
	 * @param result
	 */
	public BindResultToValidationMap(BindingResult result) {
		this.result = result;
		map = new ValidationMap();
	}
	
	/**
	 * O m�todo bind recebe como argumento uma lista vari�vel de Strings que representam os campos que devem
	 * do objeto que devem ser validados. O nome do campo ser� a chave do mapa e a mensagem de erro retornada
	 * pelo m�todo getFieldError(<campo>).getDefaultMessage() do objeto result ser� seu valor. Para realizar
	 * essa tarefa, um la�o for foi uma solu��o escolhida.
	 * @param fields
	 * @return
	 */
	public ValidationMap bind(String... fields) {
		map.add(fields[0], "erro");
		for (int i = 1; i < fields.length; i++) {
			if(result.getFieldError(fields[i]) != null) {
				map.add(fields[i], result.getFieldError(fields[i]).getDefaultMessage());
			}
		}
		return map;
	}
	
}