<nav
	class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarsExampleDefault"
		aria-controls="navbarsExampleDefault" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="/agenda">Agenda</a>

	<div class="collapse navbar-collapse" id="navbarsExampleDefault">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link"
				href="/agenda">Inicio</a></li>
			<li class="nav-item"><a class="nav-link"
				href="personas">Personas</a></li>
			<li class="nav-item"><a class="nav-link"
				href="empleados">Empleados</a></li>
			<li class="nav-item"><a class="nav-link"
				href="categorias">Categorias</a></li>
			<li class="nav-item"><a class="nav-link"
				href="departamentos">Departamentos</a></li>
		</ul>
		
		<form id="buscador" class="form-inline my-2 my-lg-0" action="buscar" method="get">
			<select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="sujeto">
				<option selected value="empleado">Empleado</option>
				<option value="persona">Persona</option>
			</select>
			<select class="custom-select mb-2 mr-sm-2 mb-sm-0" name="criterio">
				<option selected value="categoria">Categoria</option>
				<option value="departamento">Departamento</option>
			</select>
			<input class="form-control mr-sm-2" type="text" name="texto" >
			<input type="submit" class="btn btn-info" value="Buscar">
		</form>
	</div>
</nav>