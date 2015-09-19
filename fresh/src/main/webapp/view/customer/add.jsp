<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="customer/add">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input"><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td class="form-title">状态</td>
			<td class="form-input"><select class="easyui-combobox" name="status" style="width:80px;">
				<option value="1">正常</option>
				<option value="2">禁用</option>
			</select></td>
		</tr>
		<tr>
			<td class="form-title">价格</td>
			<td class="form-input"><input name="price" class="easyui-numberbox textbox" data-options="required:true,min:0,precision:2"></td>
			<td class="form-title">折扣</td>
			<td class="form-input"><input name="discount" class="easyui-numberbox textbox" data-options="required:true,min:0,precision:2"></td>
		</tr>
	</table>
</form>