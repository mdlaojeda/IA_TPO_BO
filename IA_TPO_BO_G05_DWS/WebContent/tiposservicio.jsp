<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.backoffice.dto.TipoServicioDTO"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>

<article class="container grid col-12 col-md-10 mt-2">
	<div class="d-flex row col-12"><h1>Listado de Tipos de Servicio</h1>
	<button id="btnNuevoTipoServicio" type="button" class="btn btn-warning ml-auto"><i class="fas fa-plus"></i> Agregar Nuevo</button>
	</div>
	<section class="row col-12 seleccionar-articulos mt-4 mb-4">
		<table class="table table-striped table-light text-dark table-sm">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Tipo de Servicio</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
					ObjectMapper mapper = new ObjectMapper();
					List<TipoServicioDTO> tsDTOlist = (List<TipoServicioDTO>) request.getAttribute("tiposservicio");
					TipoServicioDTO aux;
					
					for (Iterator<TipoServicioDTO> i = tsDTOlist.iterator(); i.hasNext();) {
						aux = i.next();
				%>
				<tr>
					<th scope="row"><%=aux.getNroTipoServicio()%></th>
					<td><%=aux.getDescripcion()%></td>
					<td><button class="btn btn-sm btn-warning btn-detalle"
							data-tiposervicio='<%=mapper.writeValueAsString(aux)%>'>
							<i class="fas fa-edit"></i> Editar
						</button>						
						<button class="btn btn-sm btn-danger btn-borrar"
							data-nrotiposervicio="<%=aux.getNroTipoServicio()%>">
							<i class="fas fa-trash-alt"></i> Borrar
						</button></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</section>
</article>

<!--  Modal Editar Servicio  -->
<div class="modal fade" id="modalDetalle" tabindex="-1" role="dialog"
	aria-labelledby="modalDetalleLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content text-dark">
			<div class="modal-header">
				<h5 class="modal-title" id="modalDetalleLabel">Editar Tipo de Servicio</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="editarservicio">
					<div class="form-row">
						<div class="col-md-4 mb-2">
							<label for="nroTipoServicio">NRO</label> <input readonly type="text"
								class="form-control" id="editNroTipoServicio" placeholder="Nro. Tipo de Servicio" value="" />
						</div>
						<div class="col-md-8 mb-2">
							<label for="descripcion">Descripci&oacute;n</label> <input type="text"
								class="form-control" id="editDescripcion" placeholder="Ingrese descripción..."
								value="" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" id="btnEditarTipoServicio"><i class="fas fa-check-circle"></i> Editar</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-ban"></i> Cancelar</button>
			</div>
		</div>
	</div>
</div>
<!--  Modal Nuevo Tipo de Servicio  -->
<div class="modal fade" id="modalNuevoTipoServicio" tabindex="-1" role="dialog"
	aria-labelledby="modalNuevoTipoServicioLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content text-dark">
			<div class="modal-header">
				<h5 class="modal-title" id="modalNuevoTipoServicioLabel">Agregar Tipo de Servicio</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="agregartiposervicio">
					<div class="form-row">
						<div class="col-md-12 mb-2">
							<label for="descripcion">Descripci&oacute;n</label> <input type="text"
								class="form-control" id="descripcion" placeholder="Ingrese descripción..."
								value="" />
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" id="btnAgregarTipoServicio"><i class="fas fa-check-circle"></i> Agregar Tipo de Servicio</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-ban"></i> Cancelar</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/tiposservicio.js"></script>
