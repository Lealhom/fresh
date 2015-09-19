<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="menu/add">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input"><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[2,10]'"></td>
			<td class="form-title">标识</td>
			<td class="form-input"><input name="code" class="easyui-validatebox textbox" data-options="required:true,validType:'length[2,10]'"></td>
		</tr>
		<tr>
			<td class="form-title">入口地址</td>
			<td class="form-input"><input name="url" class="easyui-validatebox textbox"></td>
			<td class="form-title">图标</td>
			<td class="form-input"><input name="icon" class="easyui-validatebox textbox"></td>
		</tr>
		<tr>
			<td class="form-title">类型</td>
			<td class="form-input"><select class="easyui-combobox" name="type" style="width: 80px;">
				<option value="1">普通</option>
				<option value="2">特殊</option>
			</select></td>
			<td class="form-title">状态</td>
			<td class="form-input"><select class="easyui-combobox" name="status" style="width: 80px;">
				<option value="1">正常</option>
				<option value="2">禁用</option>
			</select></td>
		</tr>
		<tr>
			<td class="form-title">序号</td>
			<td class="form-input"><input name="ordernum" class="easyui-numberspinner" data-options="value:0,min:0"></td>
			<td class="form-title">上一级</td>
			<td class="form-input"><select name="parentId" class="easyui-combogrid" style="width: 100px;" data-options="
				panelWidth: 185,
				idField: 'id',
				textField: 'name',
				url: 'menu/paged',
				method: 'get',
				columns: [[{
					field:'id',title:'ID',width:80
				}, {
					field:'name',title:'名称',width:100
				}]]
			">
			</select></td>
		</tr>
	</table>
</form>