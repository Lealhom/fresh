<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="category/update">
	<input type="hidden" name="id" value="${category.id }">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input"><input name="name" value="${category.name }" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
		</tr>
	</table>
</form>