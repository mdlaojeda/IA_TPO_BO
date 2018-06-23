(() => {
	$(() =>{
		const $main = $('#main').removeClass('modal-body');
		const $btnDetalle = $('.btn-detalle');
		const $btnBorrar = $('.btn-borrar');
		const $modalDetalle = $('#modalDetalle');
		const $btnEditarLog = $('#btnEditarLog');
		
		let currentLog = '';
		
		const mostrarDetalle = (ev) => {
			ev.preventDefault();
			popularModal($(ev.currentTarget).data('log'));
			$modalDetalle.modal('show');
		}		
		
		const popularModal = log => {
			currentLog = log;
			//$modalDetalle.find('#editNroTipoServicio').val(`${currentTipoServicio.nroTipoServicio}`);
			//$modalDetalle.find('#editDescripcion').val(`${currentTipoServicio.descripcion}`);
		}

		const editarLog = () => {
			//currentLog['descripcion'] = $modalDetalle.find('#editDescripcion').val();
			$.post('ActionServlet?action=EditarLog', currentLog, page => {
				$modalDetalle.one('hidden.bs.modal', () => $main.html(page));
				$modalDetalle.modal('hide');
			});				
		}
		const borrarLog = (ev) => {
			const nroLog = $(ev.target).data('nroLog');
			$.post('ActionServlet?action=BorrarLog', {"nroLog": `${nroLog}`}, page => {
				$main.html(page);
			});				
		}
		
		const doBindings = () => {
			$btnDetalle.click(mostrarDetalle);
			$btnEditarLog.click(editarLog);
			$btnBorrar.click(borrarLog);
		}
		
		doBindings();
	});
})();