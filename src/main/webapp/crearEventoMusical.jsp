<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Evento Musical</title>
    <link rel="stylesheet" type="text/css" href="styles1.css">
</head>
<body>

<div id="content">
    <h2>Crear Evento Musical</h2>

    <form action="CrearEventoServlet" method="post">

        <label for="nombreEvento">Nombre del Evento:</label>
        <input type="text" id="nombreEvento" name="nombreEvento" required>

        <br><br>

        <p>Las fechas deben ingresar con formato AÑO-MES-DÍA (debe ser con guión)
        <p>
        <label for="fechaEvento">Fecha del Evento (YYYY-MM-DD):</label>
        <input type="text" id="fechaEvento" name="fechaEvento" pattern="\d{4}-\d{2}-\d{2}" required>
        <!-- El atributo pattern especifica el formato de fecha esperado -->

        <br><br>

        <label for="lugarEvento">Lugar del Evento:</label>
        <input type="text" id="lugarEvento" name="lugarEvento" required>

        <br><br>

        <!-- Nuevo campo para el nombre del artista -->
        <label for="nombreArtista">Nombre del Artista:</label>
        <input type="text" id="nombreArtista" name="nombreArtista" required>

        <br><br>

        <input type="submit" value="Crear Evento Musical">

    </form>

    <br>

    <a href="index.jsp">Volver al Menú Principal</a>
</div>

</body>
</html>
