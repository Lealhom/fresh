<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="product/update">
	<input type="hidden" name="id" value="${product.id }">
	<table class="formtable"> 
		<tr>
			<td class="form-title">名称</td>
			<td><input name="name"  value="${product.name }" class="easyui-validatebox textbox" data-options="required:true,validType:'length[1,20]'"></td>
			<td class="form-title">状态</td>
			<td><select class="easyui-combobox" name="status" style="width:220px;" >
				<option value="1" ${product.status == 1 ? 'selected' : '' }>上架</option>
				<option value="2" ${product.status == 2 ? 'selected' : '' }>下架</option>
			</select></td>
		</tr>
		<tr>
			<td class="form-title">品类</td>
			<td class="form-input">
				<input id = "categoryIds" name="categoryIds" value="${product.categoryNames}" class="easyui-combogrid" style="width: 220px;" data-options="
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
				<input name="brandId" value="${product.brandId == 0 ? '' : product.brandId}" class="easyui-combogrid" style="width: 220px;" data-options="
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
			<td class="form-title">产地</td>
			<td class="form-input" colspan="3"><input name="bornPlace"  value="${product.bornPlace }" class="easyui-textbox" style="width: 215px;"></td>
		</tr>
		<tr>
			<td class="form-title">描述</td>
			<td class="form-input" colspan="3"><textarea name="description">${product.description }</textarea></td>
		</tr>
	</table>
</form>