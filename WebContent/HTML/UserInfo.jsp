<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>UserInfo</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="format-detection" content="telephone=no"/>
    <link href="/BodyEvolutionRecord/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="/BodyEvolutionRecord/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="/BodyEvolutionRecord/css/userinfo.css" type="text/css" rel="stylesheet"/>
  </head>
  
  <body>
    <div id="base" class="">

      <!-- Unnamed (Shape) -->
      <div id="u0" class="ax_shape">
        <img id="u0_img" class="img " src="/BodyEvolutionRecord/images/userinfor/u0.png"/>
        <!-- Unnamed () -->
        <div id="u1" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u2" class="ax_image">
        <img id="u2_img" class="img " src="/BodyEvolutionRecord/images/userinfor/u2.jpg"/>
        <!-- Unnamed () -->
        <div id="u3" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Image) -->
      <div id="u4" class="ax_image">
  
        <img id="u4_img" class="img " 
       
        <%if(session.getAttribute("pic")==null)
            {
        	  %>src="/BodyEvolutionRecord/images/userinfor/u4.png"<%
            }
            else
            	{
            	 %>src="<%=session.getAttribute("pic").toString()%>"<%
            	}
          %>/>
        <!-- Unnamed () -->
        <div id="u5" class="text">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u6" class="ax_paragraph">
        <img id="u6_img" class="img " src="/BodyEvolutionRecord/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u7" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';font-weight:400;">UserName</span><span style="font-family:'ArialHebrewScholar-Light', 'Arial Hebrew Scholar Light', 'Arial Hebrew Scholar';font-weight:200;">：</span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u8" class="ax_paragraph">
        <img id="u8_img" class="img " src="/BodyEvolutionRecord/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u9" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';">Email</span><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';">：</span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u10" class="ax_paragraph">
        <img id="u10_img" class="img " src="/BodyEvolutionRecord/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u11" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';font-weight:400;">Phone</span><span style="font-family:'ArialHebrewScholar-Light', 'Arial Hebrew Scholar Light', 'Arial Hebrew Scholar';font-weight:200;">：</span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u12" class="ax_paragraph">
        <img id="u12_img" class="img " src="/BodyEvolutionRecord/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u13" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';" >
          <%=session.getAttribute("name").toString() %>
          </span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u14" class="ax_paragraph">
        <img id="u14_img" class="img " src="/BodyEvolutionRecord/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u15" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';">
         <%=session.getAttribute("email").toString() %>
          </span></p>
        </div>
      </div>

      <!-- Unnamed (Shape) -->
      <div id="u16" class="ax_paragraph">
        <img id="u16_img" class="img " src="/BodyEvolutionRecord/images/transparent.gif"/>
        <!-- Unnamed () -->
        <div id="u17" class="text">
          <p><span style="font-family:'ArialHebrewScholar', 'Arial Hebrew Scholar';">
          <%=session.getAttribute("phone").toString() %>
          </span></p>
        </div>
      </div>
      <!-- Unnamed (Image) -->
      <div id="u19" class="ax_image">
        <img id="u19_img" class="img " src="/BodyEvolutionRecord/images/userinfor/u19.jpg" />
        <!-- Unnamed () -->
        <div id="u20" class="text">
          <p><span></span></p>
        </div>
      </div>


      <!-- Unnamed (Horizontal Line) -->
      <div id="u23" class="ax_horizontal_line">
        <img id="u23_start" class="img " src="/BodyEvolutionRecord/images/transparent.gif" alt="u23_start"/>
        <img id="u23_end" class="img " src="/BodyEvolutionRecord/images/transparent.gif" alt="u23_end"/>
        <img id="u23_line" class="img " src="/BodyEvolutionRecord/images/userinfor/u23_line.png" alt="u23_line"/>
      </div>
    </div>
  </body>
</html>
