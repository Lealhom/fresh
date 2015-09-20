<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" charset="utf-8">
function changeClock()  
{  
    var d = new Date();  
	 var year = d.getFullYear();
	 var month = d.getMonth() + 1;
	 var day = d.getDate();
	 var hour = d.getHours();
	 var minute = d.getMinutes();
	 var second = d.getSeconds();
	 if(month<10){
		 month = "0"+month;
	 }
	 if(day<10){
		 day = "0"+day;
	 }
	 if(hour<10){
		 hour = "0"+hour;
	 }
	 if(minute<10){
		 minute = "0"+minute;
	 }
	 if(second<10){
		 second = "0"+second;
	 }
    document.getElementById("clock").innerHTML = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;  

}  
window.setInterval(changeClock, 1000);  
function logout() {
	$.messager.confirm('注销','您确定要退出么?',function(r){
		if(r){
			window.location.href = "loginout";
		}
	});
	
}
</script>
<style type="text/css">   
    .linear{   
        width:100%;   
        height:100%;   
        background: -ms-linear-gradient(top, #6495ED,  #f6f6f8);        /* IE 10 */
		background:-moz-linear-gradient(top,#6495ED,#f6f6f8);/*火狐*/ 
		background:-webkit-gradient(linear, 0% 0%, 0% 100%,from(#b8c4cb), to(#f6f6f8));/*谷歌*/ 
		background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#fff), to(#0000ff));      /* Safari 4-5, Chrome 1-9*/
		background: -webkit-linear-gradient(top, #fff, #0000ff);   /*Safari5.1 Chrome 10+*/
		background: -o-linear-gradient(top, #fff, #0000ff);  /*Opera 11.10+*/
        overflow: hidden;
        border:0;
        line-height: 20px;
    }   
</style> 
<div class="linear">
	<div class="index_title">
		<b>生鲜超市后台管理系统</b>
	</div>
	<span style="position: absolute; right: 5px; bottom: 0px; ">
		<strong id="clock" style="color: #4F4F4F;margin-right: 20px;"></strong>
		<a href="javascript:void(0);" style="margin-bottom: 5px;padding-right:5px; border-radius:5px;width: 75px; " class="easyui-linkbutton" data-options="iconCls:'icon-back'" onclick="logout()">
			<strong style="color:white;">注销</strong>
		</a>
	</span>
</div>

