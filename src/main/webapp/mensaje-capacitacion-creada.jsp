<%@page import="cl.awakelab.prevencion.modelo.Capacitacion"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"  rel="stylesheet">
		<title>Mensaje Capacitacion Creada</title>
		<link rel="stylesheet"  href="css/styles.css">
	</head>
	<body>
		<!-- Navbar -->
	    <jsp:include page="navbar.jsp"/>
	    <!-- End Navbar -->
	    
		<div class="container mt-5">
			<h1 class="text-center">Capacitacion Creada</h1>
			<h4 class="text-center">Felicidades, Creacion de nueva Capacitación exitosa</h4>
			
			
			<div class="row mt-5">
			<% Capacitacion cap = (Capacitacion)request.getAttribute("capacitacion"); 
		 		if(cap != null) {
		 			%>
						
			<table id="enfasis-columna">
                
                <thead>
	                <tr>
		                <th class="text-center" 
		                style="font-size:1.5rem;
		                 font-weight: bold;
		                 background-color:#669;
		                 padding: 12px 15px;
		                 color:#039;">
		                 Datos
		                 </th>
		                 
		                <th class="text-center" 
		                style="font-size:1.5rem;
		                 font-weight: bold;
		                 background-color:#669;
		                 padding: 12px 15px;
		                 color:#039;">
		                 Valores
		                 </th>                
	                </tr>
                </thead>
                <tbody>
                
	                <tr>
	                    <td class="columna">
	                        Rut del cliente:
	                    </td>
	                    <td>
	                        <b><%=cap.getRutCliente()%></b>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="columna">
	                        Día de capacitación:
	                    </td>
	                    <td>
	                        <b><%=cap.getDia()%></b>
	                    </td>
	                </tr>
	                <tr>
	                    <td class="columna">
	                        Hora de capacitación:
	                    </td>
						<td>
	                        <b><%=cap.getHora()%></b>
	                    </td>
	                 </tr>
	                <tr>
	                    <td class="columna">
	                        Lugar de capacitación:
	                    </td>
						<td>
	                        <b><%=cap.getLugar()%></b>
	                    </td>
	                 </tr>
	                <tr>
	                    <td class="columna">
	                        Duración de capacitación:
	                    </td>
						<td>
	                        <b><%=cap.getDuracion()%></b>
	                    </td>
	                 </tr>
	                <tr>
	                    <td class="columna">
	                       Cantidad de asistentes:
	                    </td>
						<td>
	                        <b><%=cap.getCantidadDeAsistentes()%></b>
	                    </td>
	                </tr>
                 </tbody>
            </table>
			<% }
		   		 %>		
		 
			</div>
		</div>
		
		<!-- Footer -->
	    <jsp:include page="footer.jsp"/>
	    <!-- End Footer -->
	    
		<!-- JavaScript de bootstrap -->
		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
		<!-- Fin JavaScript de bootstrap -->
	</body>
</html>