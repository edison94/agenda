<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty Empleado}">
		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">No hay empleados</h1>
				<p>
					<a href="empleado/add" class="btn btn-success">Añadir empleado</a>
				</p>
			</div>
		</section>
	</c:when>
	<c:otherwise>
		<div class="row">
			<p>
				<a href="empleado/add" class="btn btn-success">Añadir empleado</a>
			</p>
			<table class="table table-hover">
				<thead class="table-info">
					<tr>
						<th>CodigoEmpleado</th>
						<th>Salario</th>
						<th>FechaAlta</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Empleados}" var="empleado">
						<tr>
							<th>${empleado.nombre}</th>
							<td>
								<a href="empleado/edit?id=${empleado.idempleados}"
								class="btn btn-warning">Editar</a>
								<a href="empleado/delete?id=${empleado.idempleados}" 
								class="btn btn-danger">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:otherwise>
</c:choose>