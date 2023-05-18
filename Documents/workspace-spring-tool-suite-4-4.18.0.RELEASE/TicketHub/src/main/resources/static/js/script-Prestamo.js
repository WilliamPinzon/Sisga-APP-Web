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
							
   function buscarUsuario() {
    var cedula = document.getElementById("cedula").value;

    // Realizar una llamada AJAX al servidor para buscar el usuario por la cédula
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/buscarUsuario?cedula=" + cedula, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            // Obtener la respuesta del servidor en formato JSON
            var respuesta = JSON.parse(xhr.responseText);

            // Verificar si se encontró el usuario
            if (respuesta.encontrado) {
                // Obtener los datos del usuario
                var nombre = respuesta.nombre;
                var apellido = respuesta.apellido;
                var correo = respuesta.correo;
                var facultad = respuesta.facultad;

                // Asignar los valores a los campos del formulario
                document.getElementById("nombre").value = nombre;
                document.getElementById("apellido").value = apellido;
                document.getElementById("email").value = correo;
                document.getElementById("facultad").value = facultad;
            } else {
                // Si no se encontró el usuario, se pueden restablecer los valores de los campos
                document.getElementById("nombre").value = "";
                document.getElementById("apellido").value = "";
                document.getElementById("email").value = "";
                document.getElementById("facultad").value = "";
            }
        }
    };
    xhr.send();
}

// Escuchar el evento "input" en el campo de cédula
var cedulaInput = document.getElementById("cedula");
cedulaInput.addEventListener("input", buscarUsuario);

















