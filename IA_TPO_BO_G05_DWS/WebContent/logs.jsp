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
		<table class="table table-striped table-light text-dark">
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
					List<LogDTO> lDTOlist = (List<LogDTO>) request.getAttribute("logs");
					LogDTO aux;
					String logJSONstr = "";
					ObjectMapper mapper = new ObjectMapper();
					for (Iterator<LogDTO> i = lDTOlist.iterator(); i.hasNext();) {
						aux = i.next();
						logJSONstr = mapper.writeValueAsString(aux);
				%>
				<tr class="pedido-row">
					<th scope="row"><%=aux.getNroLog()%></th>
					<td><%=aux.getModulo()%></td>
					<td><%=aux.getAccion()%></td>
					<td><%= new SimpleDateFormat("dd/MM/yyyy, Ka").format(aux.getFecha()) %></td>
					<td><button class="btn btn-sm btn-warning btn-editar"
							data-log='<%=logJSONstr%>'>
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
<div class="modal fade" id="modalDetalle" tabindex="-1" role="dialog"
	aria-labelledby="modalDetalleLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content text-dark">
			<div class="modal-header">
				<h5 class="modal-title" id="modalDetalleLabel">Reporte</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form>
					<div class="form-row">
						<div class="col-md-4 mb-2">
							<label for="idSolicitud">ID</label> <input readonly type="text"
								class="form-control" id="idSolicitud" placeholder="ID" value="" />
						</div>
						<div class="col-md-8 mb-2">
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
	src="${pageContext.request.contextPath}/resources/js/logs.js"></script>
