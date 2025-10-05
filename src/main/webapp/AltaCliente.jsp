<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- BOOTSTRAP -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>

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
    <h1>Alta Cliente</h1>
    <form action="ServletCliente" method="post">
		<label>DNI</label>
		<input type="text" name="txtDNI" required/>
		<tr></tr>
		<label>CUIL</label>
		<input type="text" name="txtCuil" required/>
		</br>
		<label>Nombre</label>
		<input type="text" name="txtNombre" required/>
		<tr></tr>
		<label>Apellido</label>
		<input type="text" name="txtApellido" required/>
		</br>
		<label>Sexo</label>
		<input type="text" name="txtSexo" required/>
		<tr></tr>
		<Label>Nacionalidad</Label>
		<input type="text" name="txtNacionalidad" required/>
		</br>
		<label>Fecha de Nacimiento</label>
		<input type="date" name="txtFechaNacimiento" required/>
		<tr></tr>
		<Label>Direccion</Label>	
		<input type="text" name="txtDireccion" required/>
		</br>
		<Label>Localidad</Label>
		<input type="text" name="txtLocalidad" required/>
		<tr></tr>
		<Label>Provincia</Label>
		<input type="text" name="txtProvincia" required/>
		</br>
		<Label>Correo Electronico</Label>
		<input type="text" name="txtCorreoElectronico" required/>
		<tr></tr>
		<Label>Telefono</Label>
		<input type="text" name="txtTelefono" required/>
		</br>
		<input type="submit" value="Guardar Cliente" name="btnRegistrarCliente"/>
		
		
    </form>
</main>
</div>
</div>
</body>
</html>