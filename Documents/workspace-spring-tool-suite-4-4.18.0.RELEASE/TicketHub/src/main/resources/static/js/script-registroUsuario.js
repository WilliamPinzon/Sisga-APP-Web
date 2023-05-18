var alertBox = document.getElementById('alertBox');
alertBox.style.position = 'fixed';
alertBox.style.top = '20%';
alertBox.style.left = '94%';
alertBox.style.transform = 'translate(-50%, -50%)';
alertBox.style.backgroundColor = 'springgreen';
alertBox.style.borderRadius = '20px';
alertBox.style.boxShadow = '2px 2px 2px 2px rgba(0,0,0,0.25)';

function mostrarMensaje() {

alert("Esta aplicación Web fue desarrollada por estudiantes de la carrera de Ingeniería de Sistemas, " +
		"alumnos de la Universidad Central. \n\nSus contactos son los siguientes:\n" +
		"\nAnna María Sánchez Rojas: +57 3043343809" +
		"\nFredy Danilo Ussa Cristiano: +57 3003969161" +
		"\nDaniel Felipe Eraso Acero: +57 3133667782" +
		"\nWilliam Orlando Pinzón Castañeda: +57 3212062572" +
		"\n\nSi deseas dejar un número de teléfono, nos pondremos en contacto contigo lo antes posible.");
	prompt("Ingrese aquí la información de contacto");
}
















