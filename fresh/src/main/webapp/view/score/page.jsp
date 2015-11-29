<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset style="width: 400px;">
	<legend align="center">积分配置</legend>
	<div style="text-align: center;">
		<!-- 
		<h2>积分配置</h2>
		<p>积分规则配置</p>
		 -->
		<div style="margin:20px 0;"></div>
		<input class="easyui-numberspinner" style="width:80px;" data-options="
			min:0,
			value:${rate1},
			onChange: function(value){
				$('#score_configration_tip1').text(value);
			}
		"></input>
		<div style="margin:10px 0;">
			规则说明:每消费10元，将得到<span id="score_configration_tip1">${rate1}</span>积分
		</div>
		<div style="margin:20px 0;"></div>
		<input class="easyui-numberspinner" style="width:80px;" data-options="
			min:0,
			value:${rate2},
			onChange: function(value){
				$('#score_configration_tip2').text(value);
			}
		"></input>
		<div style="margin:10px 0;">
			规则说明:每10积分，可以抵用<span id="score_configration_tip2">${rate2}</span>元人民币
		</div>
		<a id="score_configration_save" href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
	</div>
	</fieldset>
</body>

</html>