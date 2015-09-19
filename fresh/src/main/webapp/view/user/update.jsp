<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="user/update">
	<input type="hidden" name="id" value="${user.id }">
	<table class="formtable">
		<tr>
			<td class="form-title">用户名</td>
			<td class="form-input"><input name="username" value="${user.username }" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td class="form-title">显示名</td>
			<td class="form-input"><input name="name" value="${user.name }" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
		</tr>
		<tr>
			<td class="form-title">联系方式</td>
			<td class="form-input"><input name="phone" value="${user.phone }" class="easyui-validatebox textbox" data-options="required:true"></td>
			<td class="form-title">邮箱</td>
			<td class="form-input"><input name="email" value="${user.email }" class="easyui-validatebox textbox" data-options="required:true,validType:'email'"></td>
		</tr>
		<tr>
			<td class="form-title">类型</td>
			<td class="form-input"><select class="easyui-combobox" name="type">
				<option value="1" ${user.type == 1 ? 'selected' : '' }>普通</option>
				<option value="2" ${user.type == 2 ? 'selected' : '' }>系统管理员</option>
			</select></td>
			<td class="form-title">状态</td>
			<td class="form-input"><select class="easyui-combobox" name="status">
				<option value="1" ${user.status == 1 ? 'selected' : '' }>正常</option>
				<option value="2" ${user.status == 2 ? 'selected' : '' }>禁用</option>
			</select></td>
		</tr>
		<tr>
			<td class="form-title">性别</td>
			<td class="form-input"><select class="easyui-combobox" name="sex">
				<option value="1" ${user.sex == 1 ? 'selected' : '' }>男</option>
				<option value="0" ${user.sex == 0 ? 'selected' : '' }>女</option>
			</select></td>
			<td class="form-title">年龄</td>
			<td class="form-input"><input name="age" value="${user.age }" class="easyui-numberspinner" data-options="value:0,min:0"></td>
		</tr>
	</table>
</form>