
localStorage.removeItem("SetAsideOrg");
localStorage.removeItem("SetAsideDes");
localStorage.removeItem("numPasajeros");
localStorage.removeItem("SetAsideOrgCheck");
localStorage.removeItem("SetAsideDesCheck");
var origen = $("#origen").val() || ""
var destino = $("#destino").val() || ""
var tipocabina = $("#tipo-cabina").val() || ""
var trayectoria = document.querySelector('input[name="trayectoria"]:checked').value || ""
var fechaSalida = $("#fecha-salida").val() || ""
var fechaRegreso = $("#fecha-regreso").val() || ""
var numAsientos = $("#numAsientos").val() || ""
var checkOrg = document.getElementById('vsalida').checked || ""
var checkDes = document.getElementById('vretorno').checked || ""
var pasajero = document.getElementById("pasajeros")
pasajero.min = 0
var pajmaxOrg = 0
var pajmaxDes = 0
var rowCheckOrg
var rowCheckDes


//leer datos del frontend
function Leer() {
    origen = $("#origen").val()
    destino = $("#destino").val()
    tipocabina = $("#tipo-cabina").val()
    trayectoria = document.querySelector('input[name="trayectoria"]:checked').value;
    fechaSalida = $("#fecha-salida").val()
    fechaRegreso = $("#fecha-regreso").val()
    numAsientos = $("#numAsientos").val()
    checkOrg = document.getElementById('vsalida').checked;
    checkDes = document.getElementById('vretorno').checked;
}

// crea el cuerpo con el que filtra
function FilterTable(origen, destino, checkbox, fechaBase, numAsientos) {
    if (checkbox) {
        var fechamenos3 = new Date(fechaBase)
        var fechamas3 = new Date(fechaBase)
        fechamenos3.setDate(fechamenos3.getDate() - 3)
        fechamas3.setDate(fechamas3.getDate() + 3)
        var data = {
            "id": null,
            "origen": origen,
            "destino": destino,
            "fechaSalida": fechamenos3,
            "fechaLlegada": fechamas3,
            "tipocabina": tipocabina,
            "seatdis": numAsientos
        }
    } else {
        var data = {
            "id": 0,
            "origen": origen,
            "destino": destino,
            "fechaSalida": fechaBase,
            "fechaLlegada": "",
            "tipocabina": tipocabina,
            "seatdis": numAsientos
        }
    }
    return data
}

// crea el cuerpo en la tabla correspondiente
function DataTable(table, data) {
    var html = "";
    if (table === "tabla1") {
        data.forEach(function (item) {
            html +=
                `<tr>
                    <td>` + item.origen + `</td>
                    <td>` + item.destino + `</td>
                    <td>` + item.fecha + `</td>
                    <td>` + item.hora + `</td>
                    <td>` + item.numerovuelo + `</td>
                    <td>` + item.tipocabina + `</td>
                    <td>` + item.preciocabina + `</td>
                    <td>` + item.totalseats + `</td>
                    <td>` + item.asientosOcupados + `</td>
                    <td>` + item.seatdis + `</td>
                    <td> <label> <input type="radio" name="${table}" onclick="SetAsideOrg(${item.id},'${item.origen}','${item.destino}','${item.tipocabina}',${item.seatdis},'${table}')" id="${table}${item.id}${item.tipocabina}"> Seleccionar </label></td>
                    </tr>`;
        });
        $('#headTable1').DataTable().destroy();
        $("#tabla1").html(html);
        $('#headTable1').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ items",
                info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
                aria: {
                    sortAscending: ": active para ordenar la columna en orden ascendente",
                    sortDescending: ": active para ordenar la columna en orden descendente"
                }
            },
            lengthMenu: [[5, 10, -1], [5, 10, "All"]],
        });
        if (document.getElementById(localStorage.getItem('SetAsideOrgCheck')) != null) {
            document.getElementById(localStorage.getItem('SetAsideOrgCheck')).checked = true;
        }
    }
    if (table === "tabla2") {
        data.forEach(function (item) {
            html +=
                `<tr>
                    <td>` + item.origen + `</td>
                    <td>` + item.destino + `</td>
                    <td>` + item.fecha + `</td>
                    <td>` + item.hora + `</td>
                    <td>` + item.numerovuelo + `</td>
                    <td>` + item.tipocabina + `</td>
                    <td>` + item.preciocabina + `</td>
                    <td>` + item.totalseats + `</td>
                    <td>` + item.asientosOcupados + `</td>
                    <td>` + item.seatdis + `</td>
                    <td> <label> <input type="radio" name="${table}" onclick="SetAsideDes(${item.id},'${item.origen}','${item.destino}', '${item.tipocabina}',${item.seatdis},'${table}')" id="${table}${item.id}${item.tipocabina}"> Seleccionar </label></td>
                    </tr>`;

        });
        $('#headTable2').DataTable().destroy();
        $("#tabla2").html(html);
        $('#headTable2').DataTable({
            language: {
                processing: "Tratamiento en curso...",
                search: "Buscar&nbsp;:",
                lengthMenu: "Agrupar de _MENU_ items",
                info: "Mostrando del item _START_ al _END_ de un total de _TOTAL_ items",
                infoEmpty: "No existen datos.",
                infoFiltered: "(filtrado de _MAX_ elementos en total)",
                infoPostFix: "",
                loadingRecords: "Cargando...",
                zeroRecords: "No se encontraron datos con tu busqueda",
                emptyTable: "No hay datos disponibles en la tabla.",
                paginate: {
                    first: "Primero",
                    previous: "Anterior",
                    next: "Siguiente",
                    last: "Ultimo"
                },
                aria: {
                    sortAscending: ": active para ordenar la columna en orden ascendente",
                    sortDescending: ": active para ordenar la columna en orden descendente"
                }
            },

            lengthMenu: [[5, 10, -1], [5, 10, "All"]],
        });
        if (document.getElementById(localStorage.getItem('SetAsideDesCheck')) != null) {
            document.getElementById(localStorage.getItem('SetAsideDesCheck')).checked = true;
        }
    }
}

//Trae la Data
function LoadData(origen, destino, checkbox, fechaBase, table, numAsientos) {

    data = FilterTable(origen, destino, checkbox, fechaBase, numAsientos)

    jsondata = JSON.stringify(data)

    $.ajax({
        url: "http://localhost:9000/Session3/1v/api/schedules/stockpile/filter",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsondata,
        success: function (response) {
            const data = response;
            DataTable(table, data)

        }
    })

}

//Funcion para llamar solo a la tabla1
function CallDataOnlyTable1() {
    Leer()
    LoadData(origen, destino, checkOrg, fechaSalida, 'tabla1', numAsientos, tipocabina)
}

//Funcion para llamar solo a la tabla2
function CallDataOnlyTable2() {
    Leer()
    LoadData(destino, origen, checkDes, fechaRegreso, 'tabla2', numAsientos, tipocabina)
}

//Funcion para llamar ambas tablas
function CallData() {
    CallDataOnlyTable1()
    CallDataOnlyTable2()
}
// Seleccionar reserva de origen
function SetAsideOrg(id, origen, destino, typeCabine, seatdis, table) {
    $("#origen").val(origen)
    $("#destino").val(destino)
    CallData()
    localStorage.setItem("SetAsideOrgCheck", `${table}${id}${typeCabine}`);
    pajmaxOrg = seatdis
    localStorage.setItem("SetAsideOrg", [id, origen, destino, typeCabine])
    console.log(localStorage.getItem("SetAsideOrg"));
    limit()
}

function SetAsideDes(id, origen, destino, typeCabine, seatdis, table) {

    $("#origen").val(destino)
    $("#destino").val(origen)
    CallData()
    localStorage.setItem("SetAsideDesCheck", `${table}${id}${typeCabine}`);
    pajmaxDes = seatdis
    localStorage.setItem("SetAsideDes", [id, origen, destino, typeCabine])
    console.log(localStorage.getItem("SetAsideDes"));
    limit()
}

function ClearData() {
    $("#origen").val("")
    $("#destino").val("")
    $("#tipo-cabina").val("")
    $("#fecha-salida").val("")
    $("#fecha-regreso").val("")
    $("#numAsientos").val("")
    $("#vsalida").prop("checked", false);
    $("#vretorno").prop("checked", false);
    $("#retorno").prop("checked", true);

}

function limit() {
    Leer()
    if (trayectoria == "retorno") {
        var limit = 0
        if (pajmaxOrg > pajmaxDes) {
            limit = pajmaxDes
            console.log(limit, "con retorno ");
        }
        else {
            limit = pajmaxOrg
            console.log(limit, "con retorno ");
        }
    } else {
        limit = pajmaxOrg
        console.log(limit, "sin retorno");
    }
    pasajero.max = limit
    if ($("#pasajeros").val() > limit) {
        $("#pasajeros").val(limit)
    }
    if ($("#pasajeros").val() === "" || $("#pasajeros").val() === null) {
        $("#pasajeros").val(0)
    }
    localStorage.setItem("numPasajeros", $("#pasajeros").val())
    console.log(localStorage.getItem("numPasajeros"))
}

//mostrar datos por consola
function escribir() {
    console.log(origen);
    console.log(destino);
    console.log(tipocabina);
    console.log(trayectoria);
    console.log(fechaSalida);
    console.log(fechaRegreso);
    console.log(numAsientos);
    console.log(checkOrg);
    console.log(checkDes);
}

function changeView() {
    Leer()
    if (trayectoria == "retorno") {

        if (localStorage.getItem("SetAsideOrg") === null && localStorage.getItem("SetAsideDes") === null) {
            Swal.fire({
                title: "No escogio ningun vuelo",
                icon: "error"
            });
        }
        else if (localStorage.getItem("SetAsideOrg") === null) {
            Swal.fire({
                title: "No escogio vuelo de ida",
                icon: "error"
            });
        } else if (localStorage.getItem("SetAsideDes") === null) {
            Swal.fire({
                title: "No escogio vuelo de regreso",
                icon: "error"
            });
        } else if (localStorage.getItem("numPasajeros") === null) {
            Swal.fire({
                title: "No escogio el numero de reservas",
                icon: "error"
            });
        } else if (localStorage.getItem("numPasajeros") === "0") {
            Swal.fire({
                title: "El numeor de reservas no puede ser cero",
                icon: "error"
            });
        }
        else {
            Swal.fire({
                title: "Estas seguro de ralizar la reserva?",
                html: `Revisa bien los datos <br>
                Datos del vuelo de ida:    ${localStorage.getItem("SetAsideOrg")}<br>
                Datos del vuelo de salida: ${localStorage.getItem("SetAsideDes")}<br>
                Cantidad de asientos: ${localStorage.getItem("numPasajeros")}`,
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Yes, delete it!"
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "form2.2.html";
                }
            });

        }
    } else if (trayectoria == "solo-ida") {
        if (localStorage.getItem("numPasajeros") === null) {
            Swal.fire({
                title: "No escogio el numero de reservas",
                icon: "error"
            });
        } else if (localStorage.getItem("numPasajeros") === "0") {
            Swal.fire({
                title: "El numeor de reservas no puede ser cero",
                icon: "error"
            });
        }
        else if (localStorage.getItem("SetAsideOrg") === null) {
            Swal.fire({
                title: "No escogio ningun vuelo",
                icon: "error"
            });
        }
        else {
            Swal.fire({
                title: "Estas seguro de ralizar la reserva?",
                html: `Revisa bien los datos <br>
                Datos del vuelo de ida:    ${localStorage.getItem("SetAsideOrg")}<br>
                Datos del vuelo de salida: ${localStorage.getItem("SetAsideDes")}<br>
                Cantidad de asientos: ${localStorage.getItem("numPasajeros")}`,
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Yes, delete it!"
            }).then((result) => {
                if (result.isConfirmed) {
                    window.location.href = "form2.2.html";
                }
            });
        }
    }
}

function leerTrayectoria() {
    Leer()
    const container = document.getElementById("container-tabla2");
    const buscador = document.getElementById("buscador-tabla2");
    if (trayectoria === 'retorno') {
        console.log("Seleccionado: Retorno");
        container.style.display = "block";
        buscador.style.visibility = "visible";
        CallData()
    } else if (trayectoria == "solo-ida") {
        limit()
        $('input[name="tabla2"]').prop('checked', false);
        localStorage.removeItem("SetAsideDes");
        container.style.display = "none";
        buscador.style.visibility = "hidden";
        CallDataOnlyTable1()
    }


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
                    CallData()
                    return false;
                }
            })
            $("#destino").autocomplete({
                source: autocompletar,
                select: function (event, ui) {
                    $(this).val(ui.item.label)
                    destinoId = ui.item.value
                    CallData()
                    return false;
                }
            })
        }
    })
}