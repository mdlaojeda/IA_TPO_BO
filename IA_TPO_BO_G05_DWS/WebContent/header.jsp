<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand d-flex align-items-center" href="#"> <img
		src="${pageContext.request.contextPath}/resources/img/menu.svg"
		class="mr-2" width="36" height="36" class="d-inline-block align-top"
		alt=""> BackOffice
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Solicitudes </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=VerSolicitudes">Ver Solicitudes</a>
				</div></li>
				
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Despacho </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=ListarPedidosParaValidar">Listar Pendientes de validaci&oacute;n</a>
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=ListarPedidos">Listar Pendientes de despacho</a>
				</div></li>
				
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Compras </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=ListarOrdenesCompra">Listar
						&Oacute;rdenes</a>

					<div class="dropdown-divider"></div>
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=IngresarOrdenCompra">Ingresar
						Orden</a> <a class="dropdown-item ajax-link"
						href="ActionServlet?action=ValidarOrdenCompra">Validar
						Orden</a>
				</div></li>

		</ul>
		<button id="logout" type="button" class="btn btn-warning"><i class="fas fa-sign-out-alt"></i> Log Out</button>
	</div>
</nav>