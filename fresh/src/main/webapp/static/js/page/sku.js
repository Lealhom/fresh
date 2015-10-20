define('page/sku', ['crud'], function(CRUD) {
	var sku = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#skugrid').datagrid({
				url: 'sku/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[
				           	{field: 'id', title: 'ID', checkbox: true}, 
				           	{field: 'name', title: '名称', width: 150}, 
				           	{field: 'productName', title: '产品名称', width: 300}, 
				           	{field: 'originalPrice', title: '原价', width: 100}, 
				           	{field: 'discountPrice', title: '折扣价', width: 100}, 
				           	{field: 'standard', title: '规格', width: 200},
				           	{field: 'quantity', title: '库存', width: 100},
				           	{field: 'status', title: '状态', width: 100}
					]
				],
				toolbar: [{
					text: '添加',
					iconCls: 'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加SKU',
							href: 'sku/add'
						}, function() {
							the.loaded();
						}, function() {
							the.saveOrUpdate();
						});
					}
				}, {
					text: '修改',
					iconCls: 'icon-edit',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						if (CRUD.onlyCheckedOne(checkRow)) {
							CRUD.edit({
								title: '编辑SKU--' + checkRow[0].name,
								href: 'sku/update?id=' + checkRow[0].id
							}, function() {
								the.loaded();
							}, function() {
								the.saveOrUpdate();
							});
						}
					}
				}, {
					text: '删除',
					iconCls: 'icon-remove',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							CRUD.del({
								url: 'sku/del',
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
	return sku;
});
