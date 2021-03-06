<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="category/update">
	<input type="hidden" name="id" value="${category.id }">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input"><input name="name" value="${category.name }" style="width: 172px;" class="easyui-validatebox textbox" data-options="required:true,validType:'length[1,10]'"></td>
		</tr>
		<tr>
			<td class="form-title">上一级</td>
			<td class="form-input"><input name="parentId" value="${category.parentId == 0 ? '' : category.parentId}" 
			class="easyui-combogrid" style="width: 185px;" data-options="
				panelWidth: 185,
				idField: 'id',
				textField: 'name',
				url: 'category/paged',
				method: 'get',
				columns: [[{
					field:'id',title:'ID',width:60
				}, {
					field:'name',title:'名称',width:122
				}]]
			"></td>
		</tr>
	</table>
</form>