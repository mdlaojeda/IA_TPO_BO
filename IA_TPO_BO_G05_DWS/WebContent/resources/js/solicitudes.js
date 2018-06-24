(() => {
	$(() =>{
		const $main = $('#main').removeClass('modal-body');
		const $btnDetalle = $('.btn-detalle');
		const $modalDetalle = $('#modalDetalle');
		const $aprobarSolicitud = $('#aprobarSolicitud');
		const $desaprobarSolicitud = $('#desaprobarSolicitud');
		const $btnLimpiarSolicitudes = $('#btnLimpiarSolicitudes');
		let currentSolicitud = '';
		
		const mostrarDetalle = (ev) => {
			ev.preventDefault();
			popularModal($(ev.currentTarget).data('solicitud'));
			$modalDetalle.modal('show');
		}
		
		const popularModal = solicitud => {
			currentSolicitud = solicitud;
			$modalDetalle.find('#idSolicitud').val(`${currentSolicitud.idSolicitud}`);
			$modalDetalle.find('#codEntidad').val(`${currentSolicitud.codEntidad}`);
			$modalDetalle.find('#nombre').val(`${currentSolicitud.nombre}`);
			$modalDetalle.find('#direccion').val(`${currentSolicitud.direccion}`);
			$modalDetalle.find('#tipo').val(`${currentSolicitud.tipo}`);
			$modalDetalle.find('#estado').val(`${currentSolicitud.estado}`);
			if (currentSolicitud.estado !== 'PENDIENTE') {
				$aprobarSolicitud.attr('disabled', () => currentSolicitud.estado === 'APROBADA');
				$desaprobarSolicitud.attr('disabled', () => currentSolicitud.estado === 'DESAPROBADA');	
			}
		}
		
		const aprobarSolicitud = () => {
			$.post('ActionServlet?action=AprobarSolicitud', currentSolicitud, page => {
				$modalDetalle.one('hidden.bs.modal', () => $main.html(page));
				$modalDetalle.modal('hide');
			});				
		}
		const desaprobarSolicitud = () => {
			$.post('ActionServlet?action=DesaprobarSolicitud', currentSolicitud, page => {
				$modalDetalle.one('hidden.bs.modal', () => $main.html(page));
				$modalDetalle.modal('hide');
			});				
		}
		
		const limpiarSolicitudes = (ev) => {
			$.post('ActionServlet?action=LimpiarSolicitudes', {}, page => {
				$main.html(page);
			});				
		}
		
		const doBindings = () => {
			$btnLimpiarSolicitudes.click(limpiarSolicitudes);
			$btnDetalle.click(mostrarDetalle);
			$aprobarSolicitud.click(aprobarSolicitud);
			$desaprobarSolicitud.click(desaprobarSolicitud);
		}
		
		doBindings();
	});
})();