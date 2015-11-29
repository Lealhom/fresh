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
				           	{
								field: 'mainImgUuid', title: '主图', width: 90,
								formatter:function(value){
									var s='<a href="javascript:void(0)"><img src="static/upload/'+value+'" style="width:80px;height:80px;"/></a>';
									return s;
								}
							}, 
				           	{field: 'name', title: '名称', width: 150}, 
				           	{field: 'productName', title: '产品名称', width: 300}, 
				           	{field: 'originalPrice', title: '原价', width: 100}, 
				           	{field: 'discountPrice', title: '折扣价', width: 100}, 
				           	{field: 'scoreConvertRate', title: '积分兑换比例', width: 100}, 
				           	{field: 'standard', title: '规格', width: 200},
				           	{field: 'quantity', title: '库存', width: 100},
				           	{field: 'status', title: '状态', width: 100,hidden:true},
				           	{field: 'statusInfo', title: '状态', width: 100}
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
				},{
					text: '更换主图',
					iconCls: 'icon-large-picture',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						if (CRUD.onlyCheckedOne(checkRow)) {
							CRUD.edit({
								title: '更换主图--' + checkRow[0].name,
								width:420,
								height:420,
								href: 'sku/updateMainImg?id=' + checkRow[0].id
							}, function() {
								the.loaded();
							}, function() {
								the.saveOrUpdate();
							});
						}
					}
				},{
					text: '更换副图',
					iconCls: 'icon-large-clipart',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						if (CRUD.onlyCheckedOne(checkRow)) {
							CRUD.edit({
								title: '更换副图--' + checkRow[0].name,
								width:420,
								height:420,
								href: 'sku/updateViceImg?id=' + checkRow[0].id
							}, function() {
								the.loaded();
							}, function() {
								the.saveOrUpdate();
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
