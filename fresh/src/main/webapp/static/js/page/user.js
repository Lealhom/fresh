define('page/user', ['crud'], function(CRUD) {
	var user = {
		grid: null,
		init: function() {
			var the = this;
			this.bind();
			this.grid = $('#userContainer table').datagrid({
				url: 'user/paged',
				fit: true,
				checkOnSelect: false,
				selectOnCheck: false,
				rownumbers: true,
				pagination: true,
				columns: [[{
					field: 'id', title: 'ID', checkbox: true
				}, {
					field: 'username', title: '用户名', width: 150
				}, {
					field: 'name', title: '名称', width: 150
				}, {
					field: 'sex', title: '性别', width: 100
				}, {
					field: 'age', title: '年龄', width: 100
				}, {
					field: 'phone', title: '电话', width: 150
				}, {
					field: 'email', title: '邮箱', width: 200
				}, {
					field: 'createtime', title: '创建时间', width: 200
				}, {
					field: 'opr', title: '操作', width: 100, formatter: function(value, row, index) {
						return '<a class="edit-btn" data-title="' + row.name + '" data-id="' + row.id + '">修改</a> <a class="del-btn" data-id="' + row.id + '">删除</a>';
					}
				}]],
				toolbar: [{
					text: '添加',
					iconCls: 'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加用户',
							href: 'user/add'
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
							the.edit(checkRow[0].id, checkRow[0].name);
						}
					}
				}, {
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
		edit: function(id, title) {
			var the = this;
			CRUD.edit({
				title: '编辑用户--' + title,
				href: 'user/update?id=' + id
			}, function() {
				the.loaded();
			}, function() {
				the.saveOrUpdate();
			});
		},
		del: function(ids) {
			var the = this;
			CRUD.del({
				url: 'user/del',
				data: {ids: ids}
			}, function() {
				the.reload();
			});
		},
		bind: function() {
			var the = this;
			$('#userContainer').on('click', 'a.edit-btn', function(event) {
				event.stopPropagation();
				var target = $(event.target);
				var id = target.data('id');
				var title = target.data('title');
				the.edit(id, title);
			});
			$('#userContainer').on('click', 'a.del-btn', function(event) {
				event.stopPropagation();
				var target = $(event.target);
				var id = target.data('id');
				the.del([id]);
			});
		},
		unbind: function() {
			$('#userContainer').off();
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
			this.unbind();
			this.grid.datagrid('getPanel').panel('destroy');
		}
	}
	return user;
});
