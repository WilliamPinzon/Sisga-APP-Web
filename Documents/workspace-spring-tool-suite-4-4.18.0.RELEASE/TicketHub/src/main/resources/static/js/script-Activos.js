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

function mostrarOcultar() {
	var x = document.getElementById("imgAdmin");
	var y = document.querySelector(".segundaria");
	if (x.style.display === "none") {
		x.style.display = "block";
		y.classList.remove("ancha-izquierda");
	} else {
		x.style.display = "none";
		y.classList.add("ancha-izquierda");
	}
}

// Obtenemos el formulario de eliminación de usuario por su id
const eliminarUsuarioForm = document.getElementById('eliminar-usuarioExterno-form');

// Agregamos un event listener para el evento "submit"
eliminarUsuarioForm.addEventListener('submit', (event) => {
	// Prevenimos el comportamiento por defecto de enviar el formulario
	event.preventDefault();

	// Mostramos una alerta de confirmación para asegurarnos de que el usuario desea eliminar al usuario
	if (confirm('¿Está seguro de que desea eliminar este Gestor? Esta acción no se puede deshacer.')) {
		// Si el usuario confirma, enviamos el formulario
		eliminarUsuarioForm.submit();
	}
});

function buscarUsuario() {
  var input = document.getElementById("buscarInput");
  var filter = input.value.toUpperCase();
  var tabla = document.getElementsByTagName("table")[0];
  var filas = tabla.getElementsByTagName("tr");

  for (var i = 0; i < filas.length; i++) {
    var celda = filas[i].getElementsByTagName("td")[0];
    if (celda) {
      var textoCelda = celda.textContent || celda.innerText;
      if (textoCelda.toUpperCase().indexOf(filter) > -1) {
        filas[i].style.display = "";
      } else {
        filas[i].style.display = "none";
      }
    }       
  }
}


