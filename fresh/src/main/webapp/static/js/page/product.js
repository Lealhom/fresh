define('page/product', ['crud','fileuploader'], function(CRUD,FileUploader) {
	var product = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#productgrid').datagrid({
				url: 'product/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[
				           {field: 'id', title: 'ID', checkbox: true},
							/*{
								field: 'mainImgUuid', title: '主图', width: 90,
								formatter:function(value){
									var s='<a href="javascript:void(0)"><img src="static/upload/'+value+'" style="width:80px;height:80px;"/></a>';
									return s;
								}
							}, */
							{field: 'name', title: '名称', width: 200}, 
							{field: 'brandName', title: '所属品牌', width: 150},
							{field: 'categoryNames', title: '所属品类', width: 200},
							{field: 'bornPlace', title: '产地', width: 100},
							{field: 'description', title: '描述', width: 350},
							{field: 'createTime', title: '创建时间', width: 150},
							{field: 'updateTime', title: '更新时间', width: 150},
							{field: 'status', title: '状态', width: 100,hidden:true},
							{field: 'statusInfo', title: '状态', width: 100},
							{field: 'hot', title: '是否热销', width: 100,hidden:true},
							{field: 'hotInfo', title: '是否热销', width: 100}
				]],
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
				},{
					text: '设为热销',
					iconCls: 'icon-add',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							CRUD.operate({
								url: 'product/setHot',
								data: {ids: ids}
							}, 
							'确认设置为热销产品？',
							function() {
								the.reload();
							});
						}
					}
				},{
					text: '取消热销',
					iconCls: 'icon-cancel',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							CRUD.operate({
								url: 'product/cancelHot',
								data: {ids: ids}
							}, 
							'确认取消热销产品？',
							function() {
								the.reload();
							});
						}
					}
				}/*,{
					text: '更换主图',
					iconCls: 'icon-large-picture',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						if (CRUD.onlyCheckedOne(checkRow)) {
							CRUD.edit({
								title: '更换主图--' + checkRow[0].name,
								width:420,
								height:420,
								href: 'product/updateMainImg?id=' + checkRow[0].id
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
								href: 'product/updateViceImg?id=' + checkRow[0].id
							}, function() {
								the.loaded();
							}, function() {
								the.saveOrUpdate();
							});
						}
					}
				}*/]
			});
		},
		loaded: function(data) {
			var options = {
					element:$("#uploadFile")
				}
			FileUploader.newUploader(options);
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
