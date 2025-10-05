<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
    String fechaActual = java.time.LocalDate.now().toString();
%>
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
    
     <main class="col-md-10 ms-sm-auto px-md-4 py-4">
            <h1>Alta de Cliente</h1>
            <p><strong>Usuario: </strong><%= session.getAttribute("usuario") %></p>
 
            <div class="card p-4">
                <form action="ServletCliente" method="post">
                    <div class="row">
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">DNI</label>
                            <input type="text" class="form-control" name="txtDNI" required pattern="^\d{6,8}$" title="Solo números, 6 a 8 dígitos"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">CUIL</label>
                            <input type="text" class="form-control" name="txtCuil" required pattern="^\d{11}$" title="Solo números, 11 dígitos"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Nombre</label>
                            <input type="text" class="form-control" name="txtNombre" required pattern="^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$" title="Solo letras"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Apellido</label>
                            <input type="text" class="form-control" name="txtApellido" required pattern="^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$" title="Solo letras"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Sexo</label>
                            <select class="form-select" name="txtSexo" required>
                                <option value="">Seleccione</option>
                                <option value="M">Masculino</option>
                                <option value="F">Femenino</option>
                                <option value="O">Otro</option>
                            </select>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Nacionalidad</label>
                            <input type="text" class="form-control" name="txtNacionalidad" required pattern="^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$" title="Solo letras"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Fecha de Nacimiento</label>
                            <input type="date" class="form-control" name="txtFechaNacimiento" required max="<%= fechaActual %>"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Dirección</label>	
                            <input type="text" class="form-control" name="txtDireccion" required/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Localidad</label>
                            <input type="text" class="form-control" name="txtLocalidad" required pattern="^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$" title="Solo letras"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Provincia</label>
                            <input type="text" class="form-control" name="txtProvincia" required pattern="^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$" title="Solo letras"/>
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Correo Electrónico</label>
                            <input type="email" class="form-control" name="txtCorreoElectronico" required />
                        </div>
                        
                        <div class="col-md-6 mb-3">
                            <label class="form-label">Teléfono</label>
                            <input type="text" class="form-control" name="txtTelefono" required pattern="^\d{10}$" title="Solo números 10 dígitos"/>
                        </div>
                        
                    </div>
                    
                    <button type="submit" class="btn btn-primary" name="btnRegistrarCliente">Guardar Cliente</button>
                    
                </form>
                
            </div>
            <% 
                String mensaje = (String)request.getAttribute("mensaje");
                Boolean filas = (Boolean)request.getAttribute("filas");
                
                if (mensaje != null) { 
                    String tipoAlerta;
                    if (filas == true) tipoAlerta = "alert-success";
                    else tipoAlerta = "alert-danger";
            %>
                <div class="alert <%= tipoAlerta %>" role="alert">
                    <%= mensaje %>
                </div>
            <% } %>
        </main>
    </div>
</div>


</body>
</html>