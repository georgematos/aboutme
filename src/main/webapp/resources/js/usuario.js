/*	Enviar Mensagem
 *  Envio do formulário com Ajax e JSON */
function enviar() {
	$('#mensagem').find('li').remove();
	
	$(function() {
		$.post("enviarMensagem",
			{	
				user_id: $('#user_id').val(),
				remetente: $('#remetente').val(),
				email: $('#email').val(),
				mensagem: $('#msg').val()
			},
			
			function(data) {
				var obj = $.parseJSON(data); // Converte uma String JSON em um objeto JavaScript.
				if (obj.status == "ok") {
					$('#mensagem').append("<li>Obrigado por enviar sua mensagem!</li>").css({'font-size':"medium"}); // Exibe msg de sucesso
					$('#div-msgs').animate({opacity:"1"}, 1000).css({"background-color":"rgba(19, 238, 41, 0.50"}); // Exibe a div de mensagens
					$('#div-msgs').animate({opacity:"0"}, 6000);
					// Limpa o formulário
					$('#remetente').val("");
					$('#email').val("");
					$('#msg').val("");
				} else {
					// itera sobre os atributos do objeto
					$.each(obj, function(key, value){
						if(value != null && key != "status") {
							$('#mensagem').append("<li>" + "O campo " + key + " " + value + "</li>");
						}
					});
					$('#div-msgs').animate({opacity:"1"}, 500).css({"background-color":"rgba(240, 20, 20, 0.50"});
				};
			
			});
	});
}

/* Excluir mensagens */
$('.link-excluir-msg').click(function(event){
	event.preventDefault();
	var self = $(this);
	var conf = confirm("Tem certeza que deseja excluir essa mensagem?");
	if (conf == true) {
		// Pega o elemento tr mais próximo e procuro dentro dele o elemento da classe td-id pegando seu texto.
		var id = self.closest("tr").find(".td-id").text(); 
		$.post("excluirMsg?id="+id);
		self.closest("tr").remove();
	}
});

/* Excluir Formacao */
$('.link-excluir-formacao').click(function(event){
	event.preventDefault();
	var self = $(this);
	var conf = confirm("Tem certeza que deseja excluir essa formação?");
	if (conf == true) {
		var id = self.closest("tr").find(".id-formacao").text();
		$.post("excluirFormacao?id="+id);
		self.closest("tr").remove();
	}
});

/* Excluir Curso */
$('.link-excluir-curso').click(function(event){
	event.preventDefault();
	var self = $(this);
	var conf = confirm("Tem certeza que deseja excluir esse curso?");
	if (conf == true) {
		var id = self.closest("tr").find(".id-curso").text();
		$.post("excluirCurso?id="+id);
		self.closest("tr").remove();
	}
});

/* Adicionar Formacao */
$('.link-add-formacao').click(function(event) {
		
		event.preventDefault();
		
		var id = $('#usuario-id').val();
		var instituicao = $('#formacao-instituicao').val();
		var curso = $('#formacao-curso').val();
		
		if(instituicao != "" && curso != "") {
			$.post("addFormacao",
					{	
						id: id,
						instituicao: instituicao,
						curso: curso,
					},
					function() {
						window.location.reload("edicao-curriculo");
					});
		} else {
			alert("Informe os dados corretamente!");
		}
		
	}
);

/* Atualizar Formacao */
$('.link-atualizar-formacao').click(function(event) {
		
		event.preventDefault();
		
		var self = $(this);
		var idFormacao = self.closest("tr").find(".id-formacao").text();
		var instituicao = self.closest("tr").find('.formacao-instituicao-up').val();
		var curso = self.closest("tr").find('.formacao-curso-up').val();
		
		if(instituicao != "" && curso != "") {
			$.post("atualizarFormacao",
					{	
						idFormacao: idFormacao,
						instituicao: instituicao,
						curso: curso,
					},
					function() {
//						window.location.reload("edicao-curriculo");
						self.closest("tr").find(".td-background").animate({opacity:"0"}, 150);
						self.closest("tr").find(".td-background").animate({opacity:"1"}, 150).css({"background-color":"rgba(20, 20, 240, 0.30)"});
					});
		} else {
			alert("Informe os dados corretamente!");
		}
		
	}
);

/* Adicionar Curso */
$('.link-add-curso').click(function(event) {
		
		event.preventDefault();
		
		var id = $('#usuario-id').val();
		var titulo = $('#curso-titulo').val();
		var instituicao = $('#curso-instituicao').val();
		
		if(titulo != "" && instituicao != "") {
			$.post("addCurso",
					{	
						id: id,
						titulo: titulo,
						instituicao: instituicao,
					},
					function() {
						window.location.reload("edicao-curriculo");
					});
		} else {
			alert("Informe os dados corretamente!");
		}
		
	}
);

/* Atualizar Curso */
$('.link-atualizar-curso').click(function(event) {
		
		event.preventDefault();
		
		var self = $(this);
		var idCurso = self.closest("tr").find(".id-curso").text();
		var titulo = self.closest("tr").find('.curso-titulo-up').val();
		var instituicao = self.closest("tr").find('.curso-instituicao-up').val();
		
		if(titulo != "" && instituicao != "") {
			$.post("atualizarCurso",
					{	
						idCurso: idCurso,
						titulo: titulo,
						instituicao: instituicao,
					},
					function() {
//						window.location.reload("edicao-curriculo");
						self.closest("tr").find(".td-background").animate({opacity:"0"}, 150);
						self.closest("tr").find(".td-background").animate({opacity:"1"}, 150).css({"background-color":"rgba(20, 20, 240, 0.30)"});
					});
		} else {
			alert("Informe os dados corretamente!");
		}
		
	}
);