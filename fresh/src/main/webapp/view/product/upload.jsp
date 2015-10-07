<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="gbk">
	<title>Document</title>
	<link href="static/css/common.css" rel="stylesheet" type="text/css"/>
	<script src="static/js/require.js" type="text/javascript"></script>
	<script src="static/js/jquery.min.js" type="text/javascript"></script>
</head>
<script>
$(function() {
	
	require(['fileuploader'], function(FileUploader) {
		var options = {
				element:$("#uploadFile")
			}
		FileUploader.newUploader(options);
	});
});
</script>
<body>
	<input type="file" name="img" id="uploadFile" multiple="multiple" />
</body>
</html>

