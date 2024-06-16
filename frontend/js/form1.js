function loadData() {
    var checkbox = document.getElementById('vsalida');
    if (checkbox.checked) {
        var fechaSalida = new Date($("#fecha-salida").val());
        var fechamenos3 = new Date(fechaSalida)
        var fechamas3 = new Date(fechaSalida)
        fechamenos3.setDate(fechamenos3.getDate() - 3)
        fechamas3.setDate(fechamas3.getDate() + 3)
        data = {
            "origen": $("#origen").val(),
            "destino": $("#destino").val(),
            "salida": fechamenos3,
            "llegada": fechamas3
        }
    } else {
        data = {
            "origen": $("#origen").val(),
            "destino": $("#destino").val(),
            "salida": $("#fecha-salida").val(),
            "llegada": $("#fecha-salida").val()
        }

    }

    var jsondata = JSON.stringify(data)
    eleccioncabina = $("#tipo-cabina").val();
    console.log(eleccioncabina);

    if (eleccioncabina === "business") {
        $.ajax({
            url: "http://localhost:9000/Session3/1v/api/countries/flight/filter",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: jsondata,
            success: function (response) {
                console.log(response.data);
                var html = "";
                var data = response.data;
                data.forEach(function (item) {
                    html +=
                        `<tr>
                        <td>` + item.origen + `</td>
                        <td>` + item.destino + `</td>
                        <td>` + item.fecha + `</td>
                        <td>` + item.hora + `</td>
                        <td>` + item.numerovuelo + `</td>
                        <td>` + parseInt(item.preciocabina * 1.30) + `</td>
                        <td><button  class="ButtonEditar buttonLista" onclick="iditemSalida(${item.id})">Seleccionar</td>
                        </tr>`;
                });
                loadData2();
                $("#tabla1").html(html);
            }
        })
    } else if (eleccioncabina === "primeraclase") {
        $.ajax({
            url: "http://localhost:9000/Session3/1v/api/countries/flight/filter",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: jsondata,
            success: function (response) {
                console.log(response.data);
                var html = "";
                var data = response.data;
                data.forEach(function (item) {
                    html +=
                        `<tr>
                        <td>` + item.origen + `</td>
                        <td>` + item.destino + `</td>
                        <td>` + item.fecha + `</td>
                        <td>` + item.hora + `</td>
                        <td>` + item.numerovuelo + `</td>
                        <td>` + parseInt((item.preciocabina * 1.35) * 1.30) + `</td>
                        <td><button  class="ButtonEditar buttonLista" onclick="iditemSalida(${item.id})">Seleccionar</td>
                        </tr>`;
                });
                loadData2();
                $("#tabla1").html(html);
            }
        })
    } else {
        $.ajax({
            url: "http://localhost:9000/Session3/1v/api/countries/flight/filter",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: jsondata,
            success: function (response) {
                console.log(response.data);
                var html = "";
                var data = response.data;
                data.forEach(function (item) {
                    html +=
                        `<tr>
                        <td>` + item.origen + `</td>
                        <td>` + item.destino + `</td>
                        <td>` + item.fecha + `</td>
                        <td>` + item.hora + `</td>
                        <td>` + item.numerovuelo + `</td>
                        <td>` + item.preciocabina + `</td>
                        <td><button  class="ButtonEditar buttonLista" onclick="iditemSalida(${item.id})">Seleccionar</td>
                        </tr>`;
                });
                loadData2();
                $("#tabla1").html(html);
            }
        })
    }



}

function iditemSalida(id) {
    console.log(id)
    localStorage.setItem("vueloSalida", id)
}

function loadData2() {
    var checkbox = document.getElementById('vretorno');
    if (checkbox.checked) {
        var fechaSalida = new Date($("#fecha-regreso").val());
        var fechamenos3 = new Date(fechaSalida)
        var fechamas3 = new Date(fechaSalida)
        fechamenos3.setDate(fechamenos3.getDate() - 3)
        fechamas3.setDate(fechamas3.getDate() + 3)
        data = {
            "origen": $("#destino").val(),
            "destino": $("#origen").val(),
            "salida": fechamenos3,
            "llegada": fechamas3
        }
    } else {
        data = {
            "origen": $("#destino").val(),
            "destino": $("#origen").val(),
            "salida": $("#fecha-regreso").val(),
            "llegada": $("#fecha-regreso").val()
        }
    }
    var jsondata = JSON.stringify(data)
    eleccioncabina = $("#tipo-cabina").val();
    console.log(eleccioncabina);
    if (eleccioncabina === "primeraclase") {

        $.ajax({
            url: "http://localhost:9000/Session3/1v/api/countries/flight/filter",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: jsondata,
            success: function (response) {
                console.log(response.data);
                var html = "";
                var data = response.data;
                data.forEach(function (item) {
                    html +=
                        `<tr>
                        <td>` + item.origen + `</td>
                        <td>` + item.destino + `</td>
                        <td>` + item.fecha + `</td>
                        <td>` + item.hora + `</td>
                        <td>` + item.numerovuelo + `</td>
                        <td>` + parseInt((item.preciocabina * 1.35) * 1.30) + `</td>
                        <td><button  class="ButtonEditar buttonLista" onclick="iditemRetorno(${item.id})">Seleccionar</td>
                        </tr>`;
                });
                $("#tabla2").html(html);
            }
        })
    } else if (eleccioncabina === "business") {

        $.ajax({
            url: "http://localhost:9000/Session3/1v/api/countries/flight/filter",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: jsondata,
            success: function (response) {
                console.log(response.data);
                var html = "";
                var data = response.data;
                data.forEach(function (item) {
                    html +=
                        `<tr>
                        <td>` + item.origen + `</td>
                        <td>` + item.destino + `</td>
                        <td>` + item.fecha + `</td>
                        <td>` + item.hora + `</td>
                        <td>` + item.numerovuelo + `</td>
                        <td>` + parseInt(item.preciocabina * 1.30) + `</td>
                        <td><button  class="ButtonEditar buttonLista" onclick="iditemRetorno(${item.id})">Seleccionar</td>
                        </tr>`;
                });
                $("#tabla2").html(html);
            }
        })
    } else {

        $.ajax({
            url: "http://localhost:9000/Session3/1v/api/countries/flight/filter",
            method: "POST",
            dataType: "json",
            contentType: "application/json",
            data: jsondata,
            success: function (response) {
                console.log(response.data);
                var html = "";
                var data = response.data;
                data.forEach(function (item) {
                    html +=
                        `<tr>
                        <td>` + item.origen + `</td>
                        <td>` + item.destino + `</td>
                        <td>` + item.fecha + `</td>
                        <td>` + item.hora + `</td>
                        <td>` + item.numerovuelo + `</td>
                        <td>` + item.preciocabina + `</td>
                        <td><button  class="ButtonEditar buttonLista" onclick="iditemRetorno(${item.id})">Seleccionar</td>
                        </tr>`;
                });
                $("#tabla2").html(html);
            }
        })
    }



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
    window.location.href = "form2.html";
}



// localStorage en definicion
// localStorage.setItem("numeroPasajeros", $("#pasajeros").val())
// localStorage.setItem("vueloRetorno", id)
// localStorage.setItem("vueloSalida", id)