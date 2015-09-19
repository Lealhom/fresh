<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="product/add">
	<table class="formtable">
		<tr>
			<td>名称</td>
			<td><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td>状态</td>
			<td><select class="easyui-combobox" name="status" style="width:90%;">
				<option value="1">正常</option>
				<option value="2">禁用</option>
			</select></td>
		</tr>
	</table>
</form>