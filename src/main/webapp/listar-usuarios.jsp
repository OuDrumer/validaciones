<%@page import="cl.awakelab.prevencion.modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"  rel="stylesheet">
		<title>Listar Usuarios</title>
		<link rel="stylesheet" href="css/styles.css">
		<!-- Font Awesome -->
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	    <!-- /Font Awesome -->
	</head>
	<body>
		<!-- Navbar -->
	    <jsp:include page="navbar.jsp"/>
	    <!-- End Navbar -->
	    
		<div class="container mt-5">
			<div class="row ">
			<h1 class="text-center">
				Listado Usuarios
			</h1>
			
			
			<form action="">
				<select id="tipoUsuario" name="tipoUsuario" class="form-select mb-3" aria-label="Default select example" onchange="enviar-formulario" required >
					<option value="" selected disabled>Elegir un Tipo de Usuario</option>
					<option value="1">Cliente</option>
					<option value="2">Profesional</option>
					<option value="3">Administrativo</option>
				</select>
			</form>
			
			<!-- Tabla -->
		      <table class="table table-striped table-hover">
		        <thead class="table-dark">
		        <tr>
		          
		          <th scope="col">Nombre Usuario</th>
		          <th scope="col">Contraseña</th>
		          <th scope="col">Run</th>
		          <th scope="col">Fecha de Nacimiento</th>
		          <th scope="col">Nombres</th>
		          <th scope="col">Apellidos</th>
		          <th scope="col">Acciones</th>
		        </tr>
		        </thead>
		        
		        <tbody class="table-group-divider">
		        <!-- row = fila -->
		        
		 		<% List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios"); 
		 			if(usuarios != null) {	
		 				
		 			 for(Usuario user: usuarios) { 
		 			 %>
		        <tr>
		          <td><%=user.getUsuario()%></td>
		          <td><%=user.getPassword()%></td>
		          <td><%=user.getRun()%></td>
		          <td><%=user.getFechaNacimiento()%></td>
		          <td><%=user.getNombre()%></td>
		          <td><%=user.getApellido()%></td>
		          <td>
                  	<a class="text-success" href="ServeltCrudStudent?option=formUpdateStudent&idStudent=<%=user.getId()%>"><i class="fa-solid fa-pen-to-square mx-3"></i></a>
 					<a class="text-danger" href="ServeltCrudStudent?option=deleteStudent&idStudent=<%=user.getId()%>"><i class="fa-solid fa-trash"></i></a>
                  </td>
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
		
		<script src="js/listar-por-tipo-usuario.js"></script>
	</body>
</html>