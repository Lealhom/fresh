define('page/customer', ['crud'], function(CRUD) {
	var customer = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#customergrid').datagrid({
				url: 'customer/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[{
					field: 'id', title: 'ID', checkbox: true
				},{field: 'imgUuid', title: '头像', width: 90,
					formatter:function(value){
						if(value){
							var s='<a href="javascript:void(0)"><img src="static/upload/'+value+'" style="width:80px;height:80px;"/></a>';
							return s;
						}else{
							return '';
						}
						
					}
				}, 
				{
					field: 'showname', title: '昵称', width: 150
				}, {
					field: 'username', title: '用户名', width: 150
				}, {
					field: 'phone', title: '电话', width: 150
				}, {
					field: 'email', title: '邮箱', width: 150
				}]],
				toolbar: [{
					text: '删除',
					iconCls: 'icon-remove',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							CRUD.del({
								url: 'customer/del',
								data: {ids: ids}
							}, function() {
								the.reload();
							});
						}
					}
				}]
			});
		},
		loaded: function(data) {
		},
		saveOrUpdate: function(data) {
			this.reload();
		},
		reload: function() {
			this.grid.datagrid('reload');
		},
		destroy: function() {
			this.grid.datagrid('getPanel').panel('destroy');
		}
	}
	return customer;
});
