$(document).ready( function () {    
    $("#tipoUsuario").click(function(){
		enviarTipoUsuario();
    });
});

function enviarTipoUsuario(){

       let tipoUsuario = $("#tipoUsuario").val()
        
        $.ajax({
        type: "GET",
        datatype: "html",
        url: "./ServletListadoUsuarios",
        data: $.param({
            tipoUsuario: tipoUsuario
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            console.log(parsedResult)
            //* Retornar un false
            if(parsedResult != false){
                let tipousuario = parsedResult['tipoUsuario'];
                document.location.href = "listar-usuario.jsp?tipousuario="+tipousuario;
            }
        }
    });    
}