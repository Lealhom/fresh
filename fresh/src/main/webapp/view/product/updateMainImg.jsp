<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="product/updateMainImg" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${product.id }">
	<table class="formtable">
		<tr>
			<td class="form-title">图片</td>
			<td class="form-input">
				<input type="file" name="file">
			</td>
		</tr>
	</table>
</form>