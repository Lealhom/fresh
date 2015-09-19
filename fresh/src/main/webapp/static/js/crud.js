define('crud', ['data'], function(DATA) {
	
	function dialog(options, loadCallback, saveCallback) {
		var dialog = $('<div></div>').appendTo('body').dialog($.extend({
			title: '',
			width: 800,
			height: 500,
			modal: true,
			resizable: true,
			buttons: [{
				text: '确定',
				iconCls: 'icon-save',
				handler: function() {
					$(dialog.find('form')).form('submit', {
						success: function(data) {
							$.messager.show({
								title: '提示',
								msg: '成功',
								showType: 'show'
							});
							dialog.dialog('close');
							dialog.dialog('destroy');
							
							if (saveCallback) saveCallback.call(this);
						}
					});
				}
			}, {
				text: '关闭',
				iconCls: 'icon-clear',
				handler: function() {
					dialog.dialog('close');
					dialog.dialog('destroy');
				}
			}],
			onLoad: function() {
				if (loadCallback) loadCallback.call(this);
			}
		}, options));
	}
	
	var crud = {
		add: function(options, loadCallback, saveCallback) {
			var defaultOptions = {
				iconCls: 'icon-add',
				cache: true
			};
			options = $.extend(defaultOptions, options);
			dialog(options, loadCallback, saveCallback);
		},
		edit: function(options, loadCallback, saveCallback) {
			var defaultOptions = {
				iconCls: 'icon-edit',
				cache: false
			};
			options = $.extend(defaultOptions, options);
			dialog(options, loadCallback, saveCallback);
		},
		del: function(options, successCallback, errorCallback) {
			 $.messager.confirm('提示', '确定删除？', function(r){
				 if (r) {
					 DATA.ajax(options, successCallback, errorCallback);
				 }
			 });
		},
		onlyCheckedOne: function(checkRow) {
			if (!checkRow || 1 != checkRow.length) {
				$.messager.show({
					title: '提示',
					msg: '只能选择一条纪录进行编辑',
					showType: 'show'
				});
				return false;
			}
			return true;
		},
		getCheckedIds: function(checkedRow, field) {
			field = field || 'id';
			var values = [];
			for (var i in checkedRow) {
				var row = checkedRow[i];
				values.push(row[field]);
			}
			if (values.length == 0) {
				$.messager.alert('提示','至少选择一条数据！','warning');
				return false;
			}
			return values;
		}
	};
	return crud;
});