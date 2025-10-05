<%@page import="entidad.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- BOOTSTRAP -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css" rel="stylesheet">
<!-- DATATABLES SCRIPTS -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/2.3.4/css/dataTables.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/2.3.4/js/dataTables.min.js"></script>
<meta charset="UTF-8">
<title>Listado de Clientes</title>
<script type="text/javascript">
	$(document).ready( function (){
		$('#tablaClientes').DataTable();
	} );
</script>
</head>
<body> 
<%
	List<Cliente> listaC = new ArrayList<Cliente>();
	if(request.getAttribute("listaC")!=null){
		listaC = (List<Cliente>) request.getAttribute("listaC");
	}
	
%>
<div class="container-fluid">
  <div class="row">
    <!-- Sidebar -->
    <nav class="col-md-2 d-none d-md-block bg-primary sidebar text-white vh-100">
      <div class="position-sticky pt-3">
        <h5 class="text-center">Menú</h5>
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link text-white active" href="AltaCliente.jsp">Alta de Cliente</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="ServletCliente?Param=list">Listado de Clientes</a>
          </li>
        </ul>
      </div>
    </nav>
    
     <main class="col-md-10 ms-sm-auto px-md-4">
      <div class="pt-3">
        <h2>Formulario de Cliente</h2>
        <p><strong>Usuario: </strong><%= session.getAttribute("usuario") %></p>
        <h5>Listado de Clientes ()</h5>

        <div class="table-responsive">
<table id="tablaClientes" class="display">
	<thead>
	<tr>
		<th>DNI</th>
		<th>CUIL</th>
		<th>Nombre y Apellido</th>
		<th>Sexo</th>
		<th>Fecha de Nacimiento</th>
		<th>Dirección</th>
		<th>Nacionalidad</th>
		<th>Localidad</th>
		<th>Provincia</th>	
	</tr>
	</thead>
	<tbody>
	<%
	for (Cliente c : listaC) {	
	%>
	<tr>
		<td><%=c.getDni()%></td>
		<td><%=c.getCuil()%></td>
		<td><%=c.getNombreCompleto()%></td>
		<td><%=c.getSexo()%></td>
		<td><%=c.getFechaNacimiento()%></td>
		<td><%=c.getDireccion()%></td>
		<td><%=c.getNacionalidad()%></td>
		<td><%=c.getLocalidad()%></td>
		<td><%=c.getProvincia()%></td>
	</tr>
	<%
	}
	%>
	</tbody>
	
			</table>
  		</div>
      </div>
    </main>
  </div>
</div>
</body>
</html>