define("fileuploader", [], function() {
	
	function FileUploader() {}
	
	FileUploader.prototype.init = function(options) {
		var defaultOptions = {
			uploadUrl: "show_item/upload",
			initialPreview: [],
			templateElement: null,
			template: '<div><div class="fileuploader-filecontainer hide"></div><div class="input-group">' +
//							'<input type="password" class="form-control">' +
							'<div class="input-group-btn">' +
							'<div class="btn blue select-file" type="button">选择</div>' +
							'</div>' +
						'</div></div>',
			uploadExtraData: null
		};
		console.log(options)
		this.options = $.extend(defaultOptions, options);
		this.options.templateElement = $(this.options.template);
		console.log(this.options.element)
		this.options.multiple = this.options.element.prop("multiple");
		console.log(this.options.multiple)
		this.options.element.replaceWith(this.options.templateElement);
		this.options.templateElement.append(this.options.element.hide());
		console.log(this.options.templateElement)
		this.files = {};
		this.createInitialPreview();
		
		this.bind();
	};
	
	FileUploader.prototype.createInitialPreview = function() {
		if (this.options.initialPreview && this.options.initialPreview.length > 0) {
			for ( var i in this.options.initialPreview) {
				var itemPreview = this.options.initialPreview[i];
				this.createPreview(itemPreview.src, i, itemPreview.name, "preview");
			}
		}
	};
	
	FileUploader.prototype.createPreview = function(imgSrc, id, filename, filetype) {
		var htmls = ['<div data-id="' + id + '" class="file-item" data-filetype="' + filetype + '">'];
		htmls.push('<div class="file-item-img">');
		htmls.push('<img src="' + imgSrc + '"/></div>');
		htmls.push('<div class="file-item-footer">');
		htmls.push('<label>' + filename + '</label>');
		htmls.push('<div class="file-item-actions">');
		htmls.push('<button title="删除" class="btn btn-xs btn-default file-remove" type="button"><i class="glyphicon glyphicon-trash text-danger"></i></button>');
		htmls.push('</div></div></div>');
		this.options.templateElement.find(".fileuploader-filecontainer").append(htmls.join("")).removeClass("hide");
	};
	
	FileUploader.prototype.clear = function(fileList) {
		this.files = {};
		this.options.templateElement.find(".fileuploader-filecontainer").empty().addClass("hide");
	};
	
	FileUploader.prototype.addFile = function(fileList) {
		var the = this;
		
		if (!this.options.multiple) {
			the.clear();
		}
		
		var currentTime = (new Date()).getTime();
		var length = fileList.length;
		var i = 0;
		var reader = new FileReader();
		reader.onload = function(evt) {
			var file = fileList.item(i);
			the.createPreview(evt.target.result, currentTime + "-" + i, file.name, "file");
			the.files["file-" + currentTime + "-" + i] = file;
	        i++;
	        if (i < length)
	        	reader.readAsDataURL(fileList.item(i));
	    }
		reader.readAsDataURL(fileList.item(i));
	};
	
	FileUploader.prototype.removeFile = function(fileItem) {
		var the = this;
		var id = fileItem.data("id");
		var filetype = fileItem.data("filetype");
		if (filetype == "preview") {
			var file = this.options.initialPreview[parseInt(id)];
			var data = $.extend(file.extra, {id:file.id});
			$.ajax({
				url: this.options.deleteUrl,
	            type: 'POST',
	            dataType: 'json',
	            data: data,
	            success: function() {
	            	fileItem.remove();
	            	the.toggleFileContainer();
	            }
			});
		} else if (filetype == "file") {
			delete this.files["file-" + id];
			fileItem.remove();
			this.toggleFileContainer();
		}
	};
	
	FileUploader.prototype.toggleFileContainer = function(fileItem) {
		if (this.options.templateElement.find(".fileuploader-filecontainer").find(".file-item").length == 0)
			this.options.templateElement.find(".fileuploader-filecontainer").addClass("hide");
	};

	FileUploader.prototype.bind = function() {
		var the = this;
		this.options.templateElement.on("click", ".select-file", function(event) {
			the.options.element.click();
		}).on("click", ".file-remove", function(event) {
			var target = $(this).closest(".file-item");
			the.removeFile(target);
		});
		this.options.element.on("change", function(event) {
			var files = the.options.element.prop("files");
			the.addFile(files);
		});
	};

	FileUploader.prototype.unbind = function() {
		var the = this;
		this.options.templateElement.off();
		this.options.element.off();
	};
	
	FileUploader.prototype.upload = function(extraData) {
		for ( var key in this.files) {
			var file = this.files[key];
			if (!file) continue;
			var formdata = new FormData();
			formdata.append("file", file);
			
			if (this.options.uploadExtraData) {
				var params = {};
				if (typeof this.options.uploadExtraData == "function") {
					params = this.options.uploadExtraData.call(this);
				} else {
					params = this.options.uploadExtraData;
				}
				for ( var key in params) {
					formdata.append(key, params[key]);
				}
			}
			
			if (extraData) {
				for ( var key in extraData) {
					formdata.append(key, extraData[key]);
				}
			}
			
			$.ajax({
				url: this.options.uploadUrl,
	            type: 'POST',
	            dataType: 'json',
	            data: formdata,
	            cache: false,
	            processData: false,
	            contentType: false
			});
		}
	};
	
	FileUploader.prototype.destroy = function() {
		this.unbind();
		this.options.templateElement.replaceWith(this.options.element.show()).remove();
	};
	
	return {
		newUploader: function(options) {
			var uploader = new FileUploader();
			uploader.init(options);
			return uploader;
		}
	};
});