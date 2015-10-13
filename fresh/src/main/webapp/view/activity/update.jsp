<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="activity/update">
	<input type="hidden" name="id" value="${activity.id }">
	<table class="formtable">
		<tr>
			<td>名称</td>
			<td><input name="name" value="${activity.name }" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td>状态</td>
			<td><select class="easyui-combobox" name="status" style="width:80px;">
				<option value="1" ${activity.status == 1 ? 'selected' : '' } >正常</option>
				<option value="2" ${activity.status == 2 ? 'selected' : '' }>禁用</option>
			</select></td>
		</tr>
		<tr>
			<td>开始时间</td>
			<td><input class="easyui-datetimebox" name="startTime" value="${activity.startTime}" required style="width:210px"></td>
			<td>结束时间</td>
			<td><input class="easyui-datetimebox" name="endTime" value="${activity.endTime}" required style="width:210px"></td>
		</tr>
		<tr>
			<td>活动产品</td>
			<td class="form-input" colspan="3">
				<input name="productIds"  value="${activity.productNames}" class="easyui-combogrid validatebox" style="width: 535px;" data-options="
				required:true,
				multiple:true,
				panelWidth: 535,
				idField: 'id',
				textField: 'name',
				url: 'product/paged',
				method: 'get',
				columns: [[
					{field:'id',title:'ID',width:60}, 
					{field:'name',title:'产品名称',width:408}
				]]
			">
			</td>
		</tr>
		<tr>
		<td>是否banner</td>
			<td><select class="easyui-combobox" name="banner" style="width:80px;">
				<option value="1" ${activity.banner == 1 ? 'selected' : '' }>是</option>
				<option value="2" ${activity.banner == 2 ? 'selected' : '' }>否</option>
			</select></td>
			<td class="form-title">序号</td>
			<td class="form-input"><input name="orderNum" class="easyui-numberspinner" data-options="value:1,min:1"></td>
		</tr>
		<tr>
			<td>描述</td>
			<td class="form-input" colspan="3"><textarea name="description" >${activity.description}</textarea></td>
		</tr>
	</table>
</form>