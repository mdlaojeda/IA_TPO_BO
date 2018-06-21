<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.backoffice.dto.SolicitudDTO"%>

<article class="container grid col-12 col-md-10 mt-2">
	<h1>Listado de Solicitudes</h1>
	<section class="row col-12 seleccionar-articulos mt-4 mb-4">
		<table class="table table-striped table-light text-dark">
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
					String solicitudJSONstr = "";
					
					for (Iterator<SolicitudDTO> i = sDTOlist.iterator(); i.hasNext();) {
						aux = i.next();
						solicitudJSONstr = aux.toString();
				%>
				<tr class="pedido-row">
					<th scope="row"><%=aux.getIdSolicitud()%></th>
					<td><%=aux.getTipo()%></td>
					<td><%=aux.getEstado()%></td>
					<td><button class="btn btn-sm btn-warning btn-detalle"
							data-pedido='<%=solicitudJSONstr%>'><i class="fas fa-check-square"></i> Ver Detalle</button>
				</tr>
				<% } %>
			</tbody>
		</table>
	</section>
</article>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/versolicitudes.js"></script>
