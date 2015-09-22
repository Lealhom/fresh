<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="sku/add">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input"><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[1,10]'"></td>
			<td class="form-title">规格</td>
			<td class="form-input"><input name="standard" class="easyui-textbox"></td>
		</tr>
		<tr>
			<td class="form-title">原价</td>
			<td class="form-input"><input name="originalPrice" class="easyui-numberspinner" data-options="value:0,min:0"></td>
			<td class="form-title">折扣价</td>
			<td class="form-input"><input name="discountPrice" class="easyui-numberspinner" data-options="value:0,min:0"></td>
		</tr>
		<tr>
			<td class="form-title">库存数量</td>
			<td class="form-input"><input name="quantity" class="easyui-numberspinner" data-options="value:0,min:0"></td>
			<td class="form-title">状态</td>
				<td><select class="easyui-combobox" name="status" style="width:140px;" >
					<option value="1">上架</option>
					<option value="2">下架</option>
				</select>
			</td>
		<tr>
			<td class="form-title">所属产品</td>
			<td class="form-input" colspan="3">
				<input name="pruductId" class="easyui-combogrid validatebox" style="width: 300px;" data-options="
				required:true,
				panelWidth: 300,
				idField: 'id',
				textField: 'name',
				url: 'product/paged',
				method: 'get',
				columns: [[{
					field:'id',title:'ID',width:60
				}, {
					field:'name',title:'产品名称',width:238
				}]]
			">
			</td>
		</tr>
	</table>
</form>