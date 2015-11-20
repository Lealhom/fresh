define('page/score', ['crud'], function(CRUD) {
	var role = {
		grid: null,
		init: function() {
			var the = this;
			$("#score_configration_save").on("click",function(){
				$.ajax({
					url:'score/update',
					data:{rate:$('#score_configration_tip').text()},
					dataType: 'json',
					type: 'POST',
					success: function(data) {
						$.messager.show({
							title: '提示',
							msg: '保存成功！',
							showType: 'show'
						});
					}
				});
			});

		},
		loaded: function(data) {
		},
		saveOrUpdate: function(data) {
			this.reload();
		},
		reload: function() {
			this.grid.datagrid('reload');
		}
	}
	return role;
});
