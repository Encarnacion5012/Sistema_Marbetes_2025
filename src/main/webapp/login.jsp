<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceso - Sistema DIGESETT</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="card-container">
        <img src="images/images.jpg" alt="Logo DIGESETT" class="logo-img">
        
        <h2>Acceso al Sistema de Marbetes</h2>
        
        <form action="LoginServlet" method="post">
            <div style="text-align: left;">
                <label for="user">Usuario Institucional</label>
                <input type="text" id="user" name="usuario" placeholder="Ej. a.dominguez" required autofocus>
                
                <label for="pass">Contraseña</label>
                <input type="password" id="pass" name="password" placeholder="••••••">
            </div>
            
            <button type="submit" class="btn btn-primary">Ingresar de forma segura</button>
        </form>
        
        <p style="margin-top: 30px; color: #888; font-size: 0.9em;">
            Departamento de Tecnología DIGESETT © 2025
        </p>
    </div>
</body>
</html>