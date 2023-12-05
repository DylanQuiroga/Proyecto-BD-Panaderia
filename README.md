# Proyecto de Base de Datos I: Panaderia
 
Como proyecto final de la asignatura Base de Datos I, se a creado una aplicación el cual usa PostgreSQL para cargar y guardar los datos.

## Idea del Proyecto

Se realizó una reunión con la dueña de una Panaderia el cual buscaba modernizar su tienda ya que, de momento, todo dato que usa la panaderia tales como el contacto de los proveedores, el registro de las boletas, el inventario, entre otras cosas era anotado en papel. De este modo, se creó un minimundo para posteriormente generar un diagrama ER y un modelo relacional.

![modelo entidad relacion bd - Página 1](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/38727533-f7e5-4a86-8518-e09f610ac08b)
![modelo entidad relacion bd - Modelo relacional final](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/5750d647-44aa-4a42-bde9-59e6eff0c96d)

## Desarrollo de la aplicación

Mediante el uso de NetBeans v17 (También funciona en versiones modernas), JAVA 8, JDK 20 y Python junto con las librerias de pandas y matplotlib se creó una aplicación con interfaz grafica de usuario (GUI) donde se ejecutarán, dependiendo del contexto y el botón, una acción asociada a una consulta al servidor SQL.

## Versión final de la aplicacion

Al iniciar el programa se ejecuta un login el cual verifica que tipo de empleado ha ingresado (administrador, cajero o panadero), para este caso, el administrador tendra acceso a todos los modulos, mientras que el cajero tendra acceso a la venta y el panadero a las recetas.
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/fd59f671-7888-44fe-ba09-b36b9c044d2d)

### Lo que ve el administrador al iniciar sesión:
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/3f679bde-4db1-4ae1-9383-dbdcced9bf8f)

### Lo que ve el cajero al iniciar sesión:
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/5a36586b-b945-4e94-9338-903488ccad4a)

### Lo que ve el panadero al iniciar sesión:
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/b647267c-24ce-4b7a-ae4c-1a48d300a3db)

