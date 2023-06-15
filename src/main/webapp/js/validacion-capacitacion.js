
//Validacion de Campos con JavaScript

document.addEventListener("DOMContentLoaded", function(){
    //*Obtener el formulario y sus campos
    let form 			= document.querySelector("#form-capacitacion");
    let rutCliente 		= document.querySelector("#rutCliente");
    let dia 			= document.querySelector("#dia");
    let hora 			= document.querySelector("#hora");
    let lugar 			= document.querySelector("#lugar");
    let duracion		= document.querySelector("#duracion");
    let cantAsistentes	= document.querySelector("#cantAsistentes");


    function capacitacionValidate(){
        let rutValue 		 = rutCliente.value;      
        let diaValue 		 = dia.value;
        let horaValue 		 = hora.value;
        let lugarValue 		 = lugar.value;
        let duracionValue	 = duracion.value;
        let asistentesValue  = cantAsistentes.value;
   		//Expresión Regular : Para requerir formato de hora HH:MM
        let horaRegex = /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/;
    
         
        //* Validando rut      
        if(rutValue.length == 0){
            document.querySelector("#rutClienteHelp").innerHTML = "El campo no puede estar vacio";
            
        }else if(rutValue.length < 8){
            document.querySelector("#rutClienteHelp").innerHTML = "El rut debe contener almenos 8 digitos sin guion ni número verificador";     
            
        }else{
           document.querySelector("#rutClienteHelp").innerHTML = " ";
        }

 		//Validando que el campo día no quede vacio
        if(diaValue.length == 0){
            document.querySelector("#diaHelp").innerHTML = "El campo no puede estar vacio";
            
        }else if(diaValue.length < 5){
            document.querySelector("#diaHelp").innerHTML = "Debe ingresar un día de la semana";
        }else{
           document.querySelector("#diaHelp").innerHTML = " ";           
        }
        
        //Validando formato de hora
        if(horaValue.length == 0){
            document.querySelector("#horaHelp").innerHTML = "El campo no puede estar vacio";
        }
        else if(!horaRegex.test(horaValue)){
           document.querySelector("#horaHelp").innerHTML = "Ingrese una hora con fomrmato valido (HH:MM)";            
        }else {
            document.querySelector("#horaHelp").innerHTML = " "
        }


        //Validando que el campo lugar no quede vacio      
        if(lugarValue.length == 0 ){
            document.querySelector("#lugarHelp").innerHTML = "El campo no puede estar vacio.";            
        }else{
            document.querySelector("#lugarHelp").innerHTML = " ";      
        }
        
        //Validando que el campo duración no quede vacio.      
        if(duracionValue.length == 0 ){
            document.querySelector("#duracionHelp").innerHTML = "El campo no puede estar vacio.";            
        }else{
            document.querySelector("#duracionHelp").innerHTML = " ";      
        }
        
        //Validando cantidad de asistentes
        if(asistentesValue.length == 0){
            document.querySelector("#cantAsistentesHelpHelp").innerHTML = "El campo no puede estar vacio";
        }else if(asistentesValue < 1){
            document.querySelector("#cantAsistentesHelp").innerHTML = "La cantidad de asistentes no puede ser 0";
        }
        else {
            document.querySelector("#cantAsistentesHelpHelp").innerHTML = " "
        }
        
		//Validacion General
        if (rutValue.length == 0 || diaValue.length == 0 || horaValue.length == 0 ||
        	lugarValue == null || duracionValue == null || asistentesValue < 1){
            document.querySelector("#finalHelp").innerHTML = "Debe llenar todos los campos correctamente.";
            return false;
        }
        

        //Si todo esta bien y pasaron todas las validaciones, se enviara el formulario.
        return true;
    }
    
    // Agregamos la función de validación al evento submit del formulario
    form.addEventListener("submit", function(event){

        //* Si la funcion validate retorna un false no se enviará el formulario
        if(!capacitacionValidate()){

            event.preventDefault();
        }
    })

});