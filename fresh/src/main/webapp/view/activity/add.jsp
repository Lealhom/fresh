<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="activity/add" enctype="multipart/form-data">
	<table class="formtable">
		<tr>
			<td>名称</td>
			<td><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td>状态</td>
			<td><select class="easyui-combobox" name="status" style="width:80px;">
				<option value="1">正常</option>
				<option value="2">禁用</option>
			</select></td>
		</tr>
		<tr>
			<td>开始时间</td>
			<td><input class="easyui-datetimebox" name="startTime" required style="width:210px"></td>
			<td>结束时间</td>
			<td><input class="easyui-datetimebox" name="endTime" required style="width:210px"></td>
		</tr>
		<tr>
			<td>活动产品</td>
			<td class="form-input" colspan="3">
				<input name="productIds" class="easyui-combogrid validatebox" style="width: 535px;" data-options="
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
				<option value="1">是</option>
				<option value="2">否</option>
			</select></td>
			<td class="form-title">序号</td>
			<td class="form-input"><input name="orderNum" class="easyui-numberspinner" data-options="value:1,min:1"></td>
		</tr>
		<tr>
		<td>是否预售</td>
			<td><select class="easyui-combobox" name="presell" style="width:80px;">
				<option value="2">否</option>
				<option value="1">是</option>
			</select></td>
			<td class="form-title">预付几成</td>
			<td class="form-input"><input name="pre_rate" class="easyui-numberspinner" data-options="value:1,min:1"></td>
		</tr>
		<tr>
			<td class="form-title">图片</td>
			<td class="form-input">
				<input type="file" name="file">
			</td>
		</tr>
		<tr>
			<td>描述</td>
			<td class="form-input" colspan="3"><textarea name="description"></textarea></td>
		</tr>
		<tr>
			<td class="form-input" colspan="4">banner图片尺寸640*640，其他活动图片尺寸640*240</td>
		</tr>
	</table>
</form>