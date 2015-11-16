<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="category/add" enctype="multipart/form-data">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input">
				<input name="name" style="width: 172px;" class="easyui-validatebox textbox" data-options="required:true,validType:'length[1,10]'">
			</td>
		</tr>
		<tr>
			<td class="form-title">父级品类</td>
			<td class="form-input">
				<input name="parentId" class="easyui-combogrid" style="width: 185px;" data-options="
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
			">
			</td>
		</tr>
		<tr>
			<td class="form-title">图片</td>
			<td class="form-input">
				<input type="file" name="file" class="easyui-validatebox"  data-options="required:true">
			</td>
		</tr>
	</table>
</form>
