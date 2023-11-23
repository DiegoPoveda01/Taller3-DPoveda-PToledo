Realización Taller 3
Diego Poveda
Paulo Toledo

Descripción de la problemática:

La app web se puede modelar haciendo uso del patron MVC más el patrón DAO.

identificando estos paquetes esenciales, podemos pasar a la descripción de las clases.

todo esto se puede hacer en base a las funcionalidades solicitadas.

las funcionalidades son:
-Creación de eventos musicales con nombre, fecha y lugar.
-Cancelación de eventos musicales.
-Registro de artistas.
-Registro de asistentes.
-Venta de entradas.

A partir de estas funcionalidades se distinguen 4 clases esenciales para el modelo: Evento Musical, Artista, Asistente y Entrada.

Por lo cual esas 4 clases deben estar construidas en el modelo.
En cuanto a la conexión con base de datos, tenemos la clase para crear y otra para generar la conexión.
En cuanto a las clases dao, se hace una clase dao por cada objeto del modelo a gestionar, de manera que son 4 clasesDAO, (Evento Musical, Artista, Asistente y Entrada.)

En el controlador se hace necesario un servlet por cada funcionalidad, por lo tanto se requiere un servlet para agregar asistente, otro para crear eventos, uno para eliminar evento y finalmente uno para vender la entrada, cada uno con sus respectiva lógica de programación, y sus validaciones.

Vistas (JSP)

se ha propuesto crear un menú (index.jsp) que muestre todas las funcionalidades de la app web principales, tales como las mencionadas anteriormente.
y por cada funcionalidad un respectivo jsp para mostrar la página e ingresar la información necesaria para un registro o evento o compra.
Con jsp(s) adicionales que se muestran cuando el registro o la compra se ha hecho correctamente o simplemente no se puede hacer porque el registro ya existe o la compra ya fue hecha.

Toda la solución y análisis de la problemática se hace con el uso del patrón MVC más el patrón DAO.

