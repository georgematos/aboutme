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
	var conf = confirm("Tem certeza que deseja excluir essa mensagem?");
	if (conf == true) {
		var id = $("#td-id").text();
		$.post("excluirMsg?id="+id);
		$('#registro').remove();
	}
});