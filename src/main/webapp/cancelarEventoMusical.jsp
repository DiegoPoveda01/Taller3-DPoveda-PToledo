<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cancelar Evento Musical</title>
    <link rel="stylesheet" type="text/css" href="styles1.css">
</head>
<body>

<div id="content">
    <h2>Cancelar Evento Musical</h2>

    <form action="CancelarEventoServlet" method="post">

        <label for="nombreEvento">Nombre del Evento:</label>
        <input type="text" id="nombreEvento" name="nombreEvento" required>

        <br><br>

        <label for="fechaEvento">Fecha del Evento (YYYY-MM-DD):</label>
        <input type="text" id="fechaEvento" name="fechaEvento" pattern="\d{4}-\d{2}-\d{2}" required>
        <!-- El atributo pattern especifica el formato de fecha esperado -->

        <br><br>

        <label for="lugarEvento">Lugar del Evento:</label>
        <input type="text" id="lugarEvento" name="lugarEvento" required>

        <br><br>

        <input type="submit" value="Cancelar Evento Musical">
    </form>

    <br>

    <a href="index.jsp">Volver al Menú Principal</a>
</div>

</body>
</html>
