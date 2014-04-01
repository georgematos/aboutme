package br.com.codecub.aboutme.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.codecub.aboutme.dao.UsuarioDao;
import br.com.codecub.aboutme.negocio.Criptografia;
import br.com.codecub.aboutme.negocio.Curriculo;
import br.com.codecub.aboutme.negocio.Usuario;
import br.com.codecub.aboutme.validation.BindResultToValidationMap;
import br.com.codecub.aboutme.validation.ValidationMap;

@Controller
public class AcessoController {
	
	@Qualifier("UsuarioLoginDaoJpa")
	private UsuarioDao usuarioDao;

	@Autowired // Coloca o Spring no controle do DAO
	public AcessoController(UsuarioDao uLoginDao) {
		this.usuarioDao = uLoginDao;
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastro() {
		return "acesso/cadastro";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "acesso/login";
	}
	
	// Remove os atributos da sessão quando o usuario deslogar */
	@RequestMapping(value = "j_spring_security_logout", method = RequestMethod.GET)
	public @ResponseBody void logout(HttpServletRequest request) {
		request.getSession().setAttribute("nome", "");
	}
	
	@RequestMapping(value = "/negado", method = RequestMethod.GET)
	public String negado() {
		return "acesso/negado";
	}
	
	@RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	public @ResponseBody String cadastrarUsuario(@Valid Usuario usuario, BindingResult result) throws JsonGenerationException, JsonMappingException, IOException {
		
		ValidationMap map = new ValidationMap();
		ObjectMapper mapper = new ObjectMapper();
		
		if(result.hasErrors()) {
		
			BindResultToValidationMap bindMap = new BindResultToValidationMap(result);
			map = bindMap.bind("status", "nome", "email", "senha"); // nomes dos campos dos objetos envolvidos
			
			return mapper.writeValueAsString(map.getMap());
				
		}
		
		try {
			// Seta permissão
			usuario.setAuthority("ROLE_USER"); /* ATENÇÃO! Esta linha de código é temporária */
			
			// Criptografa a senha
			String senhaCript = Criptografia.md5(usuario.getSenha());
			usuario.setSenha(senhaCript);
			
			// Cria o currículo do usuário.
			Curriculo aboutme = new Curriculo();
			
			// Vincula o curriculo a lista de curriculos do usuario.
			ArrayList<Curriculo> curriculos = new ArrayList<>();
			curriculos.add(aboutme);
			usuario.setCurriculo(curriculos);
			
			// Grava o novo usuário
			usuarioDao.adiciona(usuario);
			
		} catch (PersistenceException e) {
			map.add("confirmacao", "O usuário já existe");
			map.add("status", "erro");
			return mapper.writeValueAsString(map.getMap());
		}
		
		map.add("status", "ok");
		
		return mapper.writeValueAsString(map.getMap());
	}
	
}
