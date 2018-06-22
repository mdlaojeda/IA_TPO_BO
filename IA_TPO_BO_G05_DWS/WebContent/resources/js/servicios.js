(() => {
	$(() =>{
		const $main = $('#main').removeClass('modal-body');
		const $btnNuevoServicio = $('#btnNuevoServicio');
		const $btnDetalle = $('.btn-detalle');
		const $modalNuevoServicio = $('#modalNuevoServicio');
		const $modalDetalle = $('#modalDetalle');
		const $btnAgregarServicio = $('#btnAgregarServicio');
		const $btnEditarServicio = $('#btnEditarServicio');
		
		let currentServicio = '';
		
		const mostrarNuevoServicio = (ev) => {
			ev.preventDefault();
			$modalNuevoServicio.modal('show');
		}
		
		const mostrarDetalle = (ev) => {
			ev.preventDefault();
			popularModal($(ev.currentTarget).data('servicio'));
			$modalDetalle.modal('show');
		}
		
		
		const popularModal = servicio => {
			currentServicio = servicio;
			$modalDetalle.find('#editNroServicio').val(`${currentServicio.nroServicio}`);
			$modalDetalle.find('#editDescripcion').val(`${currentServicio.descripcion}`);
			$modalDetalle.find(`#editTipoServicio option[value="${currentServicio.tipoServicio.nroTipoServicio}"]`).attr('selected', 'selected');
		}
		
		const agregarServicio = () => {
			let servicio = {};
			servicio['descripcion'] = $modalNuevoServicio.find('#descripcion').val();
			servicio['tipoServicio'] = JSON.stringify($modalNuevoServicio.find('#tipoServicio option:selected').data('tipo'));
			$.post('ActionServlet?action=AgregarServicio', servicio, page => {
				$modalNuevoServicio.one('hidden.bs.modal', () => $main.html(page));
				$modalNuevoServicio.modal('hide');
			});				
		}
		const editarServicio = () => {
			currentServicio['descripcion'] = $modalDetalle.find('#editDescripcion').val();
			currentServicio['tipoServicio'] = JSON.stringify($modalDetalle.find('#editTipoServicio option:selected').data('tipo'));
			$.post('ActionServlet?action=EditarServicio', currentServicio, page => {
				$modalDetalle.one('hidden.bs.modal', () => $main.html(page));
				$modalDetalle.modal('hide');
			});				
		}	
		
		const doBindings = () => {
			$btnNuevoServicio.click(mostrarNuevoServicio);
			$btnDetalle.click(mostrarDetalle);
			$btnAgregarServicio.click(agregarServicio);
			$btnEditarServicio.click(editarServicio);
		}
		
		doBindings();
	});
})();