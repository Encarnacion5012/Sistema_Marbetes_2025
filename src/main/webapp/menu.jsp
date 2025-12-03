<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Verificar sesión (básico)
    String usuario = (String) session.getAttribute("usuarioLogueado");
    if(usuario == null) { response.sendRedirect("login.jsp"); return; }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Menú Principal</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="card-container">
        <img src="images/images.jpg" alt="Logo" width="80" style="margin-bottom: 10px;">
        <h2>Panel de Principal</h2>
        
        <div class="alert alert-success" style="text-align: center;">
            Bienvenido, Agente: <strong><%= usuario.toUpperCase() %></strong>
        </div>
        
        <div style="margin-top: 40px;">
            <a href="index.jsp" class="btn btn-primary" style="margin-bottom: 20px;">
                🚗 Nueva Venta / Renovación
            </a>
            
            <a href="reporte.jsp" class="btn btn-success">
                📊 Consultar Reportes
            </a>
        </div>
        
        <a href="login.jsp" class="btn btn-danger btn-link" style="color: white;">Cerrar Sesión</a>
    </div>
</body>
</html>