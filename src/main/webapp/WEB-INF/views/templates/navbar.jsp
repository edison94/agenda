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
			<li class="nav-item"><a class="nav-link" href="/agenda">Inicio</a></li>
			<li class="nav-item"><a class="nav-link" href="/agenda/personas">Personas</a></li>
			<li class="nav-item"><a class="nav-link" href="/agenda/empleados">Empleados</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false">Back Office</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
					<a class="dropdown-item" href="/agenda/categorias">Categorías</a>
					<a class="dropdown-item" href="/agenda/departamentos">Departamentos</a>
				</div></li>
		</ul>

		<form id="buscador" class="form-inline my-2 my-lg-0" action="buscar"
			method="get">
			<select id="sujeto" class="custom-select mb-2 mr-sm-2 mb-sm-0"
				name="sujeto">
				<option value="empleado">Empleado</option>
				<option selected value="persona">Persona</option>
			</select> <select id="criterio" class="custom-select mb-2 mr-sm-2 mb-sm-0"
				name="criterio">
				<option value="Dirección">Dirección</option>
				<option value="Nombre">Nombre</option>
				<option value="Teléfono">Teléfono</option>
			</select> <input class="form-control mr-sm-2" type="text" name="texto">
			<input type="submit" class="btn btn-info" value="Buscar">
		</form>
	</div>
</nav>

<div class="modal" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Error</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
			</div>
		</div>
	</div>
</div>