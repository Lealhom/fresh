<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="product/add" enctype="multipart/form-data">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[1,20]'"></td>
			<td class="form-title">状态</td>
			<td><select class="easyui-combobox" name="status" style="width:220px;">
				<option value="1">正常</option>
				<option value="2">禁用</option>
			</select></td>
		</tr>
		<tr>
			<td class="form-title">品类</td>
			<td class="form-input">
				<select name="categoryId" class="easyui-combogrid" style="width: 220px;" data-options="
				panelWidth: 220,
				idField: 'id',
				textField: 'name',
				url: 'category/paged',
				method: 'get',
				columns: [[{
					field:'id',title:'ID',width:100
				}, {
					field:'name',title:'名称',width:118
				}]]
			">
			</select>
			</td>
			<td class="form-title">品牌</td>
			<td class="form-input">
				<select name="brandId" class="easyui-combogrid" style="width: 220px;" data-options="
				panelWidth: 220,
				idField: 'id',
				textField: 'name',
				url: 'brand/paged',
				method: 'get',
				columns: [[{
					field:'id',title:'ID',width:100
				}, {
					field:'name',title:'名称',width:118
				}]]
			">
			</select>
			</td>
		</tr>
		<tr>
			<td class="form-title">图片</td>
			<td class="form-input" colspan="3"><input name="file" class="easyui-filebox" data-options="required:true" style="width: 300px;"></td>
		</tr>
		<tr>
			<td class="form-title">描述</td>
			<td class="form-input" colspan="3"><textarea name="description"></textarea></td>
		</tr>
	</table>
</form>