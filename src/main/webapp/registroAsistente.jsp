<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Registro de Asistentes</title>
  <link rel="stylesheet" type="text/css" href="styles1.css">
</head>
<body>

<div id="content">
  <h2>Registro de Asistentes</h2>

  <form action="RegistrarAsistenteServlet" method="post">

    <label for="numeroContacto">Número de Contacto:</label>
    <input type="text" id="numeroContacto" name="numeroContacto" required>

    <br><br>

    <label for="preferenciaMusical">Preferencia Musical:</label>
    <input type="text" id="preferenciaMusical" name="preferenciaMusical" required>

    <br><br>

    <input type="submit" value="Registrar Asistente">
  </form>

  <br>

  <a href="index.jsp">Volver al Menú Principal</a>
</div>

</body>
</html>
