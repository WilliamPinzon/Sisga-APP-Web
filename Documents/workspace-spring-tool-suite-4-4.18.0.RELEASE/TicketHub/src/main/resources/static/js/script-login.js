

var alertBox = document.getElementById('alertBox');
alertBox.style.position = 'fixed';
alertBox.style.top = '15%';
alertBox.style.left = '94%';
alertBox.style.transform = 'translate(-50%, -50%)';
alertBox.style.backgroundColor = 'springgreen';
alertBox.style.borderRadius = '20px';
alertBox.style.boxShadow = '2px 2px 2px 2px rgba(0,0,0,0.25)';


$(document).ready(function() {
	$('.show-password').click(function() {
		var input = $(this).closest('.form-group').find('input');
		if (input.attr('type') == 'password') {
			input.attr('type', 'text');
			$(this).html('<i class="fas fa-eye-slash"></i> Ocultar');
		} else {
			input.attr('type', 'password');
			$(this).html('<i class="fas fa-eye"></i> Mostrar');
		}
	});

	$('.btn-login').mouseenter(function() {
		$(this).addClass('animate');
	}).mouseleave(function() {
		$(this).removeClass('animate');
	});
});