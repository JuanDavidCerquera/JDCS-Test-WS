// localStorage en uso
// localStorage.setItem("numeroPasajeros", $("#pasajeros").val())
// localStorage.setItem("vueloRetorno", id)
// localStorage.setItem("vueloSalida", id)
// cabinatipe = localStorage.getItem("tipocabina")

function loadVueloSalida() {
    vueloSalida = localStorage.getItem("vueloSalida")
    console.log(vueloSalida);
    cabinatipe = localStorage.getItem("tipocabina")
    $.ajax({
        url: "http://localhost:9000/Session3/1v/api/countries/flight/" + vueloSalida,
        method: "GET",
        dataType: "json",
        success: function (response) {
            var data = response.data;
            console.log("Respuesta del servidor:", data);
            data.forEach(function (item) {
                $("#salida-origen").text(item.origen);
                $("#salida-destino").text(item.destino);
                $("#salida-cabina").text(cabinatipe);
                $("#salida-fecha").text(item.fecha);
                $("#salida-numvuel").text(item.numerovuelo);
            })
        }
    })
}

function loadVueloRetorno() {
    vueloSalida = localStorage.getItem("vueloRetorno")
    console.log(vueloSalida);
    cabinatipe = localStorage.getItem("tipocabina")
    $.ajax({
        url: "http://localhost:9000/Session3/1v/api/countries/flight/" + vueloSalida,
        method: "GET",
        dataType: "json",
        success: function (response) {
            var data = response.data;
            console.log("Respuesta del servidor:", data);
            data.forEach(function (item) {
                $("#retorno-origen").text(item.origen);
                $("#retorno-destino").text(item.destino);
                $("#retorno-cabina").text(cabinatipe);
                $("#retorno-fecha").text(item.fecha);
                $("#retorno-numvuel").text(item.numerovuelo);
            })
        }
    })
}
var listPasajeros = [];

function leerPasajeroInfo() {

    data = {
        nombre: $("#Nombres").val(),
        apellidos: $("#Apellidos").val(),
        fecha: $("#fecha").val(),
        numPassport: $("#numPassport").val(),
        telefono: $("#telefono").val(),
        origen: $("#origen").val(),
        passport: $("#Passport").val()
    }
    listPasajeros.push(data);
    console.log(listPasajeros);
    actualizartabla()
}
function actualizartabla() {
    html = "";
    listPasajeros.forEach(function (pasajero) {
        html +=
            `<tr>
            <td>` + pasajero.nombre + `</td>
            <td>` + pasajero.apellidos + `</td>
            <td>` + pasajero.fecha + `</td>
            <td>` + pasajero.numPassport + `</td>
            <td>` + pasajero.telefono + `</td>
            <td>` + pasajero.origen + `</td>
            <td>` + pasajero.passport + `</td>
            </tr>`
    });
    $("#pasajerotabla").html(html)

}

