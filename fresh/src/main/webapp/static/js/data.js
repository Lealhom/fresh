define('data', [], function() {
	var data = {
		ajax: function(options, successCallback, errorCallback) {
			var defaultOptions = {
				dataType: 'json',
				type: 'POST',
				success: function(data) {
					if (successCallback) successCallback.call(this);
				},
				error: function() {
					if (errorCallback) errorCallback.call(this);
				}
			};
			options = $.extend(defaultOptions, options);
			$.ajax(options);
		}
	};
	return data;
});