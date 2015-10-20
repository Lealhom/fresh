(function(horse) {
	
	horse.ui = {};
	
	horse.ui.dialog = function(options) {
		$('<div></div>').dialog($.extend({
			title: '',
			width: 800,
			height: 600,
			modal: true,
			content: ''
		}, options));
	}
	
})(horse);
