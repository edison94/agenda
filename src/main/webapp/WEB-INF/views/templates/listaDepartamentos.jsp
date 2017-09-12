<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${empty departamentos}">
		<section class="jumbotron text-center">
			<div class="container">
				<h1 class="jumbotron-heading">No hay departamentos</h1>
				<p>
					<a href="departamentos/add" class="btn btn-success">Añadir departamento</a>
				</p>
			</div>
		</section>
	</c:when>
	<c:otherwise>
		<div class="row">
			<p>
				<a href="departamentos/add" class="btn btn-success">Añadir departamento</a>
			</p>
			<table class="table table-hover">
				<thead class="table-info">
					<tr>
						<th>Nombre</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${departamentos}" var="departamento">
						<tr>
							<th>${departamento.nombre}</th>
							<td>
								<a href="departamentos/edit?id=${departamento.iddepartamento}"
								class="btn btn-warning">Editar</a>
								<a href="departamentos/delete?id=${departamento.iddepartamento}" 
								class="btn btn-danger">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:otherwise>
</c:choose>