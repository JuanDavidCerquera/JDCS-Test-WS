function filtro() {
    data = {
        "departureAirportsId": $("#origen").val(),
        "arrivalAirportsId": $("#destino").val(),
        "distance": $("#distance").val(),
        "flightTime": $("#flightTime").val()
    }

    var jsondata = JSON.stringify(data)

    $.ajax({
        url: "http://localhost:9000/Session3/1v/api/routes/filters",
        method: "POST",
        dataType: "json",
        contentType: "application/json",
        data: jsondata,
        success: function (response) {

            // console.log(response.data);
            var html = "";
            // var data = response.data;
            // console.log(data)
            response.forEach(function (item) {
                html +=
                    `<tr>
                        <td>` + item.departureAirportsId.name + `</td>
                        <td>` + item.arrivalAirportsId.name + `</td>
                        <td>` + item.distance + `</td>
                        <td>` + item.flightTime + `</td>
                    </tr>`;
            });
            $("#tabla1").html(html);
        }
    })
}


function autoComplete() {
    $.ajax({
        url: ""
    });
}