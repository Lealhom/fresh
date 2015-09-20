define('page/product', ['crud'], function(CRUD) {
	var product = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#productgrid').datagrid({
				url: 'product/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[{
					field: 'id', title: 'ID', checkbox: true
				},{
					field: 'filePath', title: '图片', width: 90,formatter:function(value){
						var s='<a href="javascript:void(0)"><img src="'+value+'" style="width:80px;height:80px;"/></a>';
						return s;
					}
				}, {
					field: 'name', title: '名称', width: 200
				}, {
					field: 'brandName', title: '所属品牌', width: 150
				},{
					field: 'createTime', title: '创建时间', width: 150
				},{
					field: 'updateTime', title: '更新时间', width: 150
				},{
					field: 'status', title: '状态', width: 150
				}]],
				toolbar: [{
					text: '添加',
					iconCls: 'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加商品',
							href: 'product/add'
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
								title: '编辑商品--' + checkRow[0].name,
								href: 'product/update?id=' + checkRow[0].id
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
								url: 'product/del',
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
	return product;
});
