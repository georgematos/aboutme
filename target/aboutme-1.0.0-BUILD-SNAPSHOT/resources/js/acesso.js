// Envio do formulário com Ajax e JSON
function cadastrar() {
	$('#mensagem').find('li').remove();
	
	var email = $('#email').val();
	var senha = $('#senha').val();
	var confirmacao = $('#confirmacao').val();

	if (senha != confirmacao) {
		$('#mensagem').append("<li>As senhas não correspodem</li>");
		$('#div-msgs').animate({opacity:"1"}, 500).css({"background-color":"rgba(240, 20, 20, 0.50"});
	} else {
		$.post("cadastrarUsuario",
			{	
				email: email,
				senha: senha
			},
			
			function(data) {
				var obj = $.parseJSON(data); // Converte uma String JSON em um objeto JavaScript.
				if (obj.status == "erro") {
					// itera sobre os atributos do objeto
					$.each(obj, function(key, value){
						if(key == "confirmacao") {
							$('#mensagem').append("<li>" + value + "</li>");
						}
						if(value != null && key != "status" && key != "confirmacao") {
							$('#mensagem').append("<li>" + "O campo " + key + " " + value + "</li>");
						}
					});
					$('#div-msgs').animate({opacity:"1"}, 500).css({"background-color":"rgba(240, 20, 20, 0.50"});
				} else {
					window.location.href="login";
				}	
			
			});
	}
}

function logar() {
$('#mensagem').find('li').remove();

	$.post("j_spring_security_check",
		{	
			login: $('#login').val(),
			senha: $('#senha').val(),
		},
		
		function(data) {
			var obj = $.parseJSON(data); // Converte uma String JSON em um objeto JavaScript.
			if (obj.status == "erro") {
				// itera sobre os atributos do objeto
				$.each(obj, function(key, value){
					if(value != null && key != "status" && key != "confirmacao") {
						$('#mensagem').append("<li>" + "O campo " + key + " " + value + "</li>");
					}
				});
				$('#div-msgs').animate({opacity:"1"}, 500).css({"background-color":"rgba(240, 20, 20, 0.50"});
			} else {
				window.location.href="curriculo";
			}	
		
		});
}