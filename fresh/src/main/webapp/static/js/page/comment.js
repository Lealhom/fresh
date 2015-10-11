define('page/comment', ['crud'], function(CRUD) {
	var order = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#commentgrid').datagrid({
				url: 'comment/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[{
					field: 'id', title: 'ID', checkbox: true
				}, {
					field: 'username', title: '用户名称', width: 150
				}, {
					field: 'orderId', title: '订单ID', width: 150
				}, {
					field: 'createTime', title: '创建时间', width: 200
				}, {
					field: 'score', title: '评分等级', width: 150
				}, {
					field: 'content', title: '评论内容', width: 200
				}]],
				toolbar: [{
					text: '删除',
					iconCls: 'icon-remove',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							the.del(ids);
						}
					}
				}]
			});
		},
		del: function(ids) {
			var the = this;
			CRUD.del({
				url: 'comment/del',
				data: {ids: ids}
			}, function() {
				the.reload();
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
