package br.com.codecub.aboutme.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.codecub.aboutme.dao.CursoLivreDao;
import br.com.codecub.aboutme.dao.FormacaoAcademicaDao;
import br.com.codecub.aboutme.dao.UsuarioDao;
import br.com.codecub.aboutme.negocio.CursoLivre;
import br.com.codecub.aboutme.negocio.FormacaoAcademica;
import br.com.codecub.aboutme.negocio.Usuario;

@Controller
public class AboutmeController {

	@Qualifier("UsuarioDaoJpa")
	private UsuarioDao usuarioDao;
	
	@Qualifier("FormacaoAcademicaDaoJpa")
	private FormacaoAcademicaDao formacaoAcademicaDao;
	
	@Qualifier("CursoLivreDaoJpa")
	private CursoLivreDao cursoLivreDao;

	@Autowired
	public AboutmeController(UsuarioDao usuarioDao, FormacaoAcademicaDao formacaoAcademicaDao, CursoLivreDao cursoLivreDao) {
		this.usuarioDao = usuarioDao;
		this.formacaoAcademicaDao = formacaoAcademicaDao;
		this.cursoLivreDao = cursoLivreDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() {
		return "home";
	}
	
	@RequestMapping(value = "/edicao-curriculo", method = RequestMethod.GET)
	public ModelAndView editarCurriculo() {
		
		ModelAndView mv = new ModelAndView("usuario/edicao-curriculo");
		
		// Pegando usuario logado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		// Pegando o email
		String email = auth.getName();

		// Pegando o usuário do BD pelo email
		Usuario usuario = usuarioDao.getByEmail(email);
		
		mv.addObject("usuario", usuario);
		
		return mv;
	}
	
	@RequestMapping(value = "/atualizarCurriculo", method = RequestMethod.POST)
	public String atualizarCurriculo(Usuario usuario, HttpServletRequest request) {

		Usuario persistedUser = usuarioDao.getByEmail(usuario.getEmail());
		
		persistedUser.setNome(usuario.getNome());
		persistedUser.setEmail(usuario.getEmail());
		persistedUser.setTelefone(usuario.getTelefone());
		persistedUser.setCelular(usuario.getCelular());
		persistedUser.getCurriculo().get(0).setObjProfissional(request.getParameter("objProfissional"));
		
		// Escopo das qualificações
		String qualificacoes = request.getParameter("qualificacoes");
			
		persistedUser.getCurriculo().get(0).setQualificacoes(qualificacoes);
			
		usuarioDao.altera(persistedUser);
			
		return "redirect:curriculo";
	}
	
	@RequestMapping(value = "/addFormacao", method = RequestMethod.POST)
	public @ResponseBody void addFormacao(@RequestParam("id") String id,
			@RequestParam("instituicao") String inst,
			@RequestParam("curso") String curso) {
		
		Usuario persistedUser = usuarioDao.getById(Long.parseLong(id));
		
		FormacaoAcademica formacao = new FormacaoAcademica();
		formacao.setInstituicao(inst);
		formacao.setCurso(curso);
		
		if (!(curso.equals("") && inst.equals(""))) {
			persistedUser.getCurriculo().get(0).getFormacaoAcademica().add(formacao);
		}
		
		usuarioDao.altera(persistedUser);
		
	}
	
	@RequestMapping(value = "/atualizarFormacao", method = RequestMethod.POST)
	public @ResponseBody void atualizarFormacao(
			@RequestParam("idFormacao") String idFormacao,
			@RequestParam("instituicao") String inst,
			@RequestParam("curso") String curso) {
		
		FormacaoAcademica f = formacaoAcademicaDao.getById(Long.parseLong(idFormacao));
		
		f.setInstituicao(inst);
		f.setCurso(curso);
		formacaoAcademicaDao.altera(f);
		
	}
	
	@RequestMapping(value = "/addCurso", method = RequestMethod.POST)
	public @ResponseBody void addCurso(@RequestParam("id") String id,
			@RequestParam("titulo") String titulo,
			@RequestParam("instituicao") String inst) {
		
		Usuario persistedUser = usuarioDao.getById(Long.parseLong(id));
		
		CursoLivre curso = new CursoLivre();
		curso.setTitulo(titulo);
		curso.setInstituicao(inst);
		
		if (!(titulo.equals("") && inst.equals(""))) {
			persistedUser.getCurriculo().get(0).getCursoLivre().add(curso);
		}
		
		usuarioDao.altera(persistedUser);
		
	}
	
	@RequestMapping(value = "/atualizarCurso", method = RequestMethod.POST)
	public @ResponseBody void atualizarCurso(
			@RequestParam("idCurso") String idCurso,
			@RequestParam("titulo") String titulo,
			@RequestParam("instituicao") String inst) {
		
		CursoLivre c = cursoLivreDao.getById(Long.parseLong(idCurso));
		
		c.setTitulo(titulo);
		c.setInstituicao(inst);
		cursoLivreDao.altera(c);
		
	}
	
	@RequestMapping(value = "/curriculoPublico", method = RequestMethod.GET)
	public ModelAndView curriculoById(@RequestParam("id") Long id, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView("usuario/curriculo-publico");
		
		Usuario usuario = usuarioDao.getById(id);
		
		request.getSession().setAttribute("nome", usuario.getNome());
		
		mv.addObject("usuario", usuario);
		
		return mv;
	}

	@RequestMapping(value = "/curriculo", method = RequestMethod.GET)
	public ModelAndView curriculo(HttpServletRequest request) {
		
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
		
		if (SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
			
			ModelAndView mv = new ModelAndView("acesso/login");
			return mv;
			
		} else {
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			// Pegando o email
			String email = auth.getName();
			
			// Pegando o usuário do BD pelo email
			Usuario usuario = usuarioDao.getByEmail(email);
					
			// Criando o atributo com o nome do usuario na sessão.
			request.getSession().setAttribute("nome", usuario.getNome());
			
			ModelAndView mv = new ModelAndView("usuario/curriculo-home");

			mv.addObject("usuario", usuario);

			return mv;
		}

	}
	
	@RequestMapping(value = "/excluirFormacao", method = RequestMethod.POST)
	public @ResponseBody void excluirFormacao(Long id) {
		FormacaoAcademica f = formacaoAcademicaDao.getById(id);
		formacaoAcademicaDao.remove(f.getId());
	}
	
	@RequestMapping(value = "/excluirCurso", method = RequestMethod.POST)
	public @ResponseBody void excluirCurso(Long id) {
		CursoLivre c = cursoLivreDao.getById(id);
		cursoLivreDao.remove(c.getId());
	}

}