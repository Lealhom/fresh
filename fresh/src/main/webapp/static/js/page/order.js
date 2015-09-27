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
				columns: [
				          [
				           {field: 'id', title: 'ID', checkbox: true}, 
				           {field: 'username', title: '用户名', width: 100}, 
				           {field: 'showname', title: '昵称', width: 100}, 
				           {field: 'status', title: '状态', width: 50}, 
				           {field: 'price', title: '价格', width: 100}, 
				           {field: 'discountPrice', title: '折后价', width: 100}, 
				           {field: 'address', title: '收货地址', width: 250}, 
				           {field: 'consignee', title: '收件人', width: 100}, 
				           {field: 'phone', title: '联系方式', width: 100}, 
				           {field: 'message', title: '买家留言', width: 150}, 
				           {field: 'createTime', title: '创建时间', width: 150}, 
				           {field: 'payTime', title: '付款时间', width: 150}
				          ]
				],
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
