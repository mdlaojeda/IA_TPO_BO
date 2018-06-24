<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.backoffice.dto.LogDTO"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>

<article class="container grid col-12 col-md-10 mt-2">
	<div class="d-flex row col-12"><h1>Reporte de Logs</h1>
	<button id="btnLimpiarLogs" type="button" class="btn btn-danger ml-auto"><i class="fas fa-trash-alt"></i> Limpiar Logs</button>
	</div>
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
					<td><button class="btn btn-sm btn-danger btn-borrar"
							data-nrolog="<%=aux.getNroLog()%>">
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

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/logs.js"></script>
