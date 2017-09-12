<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty telefonos}">
		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">No hay telefonos</h1>
				<p>
					<a href="telefono/add" class="btn btn-success">Añadir teléfono</a>
				</p>
			</div>
		</section>
	</c:when>
	<c:otherwise>
		<div class="row">
			<p>
				<a href="telefono/add" class="btn btn-success">Añadir teléfono</a>
			</p>
			<table class="table table-hover">
				<thead class="table-info">
					<tr>
						<th>NumeroTeléfono</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${telefonos}" var="telefono">
						<tr>
							<th>${telefono.telefono}</th>
							<td>
								<a href="telefono/edit?id=${telefono.idtelefonos}"
								class="btn btn-warning">Editar</a>
								<a href="telefono/delete?id=${telefono.idtelefonos}" 
								class="btn btn-danger">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:otherwise>
</c:choose>