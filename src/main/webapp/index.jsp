<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema de Marbetes 2025</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 600px; margin: 0 auto; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
        .mensaje { padding: 10px; margin-bottom: 10px; border-radius: 4px; }
        .error { background-color: #f8d7da; color: #721c24; }
        .exito { background-color: #d4edda; color: #155724; }
        .card { background-color: #f9f9f9; padding: 15px; border: 1px solid #ddd; margin-top: 15px; }
        label { font-weight: bold; display: block; margin-top: 10px; }
        input[type="text"] { width: 100%; padding: 8px; margin-top: 5px; }
        button { background-color: #007bff; color: white; padding: 10px 15px; border: none; cursor: pointer; margin-top: 15px; }
        button:hover { background-color: #0056b3; }
        .btn-vender { background-color: #28a745; width: 100%; font-size: 1.1em; }
        .btn-vender:hover { background-color: #218838; }
    </style>
</head>
<body>

<div class="container">
    <h2>Venta de Marbetes</h2>

    <c:if test="${not empty mensaje}">
        <div class="mensaje error">${mensaje}</div>
    </c:if>
    <c:if test="${not empty mensajeExito}">
        <div class="mensaje exito">${mensajeExito}</div>
    </c:if>

    <form action="RenovacionServlet" method="post">
        <input type="hidden" name="accion" value="buscar">
        <label for="placa">Ingrese Placa del Vehículo:</label>
        <input type="text" id="placa" name="placa" placeholder="Ej. A123456" required>
        <button type="submit">Buscar Vehículo</button>
    </form>

    <c:if test="${not empty vehiculoEncontrado}">
        <div class="card">
            <h3>Detalles del Vehículo</h3>
            <p><strong>Placa:</strong> ${vehiculoEncontrado.placa}</p>
            <p><strong>Marca:</strong> ${vehiculoEncontrado.marca}</p>
            <p><strong>Modelo:</strong> ${vehiculoEncontrado.modelo}</p>
            <p><strong>Año:</strong> ${vehiculoEncontrado.anio_fabricacion}</p>
            <p><strong>Propietario ID:</strong> ${vehiculoEncontrado.identificacion_propietario}</p>
            
            <hr>
            
            <h3>Costo de Renovación</h3>
            <p style="font-size: 1.5em; color: #333;">
                RD$ ${costoCalculado}
            </p>

            <form action="RenovacionServlet" method="post">
                <input type="hidden" name="accion" value="procesar">
                <input type="hidden" name="placaConfirmada" value="${vehiculoEncontrado.placa}">
                
                <button type="submit" class="btn-vender">CONFIRMAR VENTA Y ASIGNAR MARBETE</button>
            </form>
        </div>
    </c:if>
</div>

<br><br>
<div style="text-align: center;">
    <a href="menu.jsp" style="text-decoration: none; color: #007bff; font-weight: bold;">🏠 Volver al Menú Principal</a>
</div>

</body>
</html>