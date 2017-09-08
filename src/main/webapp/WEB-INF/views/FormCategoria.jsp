<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<spring:url value="/resources/css/estilos.css" var="estilos" />
<link href="${estilos}" rel="stylesheet" />
<title>SpringAgenda  - FormCategoria</title>
</head>
<body>

	<div id="contenedor">
		<h2>
			SpringAgenda - Form1 <br />(Anotac + Model&View +
			Model + RequestMapping)
		</h2>
		
		<form:form method="post" modelAttribute="categoria"
			action="addcategoria.htm">
			<table>
				<tr>
					<td><form:label path="nombre">Nombre categoria</form:label></td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td><form:label path="descripcion">Descripcion categoria</form:label></td>
					<td><form:input path="descripcion" /></td>
				</tr>
				
			</table>
			<br />
			<p>
				<input type="submit" value="Dime la categoria" />
			</p>
		</form:form>
	</div>
</body>
</html>
