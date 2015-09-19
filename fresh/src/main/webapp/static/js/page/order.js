define('page/order', ['crud'], function(CRUD) {
	var order = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#ordergrid').datagrid({
				url: 'order/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[{
					field: 'id', title: 'ID', checkbox: true
				}, {
					field: 'username', title: '用户名称', width: 150
				}, {
					field: 'status', title: '状态', width: 150
				}, {
					field: 'price', title: '价格', width: 150
				}, {
					field: 'createtime', title: '创建时间', width: 200
				}, {
					field: 'paytime', title: '付款时间', width: 200
				}]],
				toolbar: [{
					text: '退款',
					iconCls: 'icon-add',
					handler: function() {
						
					}
				}, {
					text: '取消',
					iconCls: 'icon-edit',
					handler: function() {
						
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
	return order;
});
