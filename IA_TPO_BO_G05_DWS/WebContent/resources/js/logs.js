(() => {
	$(() =>{
		const $main = $('#main').removeClass('modal-body');
		const $btnBorrar = $('.btn-borrar');

		const borrarLog = (ev) => {
			const nroLog = $(ev.target).data('nrolog');
			$.post('ActionServlet?action=BorrarLog', {"nroLog": `${nroLog}`}, page => {
				$main.html(page);
			});				
		}
		
		const doBindings = () => {
			$btnBorrar.click(borrarLog);
		}
		
		doBindings();
	});
})();