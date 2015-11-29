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
				           {field: 'status', title: '状态', width: 50,hidden:true}, 
				           {field: 'statusInfo', title: '状态', width: 50}, 
				           {field: 'price', title: '订单总价格', width: 100}, 
				           {field: 'discountPrice', title: '订单折后价', width: 100}, 
				           {field: 'address', title: '收货地址', width: 250}, 
				           {field: 'consignee', title: '收件人', width: 100}, 
				           {field: 'phone', title: '联系方式', width: 100}, 
				           {field: 'message', title: '买家留言', width: 150}, 
				          /* {field: 'buyeId', title: '买家支付宝用户号', width: 150},*/ 
				           {field: 'buyerEmail', title: '买家支付宝账号', width: 150}, 
				           {field: 'tradeNo', title: '支付宝交易号', width: 250}, 
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
						var orders = CRUD.getCheckedObjs(checkRow,['id','status','tradeNo','price','discountPrice']);
						for(var i in orders){
							if(orders[i]['status'] != 5){
								$.messager.alert('提示','只有状态为“待退款”的订单才能退款','warning');
								return false;
							}
						}
						var reason = '协商退款';//退款理由是写死的，应该弹出一个窗口，填入退款理由
						if (orders) {
							the.refund(reason,orders);
						}
					}
				},{
					text: '导出',
					iconCls: 'icon-print',
					handler: function() {
						var checkRow = the.grid.datagrid('getChecked');
						var ids = '';
						if(checkRow.length!=0){
							ids = CRUD.getCheckedIds(checkRow);
						}
						window.location.href="order/export?ids="+ids;  
					}
				}]
			});
		},
		sendGoods: function(ids) {
			var the = this;
			CRUD.operate({
				url: 'order/send',
				data: {ids: ids}
			},
			'确认发货？',
			function() {
				the.reload();
			});
		},
		refund: function(reason,orders) {
			var the = this;
			var params = {reason: reason,orders:orders};
			 $.messager.confirm('提示','确认退款？', function(r){
				 if (r) {
					 $.ajax({
							dataType: 'json',
							type: 'POST',
							url: 'order/refunded',
							contentType:'application/json',
							data: JSON.stringify(params),
							success: function(data) {
								var form = data['data'];
								$("#refund_div").html(form);
								the.reload();
							}
					});
				 }
			 });
			/*
			CRUD.operate({
				url: 'order/refunded',
				type:'POST',
				contentType:'application/json',
				data: JSON.stringify(params)
			},
			'确认退款？',
			function(data) {
				console.log(data);
				the.reload();
			});
			*/
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
