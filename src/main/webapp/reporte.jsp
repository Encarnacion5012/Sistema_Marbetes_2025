<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reporte de Recaudaciones</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 800px; margin: 0 auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .filtros { background-color: #f9f9f9; padding: 15px; border-radius: 5px; border: 1px solid #ccc; }
        .btn-buscar { background-color: #28a745; color: white; padding: 8px 15px; border: none; cursor: pointer; }
        .btn-volver { display: inline-block; margin-top: 20px; text-decoration: none; color: #007bff; }
    </style>
</head>
<body>
<div class="container">
    <h2>Reporte de Ventas por Fecha</h2>
    
    <div class="filtros">
        <form action="ReporteServlet" method="post">
            <label>Desde: <input type="date" name="fechaInicio" required></label>
            <label>Hasta: <input type="date" name="fechaFin" required></label>
            <button type="submit" class="btn-buscar">Generar Reporte</button>
        </form>
    </div>

<c:if test="${not empty listaVentas}">
        <table>
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Vendedor</th> <th>Placa</th>
                    <th>Marbete Asignado</th>
                    <th>Costo</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="venta" items="${listaVentas}">
                    <tr>
                        <td>${venta.fecha_renovacion}</td>
                        <td><strong>${venta.vendedor}</strong></td>
                        <td>${venta.vehiculo.placa}</td> <td>${venta.marbete.secuencia}</td> <td>RD$ ${venta.costo}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty listaVentas and not empty param.fechaInicio}">
        <p style="text-align:center; color: red;">No se encontraron ventas en este rango.</p>
    </c:if>
    
    

    <br>
    <a href="index.jsp" class="btn-volver">← Volver a Venta de Marbetes</a>
</div>

<br><br>
<div style="text-align: center;">
    <a href="menu.jsp" style="text-decoration: none; color: #007bff; font-weight: bold;">🏠 Volver al Menú Principal</a>
</div>
</body>
</html>