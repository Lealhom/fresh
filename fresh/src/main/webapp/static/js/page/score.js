define('page/score', ['crud'], function(CRUD) {
	var role = {
		grid: null,
		init: function() {
			var the = this;
			$("#score_configration_save1").on("click",function(){
				$.ajax({
					url:'score/update1',
					data:{rate:$('#score_configration_tip1').text()},
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
			$("#score_configration_save").on("click",function(){
				$.ajax({
					url:'score/update',
					data:{
							rate1:$('#score_configration_tip1').text(),
							rate2:$('#score_configration_tip2').text()
						},
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
