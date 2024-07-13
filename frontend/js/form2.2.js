const origen = localStorage.getItem("SetAsideOrg");
const destino = localStorage.getItem("SetAsideDes");
const numPasajeros = localStorage.getItem("numPasajeros");
const dataOrigen = origen.split(",");
var dataDestino = []
var listPasajeros = []
let base64String = ''
var precioOrg = 0
var precioDes = 0

function leer() {
    console.log(dataOrigen);

    if (destino != null) {
        dataDestino = destino.split(",");
        console.log(dataDestino);
    }

    console.log(numPasajeros);
}

// crea el cuerpo con el que filtra
function FilterTable(id, origen, destino, tipocabina) {
    const data = {
        "id": id,
        "origen": origen,
        "destino": destino,
        "fechaSalida": "",
        "fechaLlegada": "",
        "tipocabina": tipocabina,
        "seatdis": null
    }
    return data
}

// crea el cuerpo en la tabla correspondiente
function DataTable(table, data) {
    if (table === "origen") {
        $("#salida-origen").text(data[0].origen);
        $("#salida-destino").text(data[0].destino);
        $("#salida-cabina").text(data[0].tipocabina);
        $("#salida-fecha").text(data[0].fecha);
        $("#salida-hora").text(data[0].hora);
        $("#salida-precio").text(data[0].preciocabina);
        $("#salida-numvuel").text(data[0].numerovuelo);
        precioOrg = data[0].preciocabina
    } else {
        $("#retorno-origen").text(data[0].origen);
        $("#retorno-destino").text(data[0].destino);
        $("#retorno-cabina").text(data[0].tipocabina);
        $("#retorno-fecha").text(data[0].fecha);
        $("#retorno-hora").text(data[0].hora);
        $("#retorno-precio").text(data[0].preciocabina);
        $("#retorno-numvuel").text(data[0].numerovuelo);
        precioDes = data[0].preciocabina
    }
}

//Trae la Data
function LoadData(id, origen, destino, tipocabina, table) {
    const filtro = FilterTable(id, origen, destino, tipocabina)
    const jsondata = JSON.stringify(filtro)
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
function loadOrigen() {
    LoadData(dataOrigen[0], dataOrigen[1], dataOrigen[2], dataOrigen[3], "origen")
}

//Funcion para llamar solo a la tabla2
function loadDestino() {
    LoadData(dataDestino[0], dataDestino[1], dataDestino[2], dataDestino[3], "destino")
}

function leerPasajeroInfo(event) {
    event.preventDefault();

    const reader = new FileReader();
    const fileInput = document.getElementById("Passport");
    const file = fileInput.files[0];

    reader.onload = function (event) {
        const photo = event.target.result;
        const data = {
            nombre: $("#Nombres").val(),
            apellidos: $("#Apellidos").val(),
            fecha: $("#fecha").val(),
            numPassport: $("#numPassport").val(),
            telefono: $("#telefono").val(),
            origen: $("#origen").val(),
            passport: photo
        };

        if (listPasajeros.length >= numPasajeros) {
            Swal.fire({
                icon: "error",
                title: "Cupos insuficientes en el vuelo de salida.",
                text: "No se puede ingresar más pasajeros, verifique la cantidad máxima de asientos."
            });
            console.log("No se pueden agregar más pasajeros.");
        } else {
            listPasajeros.push(data);
            console.log(listPasajeros);
            actualizartabla();
        }
    };

    if (file) {
        reader.readAsDataURL(file);
    } else {
        console.error("No se seleccionó ningún archivo.");
    }

    return false;
}


function actualizartabla() {
    var valor = 0
    var html = "";
    listPasajeros.forEach(function (pasajero) {
        html +=
            `<tr>
            <td>` + pasajero.nombre + `</td>
            <td>` + pasajero.apellidos + `</td>
            <td>` + pasajero.fecha + `</td>
            <td>` + pasajero.numPassport + `</td>
            <td>` + pasajero.telefono + `</td>
            <td>` + pasajero.origen + `</td>
            <td> <button data-bs-toggle="modal" data-bs-target="#staticBackdrop2" onclick="mostrarImagen('${pasajero.passport}')">Mostrar Pasaporte</button> </td>
            </tr>`
        valor += precioOrg;
        if (dataDestino.length != 0) {
            valor += precioDes;
        }
    });
    $("#pasajerotabla").html(html)
    $("#valor").text(valor)
}

function deletePerson() {
    listPasajeros.pop()
    actualizartabla()
}

async function realizarReserva() {
    const promises = [];
    listPasajeros.forEach(function (pasajero) {

        if (dataOrigen[3] === "economy") {
            cabinType = 1
        } else if (dataOrigen[3] === "business") {
            cabinType = 2
        }
        data = {
            "cabinType": {
                "id": cabinType
            },
            "schedule": {
                "id": parseInt(dataOrigen[0])
            },
            "user": {
                "id": 1
            },
            "distance": 0,
            "firstName": pasajero.nombre,
            "lastName": pasajero.apellidos,
            "email": pasajero.nombre + pasajero.apellidos + "@gmail.com",
            "phone": parseInt(pasajero.telefono),
            "passportNumber": parseInt(pasajero.numPassport),
            "passportCountryId": pasajero.origen,
            "passportPhoto": pasajero.passport,
            "bookingReference": 0,
            "confirmed": true
        }

        promises.push(guardarTickest(data));
    })
    if (dataDestino.length != 0) {

        listPasajeros.forEach(function (pasajero) {

            if (dataDestino[3] === "economy") {
                cabinType = 1
            } else if (dataDestino[3] === "business") {
                cabinType = 2
            }

            data = {
                "cabinType": {
                    "id": cabinType
                },
                "schedule": {
                    "id": parseInt(dataDestino[0])
                },
                "user": {
                    "id": 1
                },
                "distance": 0,
                "firstName": pasajero.nombre,
                "lastName": pasajero.apellidos,
                "email": pasajero.nombre + pasajero.apellidos + "@gmail.com",
                "phone": pasajero.telefono,
                "passportNumber": pasajero.numPassport,
                "passportCountryId": pasajero.origen,
                "passportPhoto": pasajero.passport,
                "bookingReference": 0,
                "confirmed": true
            }

            promises.push(guardarTickest(data));
        })
    }
    try {
        await Promise.all(promises);
        console.log("Todos los tickets se han guardado con éxito");
        await delay(1000);
        window.location.href = "form1.1.html";
    } catch (error) {
        console.error("Error al guardar uno o más tickets", error);
    }

}

function guardarTickest(data) {

    const jsondata = JSON.stringify(data)
    $.ajax({
        url: "http://localhost:9000/Session3/1v/api/tickets",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsondata,
        success: function (response) {
            console.log("Se guardó con éxito", response);
        },
        error: function (error) {
            console.error("Error al guardar el ticket", error);
        }
    })
}

function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

function pasajaeros() {
    var limite = parseInt(localStorage.getItem("ticketsReservados"));
    console.log();
    if (pasajeros.length >= limite) {
        Swal.fire({
            icon: "error",
            title: "Cupo de tickets alcanzados.",
            text: "ya se reservo la cantidad de tickets ingresados",
        });
    } else {
        const reader = new FileReader();
        var photo;

        const fileInput = document.getElementById("formFile");
        const file = fileInput.files[0];

        reader.onload = function (event) {
            photo = event.target.result;

            var data = {
                ticket: {
                    firstName: $("#nombre").val(),
                    lastName: $("#apellido").val(),
                    birthday: $("#birthday").val(),
                    phone: $("#telefono").val(),
                    passportNumber: $("#num_pass").val(),
                    passportCountry: {
                        id: parseInt($("#pais_pass").val()),
                        name: $("#pais_pass option:selected").text(),
                    },
                    passportPhoto: photo,
                },
            };

            pasajeros.push(data);
            tablePasajero();
            document.getElementById("formulario").reset();
        };

        if (file) {
            reader.readAsDataURL(file);
        } else {
            Swal.fire({
                icon: "error",
                title: "Por favor seleccione un archivo de foto.",
            });
        }
    }
}



function mostrarImagen(url) {
    console.log(url);
    $("#imagen").attr('src', `${url}`);
    // <img src="${pasajero.passport}" > </img>

}