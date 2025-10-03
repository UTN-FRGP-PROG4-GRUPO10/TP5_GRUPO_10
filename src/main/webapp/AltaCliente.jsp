<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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

</body>
</html>