
var origenId = ""
var destinoId = ""

// crea el cuerpo con el que filtra
function filterTable(origen, destino, checkbox, fechaBase) {
    if (checkbox.checked) {
        var fechamenos3 = new Date(fechaBase)
        var fechamas3 = new Date(fechaBase)
        fechamenos3.setDate(fechamenos3.getDate() - 3)
        fechamas3.setDate(fechamas3.getDate() + 3)
        var data = {
            "origen": origen,
            "destino": destino,
            "salida": fechamenos3,
            "llegada": fechamas3
        }
    } else {
        var data = {
            "origen": origen,
            "destino": destino,
            "salida": $("#fecha-salida").val(),
            "llegada": $("#fecha-salida").val()
        }
    }
    const jsondata = JSON.stringify(data)
    return jsondata
}

// realiza la consulta
function loadData(origen, destino, checkbox, fechaBase) {
    return new Promise((resolve, reject) => {
        var jsondata = filterTable(origen, destino, checkbox, fechaBase)
        var eleccioncabina = $("#tipo-cabina").val();
        var sobreCargo = 1
        if (eleccioncabina === "business") {
            sobreCargo = 1.30
        } else if (eleccioncabina === "primeraclase") {
            sobreCargo = 1.755
        }

        $.ajax({
            url: "http://localhost:9000/Session3/1v/api/countries/flight/filter/Optional",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: jsondata,
            success: function (response) {
                console.log(response.data);
                var Html = "";
                var data = response.data;
                data.forEach(function (item) {
                    Html +=
                        `<tr>
                        <td>` + item.origen + `</td>
                        <td>` + item.destino + `</td>
                        <td>` + item.fecha + `</td>
                        <td>` + item.hora + `</td>
                        <td>` + item.numerovuelo + `</td>
                        <td>` + item.preciocabina * sobreCargo + `</td>
                        <td><button  class="ButtonEditar buttonLista" onclick="iditemSalida(${item.id})">Seleccionar</td>
                        </tr>`;
                });
                resolve(Html)
            }
        })
    })
}

// llama los metodos para cargar data
function callLoadData() {
    if ($("#origen").val() == "") {
        origenId = ""
    }
    if ($("#destino").val() == "") {
        destinoId = ""
    }
    const checkboxOrigen = document.getElementById('vsalida');
    const checkboxDestino = document.getElementById('vretorno');
    const fechaOrigen = new Date($("#fecha-salida").val())
    const fechaDestino = new Date($("#fecha-regreso").val())

    loadData(origenId, destinoId, checkboxOrigen, fechaOrigen).then((tabla1) => {
        $("#tabla1").html(tabla1);
    })

    var selectedTripType = document.querySelector('input[name="trip-type"]:checked').value;

    if (selectedTripType === 'retorno') {
        loadData(destinoId, origenId, checkboxDestino, fechaDestino).then((tabla2) => {
            $("#tabla2").html(tabla2);
        })
    }
}

// guarda el dato del registro seleccionado
function iditemSalida(id) {
    console.log(id)
    localStorage.setItem("vueloSalida", id)
}


function iditemRetorno(id) {
    console.log(id)
    localStorage.setItem("vueloRetorno", id)
}

function ruta() {
    var selectedTripType = document.querySelector('input[name="trip-type"]:checked').value;
    var container = document.getElementById("container-tabla2");
    var buscador = document.getElementById("buscador-tabla2");

    if (selectedTripType === 'retorno') {
        console.log("Seleccionado: Retorno");
        container.style.display = "block";
        buscador.style.display = "block";
    } else if (selectedTripType === 'solo-ida') {
        console.log("Seleccionado: Solo ida");
        container.style.display = "none";
        buscador.style.display = "none";
        localStorage.setItem("vueloRetorno", null)
    }
}

function cambioVista() {
    eleccioncabina = $("#tipo-cabina").val();
    console.log(eleccioncabina);
    localStorage.setItem("tipocabina", eleccioncabina)
    localStorage.setItem("numeroPasajeros", $("#pasajeros").val())
    console.log(localStorage.getItem("numeroPasajeros"))
    if (localStorage.getItem("vueloSalida") == "null") {
        console.log(localStorage.getItem("vueloSalida"))
        alert("Es necesario seleccionar un vuelo de salida");
    } else if (localStorage.getItem("vueloRetorno") == "null") {
        alert("No selecciono un vuelo de retorno");
        window.location.href = "form2.html";
    } else {
        window.location.href = "form2.html";
    }
}

function loadAirport() {
    $.ajax({
        url: "http://localhost:9000/Session3/1v/api/airports",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log(response.data);
            var html = "";
            var data = response.data;
            data.forEach(function (item) {
                html +=
                    `<option value=${item.id}>${item.name}</option>`
            });
            $("#origen").html(html);
            $("#destino").html(html);
        }
    })
}

function refresacarData() {
    localStorage.setItem("numeroPasajeros", null)
    localStorage.setItem("vueloRetorno", null)
    localStorage.setItem("vueloSalida", null)
}

function autoComplete() {

    $.ajax({
        url: "http://localhost:9000/Session3/1v/api/airports",
        method: "GET",
        dataType: "json",
        success: function (response) {
            var data = response.data
            var autocompletar = []

            data.forEach(function (item) {
                autocompletar.push({ label: item.name, value: item.id });
            });
            // funcionaba pero no me gusto
            // autocompletar.push({ label: "cualquiera", value: null });


            $("#origen").autocomplete({
                source: autocompletar,
                select: function (event, ui) {
                    $(this).val(ui.item.label)
                    origenId = ui.item.value
                    return false;
                }
            })
            $("#destino").autocomplete({
                source: autocompletar,
                select: function (event, ui) {
                    $(this).val(ui.item.label)
                    destinoId = ui.item.value
                    return false;
                }
            })
        }
    })
}

// localStorage en definicion
// localStorage.setItem("numeroPasajeros", $("#pasajeros").val())
// localStorage.setItem("vueloRetorno", id)
// localStorage.setItem("vueloSalida", id)