define('page/category', ['crud'], function(CRUD) {
	var category = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#categorygrid').datagrid({
				url: 'category/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[{
					field: 'id', title: 'ID', checkbox: true
				}, {
					field: 'name', title: '名称', width: 150
				}, {
					field: 'level', title: '等级', width: 150
				}]],
				toolbar: [{
					text: '添加',
					iconCls: 'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加品类',
							href: 'category/add'
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
								title: '编辑品类--' + checkRow[0].name,
								href: 'category/update?id=' + checkRow[0].id
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
								url: 'category/del',
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
	return category;
});
