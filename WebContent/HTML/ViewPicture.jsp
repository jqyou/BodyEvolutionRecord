<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/BodyEvolutionRecord/css/axure_rp_page.css" type="text/css"
	rel="stylesheet" />
<link href="/BodyEvolutionRecord/data/styles.css" type="text/css"
	rel="stylesheet" />
<link href="/BodyEvolutionRecord/css/TakePicture2.css" type="text/css"
	rel="stylesheet" />
<script src="/BodyEvolutionRecord/js/jQuery1.82.js"
	type="text/javascript"></script>
<script type="text/javascript">


$(document).ready(function() {
	$("#u8").click(function () {
		$.post("/BodyEvolutionRecord/ViewPicture", { }, function (data, status) {      
		    if (status == "success") {      
                $("#pictest").remove(); 
                
		    	$("#u4").append("<img id='pictest' class='img' src='"+data+"'/>");
		        $("#u4_img").remove();
		    
		    }     
		    else {   
		        alert("获取图片失败");                 
		    }               
		}, "text");
	});
});  
</script>


<title>Picture</title>
</head>
<body>
	<!-- Unnamed (Image) -->
	<div id="u4" class="ax_image">
		<img id="u4_img" class="img "
			src="/BodyEvolutionRecord/images/TakePhoto/u4.png" />
		<!-- Unnamed () -->
		<div id="u5" class="text">
			<p>
				<span></span>
			</p>
		</div>
	</div>
	<div id="u8" class="ax_shape">
		<img id="u8_img" class="img "
			src="/BodyEvolutionRecord/images/TakePhoto/u6.png" />
		<!-- Unnamed () -->
		<div id="u9" class="text">
			<p>
				<span
					style="font-family: 'ArialHebrewScholar', 'Arial Hebrew Scholar';">View</span>
			</p>
		</div>
	</div>
</body>
</html>