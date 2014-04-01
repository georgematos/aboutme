package br.com.codecub.aboutme.validation;

import org.springframework.validation.BindingResult;

/**
 * Esta classe cria e retorna um objeto do tipo ValidationMap, que é um objeto que guarda as mensagens 
 * de erros de validação obtidas através da classe BindingResult do Spring Validation.
 * */
public class BindResultToValidationMap {
	
	// Cria variável do tipo ValidationMap
	private ValidationMap map;
	
	// Cria variável do tipo BindingResult
	private BindingResult result;

	/** Contrutor da classe recebe uma instância de BindingResult e a atribui à variável result e
	 * cria uma intância de ValidationMap e a atribui à variável map
	 * 
	 * @param result
	 */
	public BindResultToValidationMap(BindingResult result) {
		this.result = result;
		map = new ValidationMap();
	}
	
	/**
	 * O método bind recebe como argumento uma lista variável de Strings que representam os campos que devem
	 * do objeto que devem ser validados. O nome do campo será a chave do mapa e a mensagem de erro retornada
	 * pelo método getFieldError(<campo>).getDefaultMessage() do objeto result será seu valor. Para realizar
	 * essa tarefa, um laço for foi uma solução escolhida.
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