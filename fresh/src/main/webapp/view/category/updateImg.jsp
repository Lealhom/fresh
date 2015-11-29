<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="category/updateImg" enctype="multipart/form-data">
	<input type="hidden" name="id" value="${category.id }">
	<input type="hidden" name="level" value="${category.level }">
	<table class="formtable">
		<tr>
			<td class="form-title">图片</td>
			<td class="form-input">
				<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td class="form-input" colspan="2">图片尺寸320*320</td>
		</tr>
	</table>
</form>