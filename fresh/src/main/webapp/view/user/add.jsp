<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form method="post" action="user/add">
	<table class="formtable">
		<tr>
			<td class="form-title">用户名</td>
			<td class="form-input"><input name="username" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td class="form-title">显示名</td>
			<td class="form-input"><input name="name" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
		</tr>
		<tr>
			<td class="form-title">密码</td>
			<td class="form-input"><input name="password" type="password" class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
			<td class="form-title">确认密码</td>
			<td class="form-input"><input name="passwordConfirm" type="password"  class="easyui-validatebox textbox" data-options="required:true,validType:'length[3,10]'"></td>
		</tr>
		<tr>
			<td class="form-title">联系方式</td>
			<td class="form-input"><input name="phone" class="easyui-validatebox textbox" data-options="required:true"></td>
			<td class="form-title">邮箱</td>
			<td class="form-input"><input name="email" class="easyui-validatebox textbox" data-options="required:true,validType:'email'"></td>
		</tr>
		<tr>
			<td class="form-title">类型</td>
			<td class="form-input">
				<select class="easyui-combobox" name="type" style="width:200px;">
					<option value="1" >普通</option>
					<option value="2">系统管理员</option>
				</select>
			</td>
			<td class="form-title">状态</td>
			<td class="form-input"><select class="easyui-combobox" name="status" style="width:200px;">
				<option value="1">正常</option>
				<option value="2">禁用</option>
			</select></td>
		</tr>
		<tr>
			<td class="form-title">性别</td>
			<td class="form-input"><select class="easyui-combobox" name="sex" style="width:200px;">
				<option value="1">男</option>
				<option value="2">女</option>
			</select></td>
			<td class="form-title">年龄</td>
			<td class="form-input"><input name="age" class="easyui-numberspinner" data-options="value:0,min:0"></td>
		</tr>
	</table>
</form>