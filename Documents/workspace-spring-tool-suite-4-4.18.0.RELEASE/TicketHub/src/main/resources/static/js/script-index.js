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

// Obtener la altura de la tabla y el footer
const wrapper = document.querySelector('.wrapper');
const table = wrapper.querySelector('table');
const footer = document.querySelector('footer');
const tableHeight = table.offsetHeight;
const footerHeight = footer.offsetHeight;

// Ajustar la posición del footer en consecuencia
function adjustFooterPosition() {
  const wrapperHeight = wrapper.offsetHeight;
  const tableScrollHeight = table.scrollHeight;
  const tableBottomPosition = tableHeight + table.offsetTop;
  const footerTopPosition = wrapperHeight + wrapper.offsetTop - footerHeight;

  if (tableScrollHeight > tableHeight) {
    if (tableBottomPosition < footerTopPosition) {
      footer.style.top = footerTopPosition + 'px';
    } else {
      footer.style.top = tableBottomPosition + 'px';
    }
  } else {
    footer.style.top = wrapperHeight + wrapper.offsetTop - footerHeight + 'px';
  }
}

// Ejecutar la función cuando se cargue la página y cuando se redimensione la ventana
window.addEventListener('load', adjustFooterPosition);
window.addEventListener('resize', adjustFooterPosition);

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
