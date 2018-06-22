<nav class="navbar navbar-expand-lg navbar-light bg-white">
	<a class="navbar-brand d-flex align-items-center" href="#">
		<i class="fas fa-hotel mr-2"></i> <span class="brand-text">Back Office Tools</span>
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
				aria-expanded="false">Solicitudes</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=VerSolicitudes">Ver Solicitudes</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Servicios</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=VerTiposDeServicio">Ver Tipos de Servicios</a>
					<div class="dropdown-divider"></div> 
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=VerServicios">Ver Servicios</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Logs </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item ajax-link"
						href="ActionServlet?action=VerLogs">Ver Logs</a>
				</div></li>

		</ul>
		<button id="logout" type="button" class="btn btn-warning">
			<i class="fas fa-sign-out-alt"></i> Log Out
		</button>
	</div>
</nav>