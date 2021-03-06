<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.backoffice.dto.SolicitudDTO"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>

<article class="container grid col-12 col-md-10 mt-2">
	<div class="d-flex row col-12"><h1>Listado de Solicitudes</h1>
	<button id="btnLimpiarSolicitudes" type="button" class="btn btn-danger ml-auto"><i class="fas fa-trash-alt"></i> Limpiar Solicitudes</button>
	</div>
	<section class="row col-12 seleccionar-articulos mt-4 mb-4">
		<table class="table table-striped table-light text-dark table-sm">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Tipo</th>
					<th scope="col">Estado</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<SolicitudDTO> sDTOlist = (List<SolicitudDTO>) request.getAttribute("solicitudes");
					SolicitudDTO aux;
					ObjectMapper mapper = new ObjectMapper();
					for (Iterator<SolicitudDTO> i = sDTOlist.iterator(); i.hasNext();) {
						aux = i.next();
				%>
				<tr class="tr--<%=aux.getEstado().toString().toLowerCase()%>">
					<th scope="row"><%=aux.getIdSolicitud()%></th>
					<td><%=aux.getTipo()%></td>
					<td><span class="medalla-estado"><%=aux.getEstado()%></span></td>
					<td><button class="btn btn-sm btn-warning btn-detalle"
							data-solicitud='<%=mapper.writeValueAsString(aux)%>'>
							<i class="fas fa-info-circle"></i> Ver Detalle
						</button></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</section>
</article>
<div class="modal fade" id="modalDetalle" tabindex="-1" role="dialog"
	aria-labelledby="modalDetalleLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content text-dark">
			<div class="modal-header">
				<h5 class="modal-title" id="modalDetalleLabel">Detalles de
					Solicitud</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-row">
						<div class="col-md-2 mb-2">
							<label for="idSolicitud">ID</label> <input readonly type="text"
								class="form-control" id="idSolicitud" placeholder="ID" value="" />
						</div>
						<div class="col-md-10 mb-2">
							<label for="codEntidad">C&oacute;digo</label> <input readonly type="text"
								class="form-control" id="codEntidad" placeholder="C�digo"
								value="" />
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-12 mb-2">
							<label for="nombre">Nombre</label> <input readonly type="text"
								class="form-control" id="nombre" placeholder="Nombre" value="" />
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							<label for="direccion">Direcci&oacute;n</label> <input readonly
								type="text" class="form-control" id="direccion"
								placeholder="Direcci�n" value="">
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-6 mb-3">
							<label for="tipo">Tipo</label> <input readonly type="text"
								class="form-control" id="tipo" placeholder="Tipo" value="" />
						</div>
						<div class="col-md-6 mb-3">
							<label for="estado">Estado</label> <input readonly type="text"
								class="form-control" id="estado" placeholder="Estado" value="" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" id="aprobarSolicitud"><i class="fas fa-check-circle"></i> Aprobar</button>
				<button type="button" class="btn btn-danger"
					id="desaprobarSolicitud"><i class="fas fa-times-circle"></i> Desaprobar</button>
				<button type="button" class="btn btn-warning" data-dismiss="modal"><i class="fas fa-ban"></i> Cancelar</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/solicitudes.js"></script>
