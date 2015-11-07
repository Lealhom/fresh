<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="coupon/update">
	<input type="hidden" name="id" value="${coupon.id }">
	<table class="formtable">
		<tr>
			<td>名称</td>
			<td><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td>状态</td>
			<td><select class="easyui-combobox" name="status" style="width:80px;">
				<option value="1">未使用</option>
				<option value="2">已使用</option>
			</select></td>
		</tr>
		<tr>
			<td >现金券金额</td>
			<td class="form-input"><input name="money" class="easyui-numberspinner" data-options="value:0,min:0"></td>
			<td >超过多少可用</td>
			<td class="form-input"><input name="exceedMoney" class="easyui-numberspinner" data-options="value:0,min:0"></td>
		</tr>
		<tr>
			<td>开始时间</td>
			<td><input class="easyui-datetimebox" name="startTime" required style="width:210px"></td>
			<td>结束时间</td>
			<td><input class="easyui-datetimebox" name="endTime" required style="width:210px"></td>
		</tr>
		<tr>
			<td >描述</td>
			<td class="form-input" colspan="3"><textarea name="description"></textarea></td>
		</tr>
	</table>
</form>