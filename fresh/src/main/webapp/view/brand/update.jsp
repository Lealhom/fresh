<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="brand/update">
	<input type="hidden" name="id" value="${brand.id }">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input"><input name="name" value="${brand.name }" class="easyui-validatebox textbox" data-options="required:true,validType:'length[2,10]'"></td>
		</tr>
		<tr>
			<td class="form-title">描述</td>
			<td class="form-input"><textarea name="description">${brand.description }</textarea></td>
		</tr>
	</table>
</form>