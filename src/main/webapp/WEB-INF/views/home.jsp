<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="templates/head.jsp"></jsp:include>
	<title>Agenda online</title>
</head>

<body>
	<jsp:include page="templates/navbar.jsp"></jsp:include>
	<div class="container">
		<ul class="list-group">
			<li class="list-group-item row">
			<span class="col-4 text-left">Personas</span>
			<span class="col-4 text-center"><span class="badge badge-pill badge-primary text-center">${countPersonas}</span></span>
			<span class="col-4 text-right"><a class="btn btn-primary" href="personas"
				role="button">Ir a la lista <i class="fa fa-external-link"></i></a></span>
			</li>
			<li class="list-group-item row">
			<span class="col-4 text-left">Empleados</span>
			<span class="col-4 text-center"><span class="badge badge-pill badge-primary text-center">${countEmpleados}</span></span>
			<span class="col-4 text-right"><a class="btn btn-primary" href="empleados"
				role="button">Ir a la lista <i class="fa fa-external-link"></i></a></span>
			</li>
			<li class="list-group-item row">
			<span class="col-4 text-left">Categorías</span>
			<span class="col-4 text-center"><span class="badge badge-pill badge-primary text-center">${countCategorias}</span></span>
			<span class="col-4 text-right"><a class="btn btn-primary" href="categorias"
				role="button">Ir a la lista <i class="fa fa-external-link"></i></a></span>
			</li>
			<li class="list-group-item row">
			<span class="col-4 text-left">Departamentos</span>
			<span class="col-4 text-center"><span class="badge badge-pill badge-primary text-center">${countDepartamentos}</span></span>
			<span class="col-4 text-right"><a class="btn btn-primary" href="departamentos"
				role="button">Ir a la lista <i class="fa fa-external-link"></i></a></span>
			</li>
		</ul>
	</div>
</body>
</html>