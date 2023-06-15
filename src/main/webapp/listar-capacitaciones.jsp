<%@page import="cl.awakelab.prevencion.modelo.Capacitacion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"  rel="stylesheet">
		<title>Listado de  Capacitaciones</title>
		<link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
		<!-- Navbar -->
	    <jsp:include page="navbar.jsp"/>
	    <!-- End Navbar -->
	    
		<div class="container mt-5">
			<div class="row ">
			<h1 class="text-center">
				Listado de capacitaciones
			</h1>
			
			<!-- Tabla -->
		      <table class="table table-striped table-hover">
		        <thead class="table-dark">
		        <tr>
		          
		          <th scope="col">Rut de Cliente</th>
		          <th scope="col">Día</th>
		          <th scope="col">Hora</th>
		          <th scope="col">Lugar</th>
		          <th scope="col">Duración</th>
		          <th scope="col">Cantidad de Asistentes</th>
		        </tr>
		        </thead>
		        
		        <tbody class="table-group-divider">
		        <!-- row = fila -->
		        
		 		<% List<Capacitacion> capacitaciones =(List<Capacitacion>)request.getAttribute("capacitaciones"); 
		 			if(capacitaciones != null) {		 		
		 			 for(Capacitacion cap: capacitaciones) { 
		 			 %>
		        <tr>
		          <td><%=cap.getRutCliente()%></td>
		          <td><%=cap.getDia()%></td>
		          <td><%=cap.getHora()%></td>
		          <td><%=cap.getLugar()%></td>
		          <td><%=cap.getDuracion()%></td>
		          <td><%=cap.getCantidadDeAsistentes()%></td>
		        </tr>
		        
		   		<% }
		   		} %>
		        </tbody>
		        
		      </table>
					
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