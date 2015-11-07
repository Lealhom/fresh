define('page/coupon', ['crud'], function(CRUD) {
	var coupon = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#coupongrid').datagrid({
				url: 'coupon/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[
				           {field: 'id', title: 'ID', checkbox: true}, 
				           {field: 'customerId', title: '用户ID', width: 100},
				           {field: 'orderId', title: '订单ID', width: 100},
				           {field: 'batchNo', title: '批次号', width: 150},
				           {field: 'money', title: '现金券金额', width: 100},
				           {field: 'startTime', title: '有效期起', width: 150},
				           {field: 'endTime', title: '有效期止', width: 150},
				           {field: 'useTime', title: '使用时间', width: 150},
				           {field: 'status', title: '是否使用', width: 100},
				           {field: 'exceedMoney', title: '订单金额超过多少可用', width: 150},
				           {field: 'name', title: '名称', width: 150},
				           {field: 'description', title: '描述', width: 150}
				         ]],
				toolbar: [{
					text: '添加',
					iconCls: 'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加现金券',
							width:800,
							href: 'coupon/add'
						}, function() {
							the.loaded();
						}, function() {
							the.saveOrUpdate();
						});
					}
				}, 
				/*
				{
					text: '修改',
					iconCls: 'icon-edit',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						if (CRUD.onlyCheckedOne(checkRow)) {
							CRUD.edit({
								title: '编辑现金券--' + checkRow[0].name,
								href: 'coupon/update?id=' + checkRow[0].id
							}, function() {
								the.loaded();
							}, function() {
								the.saveOrUpdate();
							});
						}
					}
				}, 
				*/
				{
					text: '删除',
					iconCls: 'icon-remove',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							CRUD.del({
								url: 'coupon/del',
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
	return coupon;
});
