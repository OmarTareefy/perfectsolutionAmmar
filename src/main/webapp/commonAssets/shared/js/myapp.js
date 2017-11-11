$(function() {
	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 8000)

	}
	
	// solving the active menu problem
	switch (menu) {

	case 'About':

		$('#about').addClass('active');
		break;

	case 'Home':
		$('#home').addClass('active');
		break;
	case 'Service':
		$('#service').addClass('active');
		break;
	case 'Product':
		$('#product').addClass('active');
		break;
		
	default:
		//if (menu == 'Home')
			break;

	}
	
});
