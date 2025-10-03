<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        background-color: white;
        margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }
    
  table { width: 100%; border-collapse: collapse; }
  td { padding: 0; }
  label { display: block; font-size: 14px; margin-bottom: 6px; color: #333; }
  input[type="text"], input[type="password"] {
    width: 100%; padding: 0 5px; height: 35px;
    border: 1px solid #cfd4dc; border-radius: 8px;
    outline: none;
  }
    
    
    .contenedor-login {
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 8px;
        background-color: #f8f8f8;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    
    </style>
</head>
<body>
	<div class="contenedor-login">
<form action="ServletUsuario" method="post">
	<table>
		<tr>

			<td><label>Usuario:</label>
			<input type="text" name="txtUsuario" required/></td>
			
		</tr>
		<tr>
			<td><label>Contraseña:</label>
				<input type="password" name="txtContrasena" required/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Ingresar" name="btnLogin"/></td>
		</tr>
		<%
			if(request.getParameter("btnLogin") != null){
				if(request.getAttribute("usuario") != null) { %>
					<tr>
						<td><label style="color: green;">Sesión iniciada correctamente.</label></td>
					</tr>
				<% }
				else { %>
					<tr>
						<td><label style="color: red;">Nombre de usuario o contraseña incorrectos.</label></td>
					</tr>
				<% }
			}
		%>
	</table>
</form>
</body>
</html>