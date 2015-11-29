<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="sku/updateViceImg" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${sku.id }">
	<table class="formtable">
		<tr>
			<td class="form-title">图片</td>
			<td class="form-input">
				<input type="file" name="file" multiple="multiple">
			</td>
		</tr>
		<tr>
			<td class="form-input" colspan="2">图片尺寸640*640</td>
		</tr>
	</table>
</form>