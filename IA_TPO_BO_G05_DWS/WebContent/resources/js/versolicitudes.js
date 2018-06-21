(() => {
	$(() =>{
		const $main = $('#main').removeClass('modal-body');
		const $btnDetalle = $('.btn-detalle');
		const $modalDetalle = $('#modalDetalle');
		const $submitDetalle = $('#submitDetalle');
		
		const invalidClass = 'is-invalid';
		
		let currentSolicitud = '';
		/*
		const despacharPedido = (ev) => {
			ev.preventDefault();
			populateModal($(ev.currentTarget).data('solicitud'));
			$modalDetalle.modal('show');
		}
		
		const validar = () => {
			const fechaGen = new Date(currentPedido.fechaGeneracion);
			$modalDespachar.find('.needs-validation').each((index, item) => {
				switch (item.type) {
					case 'date':
							let invalid = true;
							if (!!item.valueAsDate) {
								invalid = fechaGen.getTime() > item.valueAsDate.getTime();
							}
								$(item).toggleClass(invalidClass, invalid);
						break;
					case 'select-one':
							$(item).toggleClass(invalidClass, item.selectedIndex < 1);
						break;
				}
			});
			return $modalDespachar.find(`.needs-validation.${invalidClass}`).length < 1;
		}
		
		const submitPedido = () => {
			if(validar()) {
				$.extend(currentPedido, {
					fechaEntrega: $modalDespachar.find('#fechaentrega').val(),
					empresatransporte: $modalDespachar.find('#empresaTransporteSelect').val()
				});

				$.post('ActionServlet?action=DespacharPedido', currentPedido, page => {
					$modalDespachar.one('hidden.bs.modal', function (e) {
						$main.html(page);
					});
					$modalDespachar.modal('hide');
				});				
			}
		}
		
		const populateModal = pedido => {
			currentPedido = pedido;
			$modalDespachar.find('#dispatchPedidoModalLabel').text(`¿Despachar pedido ${currentPedido.idPedido}?`);
			$modalDespachar.find('.needs-validation').removeClass('is-invalid');
		}
		*/
		
		const doBindings = () => {
			//$btnPedido.click(despacharPedido);
			//$submitPedido.click(submitPedido);
		}
		
		doBindings();
	});
})();