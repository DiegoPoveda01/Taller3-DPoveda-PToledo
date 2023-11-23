<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Artistas</title>
    <link rel="stylesheet" type="text/css" href="styles1.css">
</head>
<body>

<div id="content">
    <h2>Registro de Artistas</h2>

    <form action="RegistrarArtistaServlet" method="post">

        <label for="nombreArtistico">Nombre Artístico:</label>
        <input type="text" id="nombreArtistico" name="nombreArtistico" required>

        <br><br>

        <label for="generoMusical">Género Musical:</label>
        <input type="text" id="generoMusical" name="generoMusical" required>

        <br><br>

        <input type="submit" value="Registrar Artista">
    </form>

    <br>

    <a href="index.jsp">Volver al Menú Principal</a>
</div>

</body>
</html>
