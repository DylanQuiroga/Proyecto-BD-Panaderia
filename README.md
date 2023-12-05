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

#### Lo que ve el administrador al iniciar sesión:
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/3f679bde-4db1-4ae1-9383-dbdcced9bf8f)

#### Lo que ve el cajero al iniciar sesión:
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/5a36586b-b945-4e94-9338-903488ccad4a)

#### Lo que ve el panadero al iniciar sesión:
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/b647267c-24ce-4b7a-ae4c-1a48d300a3db)

## Modulo de Venta

En este modulo se cargan los productos que posee el locar, al seleccionar un elemento de la lista se carga el precio del producto y al darle click al boton de "Agregar" se resta la cantidad puesta a la base de datos y se agrega a la tabla el producto. Si se desea eliminar un producto de la lista, primero se tiene que seleccionar y despues apretar el boton de "Eliminar producto seleccionado", esto hace que se elimine el producto de la lista y se agrega a la base de datos la cantidad restada.
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/a672dacc-44ba-433d-bdb9-8f1c8e2129d5)

Luego si precionamos el boton de "Generar boleta" nos genera una boleta donde podemos guardarla en el PC (se guarda automaticamente en el escritorio con el nombre de boleta + la fecha y hora actual) o guardarla en la base de datos.
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/d8c0e124-e4bd-42b6-b3f0-6eb9cdcb05f5)

## Modulo de Recetas

En este modulo se tendremos el nombre de la receta junto con una descripción del producto que genera la receta, si seleccionamos un producto de la tabla, en la parte de abajo saldrán los ingredientes con lo que se fabrica.
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/43d6db51-d3bc-4ce6-bfaa-f094c292e2e6)
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/e36e8f13-b783-458f-aaf0-acfaa1a7ea2e)

Además, podremos agregar, modificar o eliminar una receta

Para el caso de Añadir, podemos ingresasr el nombre de la receta, agregar una descripción, introducir los ingredientes para despues agregarlos a la base de datos.
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/7a29e3eb-7a07-42cc-815e-709ecba615e4)

Para Modificar, primero seleccionamos una receta y después precionamos el botón, aqui se desplegará el nombre de la receta, su descripción y los ingredientes.
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/5d73bd28-c32a-44ac-a03f-9b9f5a817576)

Por ultimo tenemos el botón de eliminar, al igual que con modificar, primero seleccionamos una receta y despues precionamos el botón, esto eliminará la receta de la base de datos.

## Modulo de proveedores

Aqui se muestra el contacto de los proveedores
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/f5519a6a-5f31-4e69-a540-76fd064d2426)

## Modulo de Insumos disponibles

En este modulo se muestran los insumos que son usados para crear distintos productos para el local
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/b1714f5c-f355-4cac-93cb-d5228a38be66)

## Modulo productos del local

Aca se muestran los productos que posee el local, se puede seleccionar una receta, asignar un stock y se realizan calculos para ver si se puede fabricar dicho producto con los insumos disponibles
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/f2c4f75e-7ba2-425f-ac19-ed5446ff24ff)

## Modulo de Pedidos

Aqui se muestran los pedidos que se le realizan a X proveedor. Podemos buscar por el nombre del proveedor, por nombre del insumo o por fecha, además, podemos agregar un pedido, calcular los gastos mensuales o gastos anuales
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/f06dfb01-fb41-4818-8eb3-6d5baafae347)
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/72a350e9-0675-48c0-bc32-ceef3a902dae)

Los gastos mensuales
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/c9eb6a22-217f-423d-8251-19fdf2a348cb)

Los gastos anuales
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/9991c291-de9b-4453-b1c6-daa4fd89c4c4)

## Modulo de boleta

En este modulo podemos ver las ventas que se han realizado, podemos ordenar la tabla por dia, mes, año y cantidad generada y podemos graficar 
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/f1026a6e-fd1a-41ac-a6be-7ab29086b74a)
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/e1c51f0f-bcf1-4f19-a889-d12c3ff40ed3)

Como mencioné al principio, tambien se usó Python con las librerias de pandas y matplotlib para poder graficar, el truco esta en llamar al archivo .py con JAVA, esperar a que el archivo .py termine y luego se muestra en una ventana la imagen generada. Se intentó usar jfreechart, una libreria para graficar con JAVA, pero este no nos funcionó y decidimos mejor usar Python para graficar

Un ejemplo de lo que muestra si se selecciona "Cantidad generada por cada empleado"
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/1885b3dd-0df3-49f6-83fb-c52fec30af5c)

## Modulo de Empleados

En este apartado se encuentran los datos de los empleados, podemos añadir, eliminar o modificar los datos de un empleado.
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/68103655-bba1-4a47-861c-734e4a931ac3)

Ventana para añadir empleado
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/e216c040-9854-4b1d-8bbe-0f72de74683c)

Ventana para modificar empleado
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/cf62389f-4f5a-42a4-9c5c-12eb1026964d)

Para eliminar un empleado, debemos seleccionar uno de la tabla y luego presionamos el botón de "Eliminar". En realidad, no elimina al empleado, solo lo mantiene inactivo para que no afecte a los datos de la boleta
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/31e19769-28bd-438f-9a77-7bdcc1b47c7c)

# Cosas a mejorar

* Una de las cosas que se podria mejorar es la misma base de datos, construirla con más detalle y pensar mejor los atributos.
* Hacer la interfaz de usuario más amigable.
* Optimizar las consultas (Por ejemplo, hacer una sola consulta para el login que 3 consultas en un if-else)

# Creditos

## Dylan Quiroga

Encargado del Login, modulo de opciones, modulo de empleados, modulo de venta y del modulo de boleta, además de generar algunas tablas en la base de datos
https://github.com/DylanQuiroga
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/baa4a93a-a404-4368-853a-64db85c00b31)

## Vicente Muñoz

Encargado del modulo de recetas y de implementar tablas y datos en la base de datos
https://github.com/vema17
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/3d66a335-b43a-4c64-ab51-298cb839b93b)

## José Pizarro

Encargado del modulo de insumos y productos del local, además, creó tablas y 4 mil datos para la base de datos (Casi se cae el programa en plena presentación por el mal internet jeje)
https://github.com/Josepizarro14
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/c6354dce-daaf-454a-b4c0-808e6a009d39)

## Ethan Pimentel

Encargado del modulo de proveedores y pedidos, también creo tablas y datos para la base de datos
https://github.com/EthanPimentel
![image](https://github.com/DylanQuiroga/Proyecto-BD-Panaderia/assets/88744341/21a36c80-8c62-4559-a0d7-aaebf26b3ba0)

