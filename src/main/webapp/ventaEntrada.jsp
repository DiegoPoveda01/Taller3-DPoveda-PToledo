<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Venta de Entradas</title>
  <link rel="stylesheet" type="text/css" href="estilosVentas.css">
</head>
<body>

<div id="content">
  <h2>Venta de Entradas</h2>

  <form action="VenderEntradaServlet" method="post">

    <label for="tipoEntrada">Tipo de Entrada:</label>
    <select id="tipoEntrada" name="tipoEntrada" required>
      <option value="vip">VIP</option>
      <option value="general">General</option>
    </select>

    <br><br>

    <label for="precio">Precio:</label>
    <input type="text" id="precio" name="precio" required>

    <br><br>

    <label for="disponibilidad">Disponibilidad:</label>
    <input type="number" id="disponibilidad" name="disponibilidad" required>

    <br><br>

    <input type="submit" value="Vender Entrada">
  </form>

  <br>

  <a href="index.jsp">Volver al Menú Principal</a>
</div>

</body>
</html>
