<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String loginMsg = (String)session.getAttribute("loginMsg");
	if(loginMsg==null){
		loginMsg="";
	}
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>登录页面</title>
<link href="static/css/login.css" rel="stylesheet" type="text/css"/>
<script src="static/js/jquery.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(function(){
	$(document).keyup(function(e){ 
		console.log(111)
		var curKey = e.which;    
		if(curKey==13){
			login();
		}
	})
});

function login(){
	if($("#username").val()==""){
		$("#loginTip").html("请输入用户名");
		return;
	}else if($("#password").val()==""){
		$("#loginTip").html("请输入密码");
		return;
	}else{
		$("#loginTip").html("");
		$("#loginForm").submit();
	}
}
</script>
<body id=userlogin_body>
	<div class="user_system_title">
		<font>生鲜超市后台管理系统</font>
	</div>
	<div id=user_login>
		<dl>
			<dd id=user_top>
				<ul>
					<li class=user_top_l></li>
					<li class=user_top_c></li>
					<li class=user_top_r></li>
				</ul>
			</dd>
			<dd id=user_main>
				<ul>
					<li class=user_main_l></li>
					<li class=user_main_c>
						<form id="loginForm" action="login" method="post">
							<div class=user_main_box>
								<ul>
									<li class=user_main_text>用户名：</li>
									<li class=user_main_input>
										<input class=username_input id=username name=username>
									</li>
								</ul>
								<ul>
									<li class=user_main_text>密&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
									<li class=user_main_input>
										<div class="password_div">
											<input class=password_input id=password type=password name=password>
										</div>
									</li>
								</ul>
								<ul>
									<li class="user_login_tip">
										<font class="user_login_tip"  id="loginTip"><%=loginMsg %></font>
									</li>
								</ul>
							</div>
						</form>
					</li>
					<li class=user_main_r><input class=login_button onclick="login()" type=image src="static/images/login/user_button.gif" >
					</li>
				</ul>
			</dd>
			<dd id=user_bottom>
				<ul>
					<li class=user_bottom_l></li>
					<li class=user_bottom_c></li>
					<li class=user_bottom_r></li>
				</ul>
			</dd>
		</dl>
	</div>
</body>
</html>
