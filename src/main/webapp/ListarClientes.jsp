<%@page import="entidad.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
<a href="ServletCliente?Param=list">Listar clientes</a>
<%
	List<Cliente> listaC = new ArrayList<Cliente>();
	if(request.getAttribute("listaC")!=null){
		listaC = (List<Cliente>) request.getAttribute("listaC");
	}
	
%>
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
</body>
</html>