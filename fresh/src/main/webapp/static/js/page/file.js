define('page/file', ['crud'], function(CRUD) {
	var file = {
		grid: null,
		init: function() {
			var the = this;
			this.layout = $('#filetypeLayout').layout({
				fit: true,
				border: false
			});
			this.layout.layout('add', {
				region: 'west',
				title: '文件分类',
				border: false,
				width: 200,
				content: '<ul id="filetypetree"></ul>',
				tools: [{
					iconCls:'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加文件分类',
							href: 'file/add'
						}, function() {
							the.loaded();
						}, function() {
							the.saveOrUpdate();
						});
					}
				}]
			}).layout('add', {
				region: 'center',
				border: false,
				content: '<table id="filegrid"></table>'
			});
			this.typeTree = $('#filetypetree').tree({
				url: 'file/tree_filetype',
				lines: true,
				animate: true
			});
			this.grid = $('#filegrid').datagrid({
				url: 'file/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[{
					field: 'id', title: 'ID', checkbox: true
				}, {
					field: 'name', title: '名称', width: 150
				}, {
					field: 'typeName', title: '文件分类', width: 150
				}, {
					field: 'uploadTime', title: '上传时间', width: 180
				}]],
				toolbar: [{
					text: '添加',
					iconCls: 'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加文件',
							href: 'file/add'
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
								title: '编辑文件--' + checkRow[0].name,
								href: 'file/update?id=' + checkRow[0].id
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
								url: 'file/del',
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
		}
	}
	return file;
});
