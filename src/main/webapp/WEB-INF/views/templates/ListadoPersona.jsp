<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty Persona}">
		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">No hay personas</h1>
				<p>
					<a href="persona/add" class="btn btn-success">Añadir persona</a>
				</p>
			</div>
		</section>
	</c:when>
	<c:otherwise>
		<div class="row">
			<p>
				<a href="persona/add" class="btn btn-success">Añadir persona</a>
			</p>
			<table class="table table-hover">
				<thead class="table-info">
					<tr>
						<th>Nombre</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Persona}" var="persona">
						<tr>
							<th>${persona.nombre}</th>
							<td>
								<a href="persona/edit?id=${persona.idpersonas}"
								class="btn btn-warning">Editar</a>
								<a href="persona/delete?id=${persona.idpersonas}" 
								class="btn btn-danger">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:otherwise>
</c:choose>