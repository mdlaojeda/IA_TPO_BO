(() => {
	$(() =>{
		const $main = $('#main').removeClass('modal-body');
		const $btnNuevoTipoServicio = $('#btnNuevoTipoServicio');
		const $btnDetalle = $('.btn-detalle');
		const $btnBorrar = $('.btn-borrar');
		const $modalNuevoTipoServicio = $('#modalNuevoTipoServicio');
		const $modalDetalle = $('#modalDetalle');
		const $btnAgregarTipoServicio = $('#btnAgregarTipoServicio');
		const $btnEditarTipoServicio = $('#btnEditarTipoServicio');
		
		let currentTipoServicio = '';
		
		const mostrarNuevoTipoServicio = (ev) => {
			ev.preventDefault();
			$modalNuevoTipoServicio.modal('show');
		}
		
		const mostrarDetalle = (ev) => {
			ev.preventDefault();
			popularModal($(ev.currentTarget).data('tiposervicio'));
			$modalDetalle.modal('show');
		}		
		
		const popularModal = tipoServicio => {
			currentTipoServicio = tipoServicio;
			$modalDetalle.find('#editNroTipoServicio').val(`${currentTipoServicio.nroTipoServicio}`);
			$modalDetalle.find('#editDescripcion').val(`${currentTipoServicio.descripcion}`);
		}
		
		const agregarTipoServicio = () => {
			let tipoServicio = {};
			tipoServicio['descripcion'] = $modalNuevoTipoServicio.find('#descripcion').val();
			$.post('ActionServlet?action=AgregarTipoDeServicio', tipoServicio, page => {
				$modalNuevoTipoServicio.one('hidden.bs.modal', () => $main.html(page));
				$modalNuevoTipoServicio.modal('hide');
			});				
		}
		const editarTipoServicio = () => {
			currentTipoServicio['descripcion'] = $modalDetalle.find('#editDescripcion').val();
			$.post('ActionServlet?action=EditarTipoDeServicio', currentTipoServicio, page => {
				$modalDetalle.one('hidden.bs.modal', () => $main.html(page));
				$modalDetalle.modal('hide');
			});				
		}
		const borrarTipoServicio = (ev) => {
			const nroTipoServicio = $(ev.target).data('nrotiposervicio');
			$.post('ActionServlet?action=BorrarTipoDeServicio', {"nroTipoServicio": `${nroTipoServicio}`}, page => {
				$main.html(page);
			});				
		}
		
		const doBindings = () => {
			$btnNuevoTipoServicio.click(mostrarNuevoTipoServicio);
			$btnDetalle.click(mostrarDetalle);
			$btnAgregarTipoServicio.click(agregarTipoServicio);
			$btnEditarTipoServicio.click(editarTipoServicio);
			$btnBorrar.click(borrarTipoServicio);
		}
		
		doBindings();
	});
})();