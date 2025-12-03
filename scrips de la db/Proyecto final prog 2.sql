CREATE DATABASE IF NOT EXISTS db_marbetes;
USE db_marbetes;

renovacionesmarbetes-- 1. Tabla Vehículos (Requerido: placa, marca, modelo, año, id_propietario, renovado)
CREATE TABLE vehiculos (
    placa VARCHAR(20) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    anio_fabricacion INT NOT NULL,
    identificacion_propietario VARCHAR(20) NOT NULL,
    renovado BOOLEAN DEFAULT FALSE NOT NULL
);

-- 2. Tabla Marbetes (Requerido: secuencia, año inicio/fin, vendido)
CREATE TABLE marbetes (
    secuencia INT PRIMARY KEY,
    anio_inicio_renovacion INT NOT NULL,
    anio_fin_renovacion INT NOT NULL,
    vendido BOOLEAN DEFAULT FALSE NOT NULL
);

-- 3. Tabla Configuraciones (Para los costos y fechas)
CREATE TABLE configuraciones (
    id INT PRIMARY KEY,
    costo_bajo DECIMAL(10,2) NOT NULL,
    costo_alto DECIMAL(10,2) NOT NULL,
    anio_fabricacion_inicia_alto INT NOT NULL,
    fecha_inicio_renovacion DATETIME NOT NULL,
    fecha_fin_renovacion DATETIME NOT NULL
);

-- 4. Tabla Renovaciones (Registro de ventas)
CREATE TABLE renovaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(20) NOT NULL,
    secuencia_marbete INT NOT NULL,
    anio_fabricacion INT NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    vendedor VARCHAR(100),
    fecha_renovacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (placa) REFERENCES vehiculos(placa),
    FOREIGN KEY (secuencia_marbete) REFERENCES marbetes(secuencia),
    UNIQUE(placa, secuencia_marbete)
);

CREATE OR REPLACE VIEW reporte_ventas AS
SELECT 
    DATE(fecha_renovacion) as dia_venta,
    COUNT(CASE WHEN costo = (SELECT costo_bajo FROM configuraciones LIMIT 1) THEN 1 END) as conteo_bajo,
    COUNT(CASE WHEN costo = (SELECT costo_alto FROM configuraciones LIMIT 1) THEN 1 END) as conteo_alto,
    SUM(costo) as costo_total
FROM renovaciones
GROUP BY DATE(fecha_renovacion);

renovaciones

USE db_marbetes;

-- 1. CONFIGURACIÓN (OBLIGATORIO)
-- Reglas: Autos hasta 2019 pagan 1500, desde 2020 pagan 3000.
INSERT INTO configuraciones (id, costo_bajo, costo_alto, anio_fabricacion_inicia_alto, fecha_inicio_renovacion, fecha_fin_renovacion) 
VALUES (1, 1500.00, 3000.00, 2020, '2025-01-01 00:00:00', '2026-01-01 23:59:59');

-- 2. INVENTARIO DE MARBETES (OBLIGATORIO)
-- Debes tener marbetes disponibles (vendido = 0) para poder vender.
INSERT INTO marbetes (secuencia, anio_inicio_renovacion, anio_fin_renovacion, vendido) VALUES 
(1001, 2025, 2026, 0),
(1002, 2025, 2026, 0),
(1003, 2025, 2026, 0);

-- 3. VEHÍCULOS DE PRUEBA
-- Caso A: Auto Viejo (2015) -> Debería pagar $1500
marbetes

-- Caso B: Auto Nuevo (2022) -> Debería pagar $3000
INSERT INTO vehiculos (placa, marca, modelo, anio_fabricacion, identificacion_propietario, renovado) 
VALUES ('X999', 'Tesla', 'Model 3', 2022, '001-9876543-2', 0);

-- Caso C: Auto ya Renovado -> Debería dar error
INSERT INTO vehiculos (placa, marca, modelo, anio_fabricacion, identificacion_propietario, renovado) 
VALUES ('R555', 'Honda', 'Civic', 2018, '001-5555555-5', 1);

ALTER TABLE renovaciones MODIFY id INT AUTO_INCREMENT;


-- NO ejecutar
UPDATE vehiculos
SET renovado = false
WHERE renovado = TRUE;

UPDATE marbetes
SET vendido = FALSE
WHERE vendido = true