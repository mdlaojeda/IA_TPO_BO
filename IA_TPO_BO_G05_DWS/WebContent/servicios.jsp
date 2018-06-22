<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.backoffice.dto.ServicioDTO"%>
<%@ page import="com.backoffice.dto.TipoServicioDTO"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>

<article class="container grid col-12 col-md-10 mt-2">
	<div class="d-inline-flex row"><h1 class="mr-2">Listado de Servicios</h1>
	<button id="btnNuevoServicio" type="button" class="btn btn-warning m-2"><i class="fas fa-plus"></i> Agregar Nuevo</button>
	</div>
	<section class="row col-12 seleccionar-articulos mt-4 mb-4">
		<table class="table table-striped table-light text-dark">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Tipo</th>
					<th scope="col">Servicio</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
					ObjectMapper mapper = new ObjectMapper();
					List<ServicioDTO> sDTOlist = (List<ServicioDTO>) request.getAttribute("servicios");
					List<TipoServicioDTO> tsDTOlist = (List<TipoServicioDTO>) request.getAttribute("tiposservicio");	
					
					ServicioDTO aux;
					TipoServicioDTO tsaux;
					
					for (Iterator<ServicioDTO> i = sDTOlist.iterator(); i.hasNext();) {
						aux = i.next();
				%>
				<tr class="pedido-row">
					<th scope="row"><%=aux.getNroServicio()%></th>
					<td><%=aux.getTipoServicio().getDescripcion()%></td>
					<td><%=aux.getDescripcion()%></td>
					<td><button class="btn btn-sm btn-warning btn-detalle"
							data-servicio='<%=mapper.writeValueAsString(aux)%>'>
							<i class="fas fa-edit"></i> Editar
						</button>
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
				<h5 class="modal-title" id="modalDetalleLabel">Editar Servicio</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="editarservicio">
					<div class="form-row">
						<div class="col-md-4 mb-2">
							<label for="nroServicio">NRO</label> <input readonly type="text"
								class="form-control" id="editNroServicio" placeholder="Nro. Servicio" value="" />
						</div>
						<div class="col-md-8 mb-2">
							<label for="descripcion">Descripci&oacute;n</label> <input type="text"
								class="form-control" id="editDescripcion" placeholder="Ingrese descripción..."
								value="" />
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							 <div class="form-group">
							    <label for="editTipoServicio">Tipo de Servicio</label>
							    <select class="form-control" id="editTipoServicio">
							    <%
								for (Iterator<TipoServicioDTO> i = tsDTOlist.iterator(); i.hasNext();) {
									tsaux = i.next();
							    %>
							      <option value="<%=tsaux.getNroTipoServicio()%>" data-tipo='<%= mapper.writeValueAsString(tsaux)%>'><%=tsaux.getDescripcion()%></option>
								<%
									}
								%>
							    </select>
							  </div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" id="btnEditarServicio"><i class="fas fa-check-circle"></i> Editar</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-ban"></i> Cancelar</button>
			</div>
		</div>
	</div>
</div>
<!--  Modal Nuevo Servicio  -->
<div class="modal fade" id="modalNuevoServicio" tabindex="-1" role="dialog"
	aria-labelledby="modalNuevoServicioLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content text-dark">
			<div class="modal-header">
				<h5 class="modal-title" id="modalNuevoServicioLabel">Agregar Servicio</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="agregarservicio">
					<div class="form-row">
						<div class="col-md-12 mb-2">
							<label for="descripcion">Descripci&oacute;n</label> <input type="text"
								class="form-control" id="descripcion" placeholder="Ingrese descripción..."
								value="" />
						</div>
					</div>
					<div class="form-row">
						<div class="col-md-12 mb-3">
							 <div class="form-group">
							    <label for="tipoServicio">Tipo de Servicio</label>
							    <select class="form-control" id="tipoServicio">
							    <%
								for (Iterator<TipoServicioDTO> i = tsDTOlist.iterator(); i.hasNext();) {
									tsaux = i.next();
							    %>
							      <option value="<%=tsaux.getNroTipoServicio()%>" data-tipo='<%= mapper.writeValueAsString(tsaux)%>'><%=tsaux.getDescripcion()%></option>
								<%
									}
								%>
							    </select>
							  </div>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-warning" id="btnAgregarServicio"><i class="fas fa-check-circle"></i> Agregar Servicio</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-ban"></i> Cancelar</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/servicios.js"></script>
