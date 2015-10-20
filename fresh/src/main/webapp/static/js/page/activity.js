define('page/activity', ['crud'], function(CRUD) {
	var activity = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#activitygrid').datagrid({
				url: 'activity/paged',
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [[
				           {field: 'id', title: 'ID', checkbox: true}, 
				           {field: 'imgUuid', title: '图片', width: 90,
								formatter:function(value){
									if(value){
										var s='<a href="javascript:void(0)"><img src="static/upload/'+value+'" style="width:80px;height:80px;"/></a>';
										return s;
									}else{
										return '';
									}
									
								}
						    }, 
				           {field: 'name', title: '名称', width: 150}, 
				           {field: 'productNames', title: '参加活动的产品', width: 350}, 
				           {field: 'description', title: '描述', width: 300},
				           {field: 'startTime', title: '开始时间', width: 200},
				           {field: 'endTime', title: '结束时间', width: 200},
				           {field: 'status', title: '状态', width: 100},
				           {field: 'banner', title: '是否为banner', width: 100},
				           {field: 'orderNum', title: '序号', width: 100}
				         ]],
				toolbar: [{
					text: '添加',
					iconCls: 'icon-add',
					handler: function() {
						CRUD.add({
							title: '添加活动',
							href: 'activity/add'
						}, function() {
							the.loaded();
						}, function() {
							the.saveOrUpdate();
						});
					}
				}, 
				{
					text: '修改',
					iconCls: 'icon-edit',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						if (CRUD.onlyCheckedOne(checkRow)) {
							CRUD.edit({
								title: '编辑活动--' + checkRow[0].name,
								href: 'activity/update?id=' + checkRow[0].id
							}, function() {
								the.loaded();
							}, function() {
								the.saveOrUpdate();
							});
						}
					}
				}, 
				{
					text: '删除',
					iconCls: 'icon-remove',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							CRUD.del({
								url: 'activity/del',
								data: {ids: ids}
							}, function() {
								the.reload();
							});
						}
					}
				},{
					text: '更换图片',
					iconCls: 'icon-large-picture',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						if (CRUD.onlyCheckedOne(checkRow)) {
							CRUD.edit({
								title: '更换活动图片--' + checkRow[0].name,
								width:420,
								height:420,
								href: 'activity/updateImg?id=' + checkRow[0].id
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
	return activity;
});
