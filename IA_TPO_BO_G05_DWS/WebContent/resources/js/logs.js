(() => {
	$(() =>{
		const $main = $('#main').removeClass('modal-body');
		const $btnLimpiarLogs = $('#btnLimpiarLogs');
		const $btnBorrar = $('.btn-borrar');
		
		const limpiarLogs = (ev) => {
			$.post('ActionServlet?action=LimpiarLogs', {}, page => {
				$main.html(page);
			});				
		}
		
		const borrarLog = (ev) => {
			const nroLog = $(ev.target).data('nrolog');
			$.post('ActionServlet?action=BorrarLog', {"nroLog": `${nroLog}`}, page => {
				$main.html(page);
			});				
		}
		
		const doBindings = () => {
			$btnLimpiarLogs.click(limpiarLogs);
			$btnBorrar.click(borrarLog);
		}
		
		doBindings();
		
		/*
		setTimeout(()=>{
			$.post('ActionServlet?action=VerLogs', {}, page => {
				$main.html(page);
			});	
		}, 5000);
		*/
		
	});
})();