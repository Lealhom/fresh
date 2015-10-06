define('page/order', ['crud'], function(CRUD) {
	var order = {
		grid: null,
		init: function() {
			var the = this;
			this.grid = $('#ordergrid').datagrid({
				url: 'order/paged',
				rowStyler:function(index,row){
					return 'background-color:#ccc;color:blue;';
				},
				fit: true,
				rownumbers: true,
				pagination: true,
				columns: [
				          [
				           {field: 'id', title: 'ID', checkbox: true}, 
				           {field: 'username', title: '用户名', width: 100}, 
				           {field: 'showname', title: '昵称', width: 100}, 
				           {field: 'status', title: '状态', width: 50}, 
				           {field: 'price', title: '订单总价格', width: 100}, 
				           {field: 'discountPrice', title: '订单折后价', width: 100}, 
				           {field: 'address', title: '收货地址', width: 250}, 
				           {field: 'consignee', title: '收件人', width: 100}, 
				           {field: 'phone', title: '联系方式', width: 100}, 
				           {field: 'message', title: '买家留言', width: 150}, 
				           {field: 'createTime', title: '创建时间', width: 150}, 
				           {field: 'payTime', title: '付款时间', width: 150}
				          ]
				],
				view: detailview,    
				detailFormatter:function(index,row){       
					return '<div style="padding:2px"><table class="ddv"></table></div>';   
				},    
				onExpandRow: function(index,row){       
					var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');        
					ddv.datagrid({            
						url:'sku/selectByorderId/'+row.id,        
						fitColumns:true,            
						singleSelect:true,            
						rownumbers:true,      
						loadMsg:'',            
						height:'auto',            
						columns:[[          
						           {field:'name',title:'名称',width:100},
						           {field:'originalPrice',title:'原价',width:100}, 
						           {field:'discountPrice',title:'折扣价',width:100}, 
						           {field:'standard',title:'规格',width:100}, 
						           {field:'quantity',title:'购买数量',width:100}, 
						        ]],           
						onResize:function(){      
						              $('#dg').datagrid('fixDetailRowHeight',index);    
						},            
						onLoadSuccess:function(){      
						       setTimeout(function(){$('#ordergrid').datagrid('fixDetailRowHeight',index);},0);            
						}       
					});
					$('#ordergrid').datagrid('fixDetailRowHeight',index);   
				},
				toolbar: [{
					text: '确认发货',
					iconCls: 'icon-ok',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							the.sendGoods(ids);
						}
					}
				},{
					text: '退款',
					iconCls: 'icon-undo',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = CRUD.getCheckedIds(checkRow);
						if (ids) {
							the.refund(ids);
						}
					}
				}]
			});
		},
		sendGoods: function(ids) {
			var the = this;
			CRUD.operate({
				url: 'order/sendGoods',
				data: {ids: ids}
			},
			'确认发货？',
			function() {
				the.reload();
			});
		},
		refund: function(ids) {
			var the = this;
			CRUD.operate({
				url: 'order/refund',
				data: {ids: ids}
			},
			'确认退款？',
			function() {
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
