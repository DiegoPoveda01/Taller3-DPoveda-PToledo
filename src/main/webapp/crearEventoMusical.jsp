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

        <label for="fechaEvento">Fecha del Evento:</label>
        <input type="date" id="fechaEvento" name="fechaEvento" required>

        <br><br>

        <label for="lugarEvento">Lugar del Evento:</label>
        <input type="text" id="lugarEvento" name="lugarEvento" required>

        <br><br>

        <input type="submit" value="Crear Evento Musical">
    </form>

    <br>

    <a href="index.jsp">Volver al Menú Principal</a>
</div>

</body>
</html>
