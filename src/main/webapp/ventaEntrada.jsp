<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Venta de Entradas</title>
  <link rel="stylesheet" type="text/css" href="estilosVentas.css">
  <style>
    /* Estilos adicionales para centrar el botón */
    #content {
      text-align: center;
    }

    #ventaEntradaBtn {
      margin-top: 20px; /* Espacio superior para separar del formulario */
    }
  </style>
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

    <!-- Contenedor para centrar el botón -->
    <div id="ventaEntradaBtn">
      <input type="submit" value="Vender Entrada">
    </div>
  </form>

  <br>

  <a href="index.jsp">Volver al Menú Principal</a>
</div>

</body>
</html>
