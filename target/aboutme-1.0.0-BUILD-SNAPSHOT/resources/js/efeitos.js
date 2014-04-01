// Efeito dos botões das redes sociais
$('.img-front').mouseenter(function() {
	$(this).animate({opacity:'0'}, 100);
});
	
$('.img-front').mouseleave(function() {
	$(this).animate({opacity:'1'}, 100);
});

// Redimensiona o tamanho do elemento da classe content para ser exatamente do tamanho da tela vísivel
var alturaUsada = $(window).height() - 379;
console.log(alturaUsada);
$('.content').css({'min-height':alturaUsada});