// localStorage en uso
// localStorage.setItem("numeroPasajeros", $("#pasajeros").val())
// localStorage.setItem("vueloRetorno", id)
// localStorage.setItem("vueloSalida", id)

function loadVueloSalida() {
    vueloSalida = localStorage.getItem("vueloSalida")
    console.log(vueloSalida);
}