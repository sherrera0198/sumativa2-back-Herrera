<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio Categoria</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Inicio</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/usuario">Usuarios</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/producto">Productos</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/categoria">Categoria</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/carrito">Carrito de compras</a>
        </li>
        </ul>
              <form class="d-flex" action="/producto/buscar" method="POST" >
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="palabra" id="palabra">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>

 <div class="container">
 
 <form action="/categoria/insertar" method="POST" >
  <div class="row">
  <h2>Agregar una Categoria</h2>
  </div>
 <br>
 <div class="row">
  <label for="nombre"> Nombre:</label>
	<input type="text" name="nombre" id="nombre" required>
</div>

	<br>

	<br>
<div class="row">
	<input type="submit" class="btn btn-success btn-block mt-3">
</div>
 </form>

 
 </div>
 
 <br>
 <br>
 <div class="container mt-3" >
 	<div class="row">
 		<table class="table table-success responsive">
 			<thead>
 				<tr>
 					<th>ID</th>
 					<th>Categoria</th>
 				</tr>
 			</thead>
 			<tbody> 
 			<c:forEach var="categoria" items="${categorias}" >
 				<tr>
	 				 	<td><c:out value="${categoria.id}" ></c:out></td>
	 					<td><c:out value="${categoria.nombre}" ></c:out></td>
	 				 			
 				</tr>
 				</c:forEach>
 			</tbody>
 		</table>
 			
 	</div>
 
 </div>

</body>
</html>