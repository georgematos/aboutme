package br.com.codecub.aboutme.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.codecub.aboutme.dao.MensagemDao;
import br.com.codecub.aboutme.dao.UsuarioDao;
import br.com.codecub.aboutme.negocio.Mensagem;
import br.com.codecub.aboutme.negocio.Usuario;
import br.com.codecub.aboutme.validation.BindResultToValidationMap;
import br.com.codecub.aboutme.validation.ValidationMap;

@Controller
public class MensagensController {
	
	@Qualifier("MensagemDaoJpa")
	private MensagemDao msgDao;
	
	@Qualifier("UsuarioDaoJpa")
	private UsuarioDao usuarioDao;

	@Autowired // Coloca o Spring no controle do DAO
	public MensagensController(MensagemDao msgDao, UsuarioDao usuarioDao) {
		this.msgDao = msgDao;
		this.usuarioDao = usuarioDao;
	}
	
	@RequestMapping(value = "/enviarMensagem", method = RequestMethod.POST)
	/**
	 * @RequestParam("user_id") String id, captura um parametro passado na requisição
	 * que nesse caso é passado pelo jQuery. 
	 */
	public @ResponseBody String salvarMensagem(@Valid Mensagem msg, BindingResult result, @RequestParam("user_id") String text_id) throws JsonGenerationException, JsonMappingException, IOException {
		
		/* Cria uma instancia de ValidationMap, que contém um HashMap para armazenar os campos 
		 * correspondentes aos formularios e suas respectivas mensagens de erro */
		ValidationMap map = new ValidationMap();
		
		// Componente do Jackson para converter um objeto para o formato JSON
		ObjectMapper mapper = new ObjectMapper();
		
		if(result.hasErrors()) {
			BindResultToValidationMap bindMap = new BindResultToValidationMap(result);
			map = bindMap.bind("status", "remetente", "email", "mensagem");
			
			/* Converte e retorna o objeto como uma String em formato JSON, observe que o método getMap 
			 * retorna um objeto do tipo HashMap e é esse objeto que será convertido */
			return mapper.writeValueAsString(map.getMap());
		}
		
		// Setando a data do envio
		Calendar cal = Calendar.getInstance();
		Date data = cal.getTime();
		msg.setData(data);
				
		// Pegando o destinatário da mensagem pelo ID
		Long id = Long.parseLong(text_id); // converte o parametro que é uma string em um objeto do tipo Long.
		Usuario usuario = usuarioDao.getById(id);
		
		// Entregando mensagem ao usuario
		usuario.getMensagens().add(msg);
		
		// Atualizando usuario
		usuarioDao.altera(usuario);
		
		// Adicionado o atributo de status
		map.add("status", "ok");
		
		// Retornando o JSON com as mensagens (AJAX)
		return mapper.writeValueAsString(map.getMap());
	}
	
	@RequestMapping(value = "/mensagens", method = RequestMethod.GET)
	public ModelAndView getMensagens() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String userEmail = auth.getName();
		
		Usuario usuario = usuarioDao.getByEmail(userEmail);
		
		ArrayList<Mensagem> lista = (ArrayList<Mensagem>) msgDao.lista(usuario.getId());
		
		ModelAndView mv = new ModelAndView("usuario/caixa-de-mensagens");
		
		mv.addObject("listaMensagens", lista);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/excluirMsg", method = RequestMethod.POST)
	public @ResponseBody void excluir(Long id) {
		msgDao.remove(id);
	}
	
}
