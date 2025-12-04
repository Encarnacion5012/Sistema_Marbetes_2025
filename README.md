<H1>Sistema de Gestión de Venta de Marbetes</H1>

* Proyecto Final - Lenguajes de Programación 2
* Universidad: UNICDA
* Fecha: 04 Diciembre 2025
<H2> Integrantes:</H2>
* Cristopher Genao 2024-0116
* EstainlinEncarnacion 2024-0181
* Yansell Rosario 2024-0090


<h2> Descripción</h2>
Aplicación web desarrollada en Java para gestionar el proceso de renovación y venta de marbetes vehiculares.
El sistema permite buscar vehículos por placa, calcular automáticamente el costo del impuesto basado en el año de fabricación (reglas de negocio 2025-2026) y generar reportes de recaudación detallados.

<H2> Características Principales:</H2>

1. Login Institucional: Acceso simulado mediante sesión HTTP.
Venta de Marbetes: Búsqueda de vehículos en tiempo real.
    * Cálculo automático de costos (Costo bajo para años < 2020, Costo alto para >= 2020).
    * Asignación secuencial de números de marbete.
    * Validación de vehículos ya renovados.
2. Reportes: Listado detallado de ventas filtrado por rango de fechas, mostrando el vendedor responsable.
3. Manejo de Errores: Control de excepciones amigable para el usuario (evita pantallas de error 500).
    
---

<h2>Tecnologías Utilizadas</h2>

* Lenguaje: Java 17 (JDK 17)
* Servidor de Aplicaciones: Eclipse Jetty (vía Maven Plugin)
* Base de Datos: MariaDB / MySQL
* ORM: EclipseLink (JPA 2.2)
* Frontend: JSP, JSTL, CSS3
* Gestor de Dependencias: Apache Maven
* Conexión: Pool de conexiones JNDI (Commons DBCP2)

---

<H2> Instrucciones de Instalación y Ejecución </H2>

<H3>Sigue estos pasos para desplegar el proyecto en tu máquina local.</H3>

<H4> 1. Prerrequisitos</H4>

* Tener instalado **Java JDK 17** o superior.
* Tener instalado **Maven**.
* Tener un servidor de base de datos **MariaDB** o **MySQL** corriendo.

<H4> 2. Configuración de la Base de Datos </H4>
El proyecto incluye el script necesario para crear la estructura y los datos de prueba.

1.  Ve a la carpeta `/scrips de la db` de este repositorio.
2.  Abre el archivo `Proyecto final prog 2.sql` en tu gestor de BD (HeidiSQL, DBeaver, Workbench).
3.  Ejecuta todo el script para crear la base de datos `db_marbetes` y las tablas necesarias.

<H4> 3. Configuración de Conexión (Importante) </H4>
El proyecto utiliza un Pool de Conexiones configurado en Jetty.
Si tu base de datos tiene contraseña o usa un puerto diferente al 3306 (ej. 3307), edita el archivo:
`src/main/webapp/WEB-INF/jetty-env.xml`

```xml
<Set name="url">jdbc:mariadb://localhost:3306/db_marbetes</Set>
<Set name="username">root</Set>
<Set name="password">TU_CONTRASEÑA</Set>
