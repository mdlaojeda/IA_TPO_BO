<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.backoffice.dto.LogDTO"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>

<article class="container grid col-12 col-md-10 mt-2">
	<h1>Reporte de Logs</h1>
	<section class="row col-12 seleccionar-articulos mt-4 mb-4">
		<table class="table table-striped table-light text-dark table-sm">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">M&oacute;dulo</th>
					<th scope="col">Acci&oacute;n</th>
					<th scope="col">Fecha</th>
					<th scope="col">Acciones</th>
				</tr>
			</thead>
			<tbody>
				<%
					ObjectMapper mapper = new ObjectMapper();	
					List<LogDTO> lDTOlist = (List<LogDTO>) request.getAttribute("logs");
					LogDTO aux;
					
					for (Iterator<LogDTO> i = lDTOlist.iterator(); i.hasNext();) {
						aux = i.next();
				%>
				<tr>
					<th scope="row"><%=aux.getNroLog()%></th>
					<td><%=aux.getModulo()%></td>
					<td><%=aux.getAccion()%></td>
					<td><%= new SimpleDateFormat("dd/MM/yyyy, HH:mm:ss z").format(aux.getFecha()) %></td>
					<td><button class="btn btn-sm btn-warning btn-detalle"
							data-log='<%=mapper.writeValueAsString(aux)%>'>
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

<!--  Modal Editar Log  -->
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/logs.js"></script>
