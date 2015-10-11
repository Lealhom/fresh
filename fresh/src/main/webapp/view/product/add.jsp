<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="product/add" enctype="multipart/form-data">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[1,20]'"></td>
			<td class="form-title">状态</td>
			<td><select class="easyui-combobox" name="status" style="width:220px;" >
				<option value="1">上架</option>
				<option value="2">下架</option>
			</select></td>
		</tr>
		<tr>
			<td class="form-title">品类</td>
			<td class="form-input">
				<input id = "xxx" name="categoryIds"  class="easyui-combogrid" style="width: 220px;" data-options="
				required:true,
				panelWidth: 220,
				idField: 'id',
				textField: 'name',
				multiple:true,
				url: 'category/paged',
				method: 'get',
				columns: [[{
					field:'id',title:'ID',width:100
				}, {
					field:'name',title:'名称',width:118
				}]]
			">
			</td>
			<td class="form-title">品牌</td>
			<td class="form-input">
				<input name="brandId" class="easyui-combogrid" style="width: 220px;" data-options="
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
			</td>
		</tr>
		<tr>
			<td class="form-title">主图</td>
			<td class="form-input" colspan="3"><input name="mainImg" type="file" data-options="required:true" style="width: 300px;"></td>
		</tr>
		<tr>
			<td class="form-title">副图</td>
			<td class="form-input" colspan="3"><input name="viceImgs" type="file" multiple="multiple" data-options="required:true" style="width: 300px;"></td>
		</tr>
		<tr>
			<td class="form-title">产地</td>
			<td class="form-input" colspan="3"><input name="bornPlace" class="easyui-textbox" style="width: 215px;"></td>
		</tr>
		<tr>
			<td class="form-title">描述</td>
			<td class="form-input" colspan="3"><textarea name="description"></textarea></td>
		</tr>
	</table>
</form>