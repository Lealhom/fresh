<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="file/add" enctype="multipart/form-data">
	<table class="formtable">
		<tr>
			<td class="form-title">名称</td>
			<td class="form-input"><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[1,10]'"></td>
		</tr>
		<tr>
			<td class="form-title">文件</td>
			<td class="form-input"><input name="file" class="easyui-filebox" data-options="required:true" style="width: 400px;"></td>
		</tr>
	</table>
</form>