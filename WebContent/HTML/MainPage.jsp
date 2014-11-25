<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Main Page</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="format-detection" content="telephone=no"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <link href="/BodyEvolutionRecord/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="/BodyEvolutionRecord/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="/BodyEvolutionRecord/css/MainPage.css" type="text/css" rel="stylesheet"/>
    <script src="/BodyEvolutionRecord/js/jQuery1.82.js" type="text/javascript"></script>
    <script type="text/javascript">
    $(document).ready(function() {
    	$("#u39").click(function(){
    		window.location.href="/BodyEvolutionRecord/HTML/UserInfo.jsp";
    	});
    	$("#u4").click(function(){
    		window.location.href="/BodyEvolutionRecord/HTML/Login.html";
    	});
    	$("#u2").click(function(){
    		window.location.href="/BodyEvolutionRecord/HTML/TakePicture2.html";
    	});
    	
   
   
      $.post("/BodyEvolutionRecord/MainPage", { }, function (data, status) {      
	    if (status == "success") {  
	    	var strs= new Array(); //定义一数组 
	    	strs=data.split(","); //字符分割 
	    
	    	for (i=0;i<strs.length ;i++ ) 
	    	{ 
	    	
	    	//  $("#u19").append("<div id="testdiv" class="ax_image"/>");
	    	if(i==0){
	    	  $("#u0").append("<img id='u9_img'  class='img' src='"+strs[i]+"'/>");}
	    	if(i==1){
	    		$("#u0").append("<img id='u11'  class='img' src='"+strs[i]+"'/>");
	    	}
	    	if(i==2){
	    		$("#u0").append("<img id='u13'  class='img' src='"+strs[i]+"'/>");
	    	}
	    	if(i==3){
	    		$("#u0").append("<img id='u15'  class='img' src='"+strs[i]+"'/>");
	    	}
	    	if(i==4){
	    		$("#u0").append("<img id='u17'  class='img' src='"+strs[i]+"'/>");
	    	}
	    	if(i==5){
	    		$("#u0").append("<img id='u23'  class='img' src='"+strs[i]+"'/>");
	    	}
	    	if(i==6){
	    		$("#u0").append("<img id='u25'  class='img' src='"+strs[i]+"'/>");
	    	}
	    	if(i==7){
	    		$("#u0").append("<img id='u27'  class='img' src='"+strs[i]+"'/>");
	    	}
	    	 
	    	} 
	    	
           // $("#pictest").remove(); 
            
	    	//$("#u4").append("<img id='pictest' class='img' src='"+data+"'/>");
	       // $("#u4_img").remove();
	    
	    }     
	    else {   
	        alert("获取图片失败");                 
	    }               
	}, "text");

    });
   </script>
  </head>
  <body>
    <div id="base" class="">

      <!-- Unnamed (Shape) -->
      <div id="u0" class="ax_shape">
        <img id="u0_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u0.png"/>
        <!-- Unnamed () -->
        <div id="u1" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u2" class="ax_shape">
        <img id="u2_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u2.png"/>
        <!-- Unnamed () -->
        <div id="u3" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';">Take Picture</span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u4" class="ax_shape">
        <img id="u4_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u4.png"/>
        <!-- Unnamed () -->
        <div id="u5" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';">
          <%if(session.getAttribute("name")==null)
            {
        	  %>Login<%
            }
            else
            	{%><%=session.getAttribute("name").toString() %><%}
          %>
          </span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u6" class="ax_image">
        <img id="u6_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u6.jpg"/>
        <!-- Unnamed () -->
        <div id="u7" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Horizontal Line) -->
      <div id="u8" class="ax_horizontal_line">
        <img id="u8_start" class="img " src="/BodyEvolutionRecord//images/transparent.gif" alt="u8_start"/>
        <img id="u8_end" class="img " src="/BodyEvolutionRecord/images/transparent.gif" alt="u8_end"/>
        <img id="u8_line" class="img " src="/BodyEvolutionRecord/images/MainPage/u8_line.png" alt="u8_line"/>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u9" class="ax_image">
        <img id="u9_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u9.jpg"/>
        <!-- Unnamed () -->
        <div id="u10" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u11" class="ax_image">
        <img id="u11_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u11.jpg"/>
        <!-- Unnamed () -->
        <div id="u12" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u13" class="ax_image">
        <img id="u13_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u13.jpg"/>
        <!-- Unnamed () -->
        <div id="u14" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u15" class="ax_image">
        <img id="u15_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u15.jpg"/>
        <!-- Unnamed () -->
        <div id="u16" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u17" class="ax_image">
        <img id="u17_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u15.jpg"/>
        <!-- Unnamed () -->
        <div id="u18" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
     <!--  <div id="u19" class="ax_image">
        <img id="u19_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u19.png"/>
        Unnamed ()
        <div id="u20" class="text">
          <p><span></span></p>
        </div>
      </div>
 -->
  <!--     Unnamed (Image)
      <div id="u21" class="ax_image">
        <img id="u21_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u21.png"/>
        Unnamed ()
        <div id="u22" class="text">
          <p><span></span></p>
        </div>
      </div> -->

      <!-- Unnamed (Image) -->
      <div id="u23" class="ax_image">
        <img id="u23_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u9.jpg"/>
        <!-- Unnamed () -->
        <div id="u24" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u25" class="ax_image">
        <img id="u25_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u13.jpg"/>
        <!-- Unnamed () -->
        <div id="u26" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u27" class="ax_image">
        <img id="u27_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u11.jpg"/>
        <!-- Unnamed () -->
        <div id="u28" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u29" class="ax_image">
        <img id="u29_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u11.jpg"/>
        <!-- Unnamed () -->
        <div id="u30" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u31" class="ax_image">
        <img id="u31_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u9.jpg"/>
        <!-- Unnamed () -->
        <div id="u32" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u33" class="ax_image">
        <img id="u33_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u13.jpg"/>
        <!-- Unnamed () -->
        <div id="u34" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u35" class="ax_image">
        <img id="u35_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u15.jpg"/>
        <!-- Unnamed () -->
        <div id="u36" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u37" class="ax_image">
        <img id="u37_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u37.png"/>
        <!-- Unnamed () -->
        <div id="u38" class="text">
          <p><span></span></p>
        </div>
      </div>
      
       <!-- Unnamed (Shape) -->
      <div id="u39" class="ax_shape">
        <img id="u39_img" class="img " src="/BodyEvolutionRecord/images/MainPage/u39.png"/>
        <!-- Unnamed () -->
        <div id="u40" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';">MyPage</span></p>
        </div>
      </div>
    </div>
  </body>
</html>
