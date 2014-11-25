package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.ImageProcess;

import com.javabeans.ConnectDB;

/**
 * Servlet implementation class ViewPicture
 */
@WebServlet("/ViewPicture")
public class ViewPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//String pic =request.getParameter("Pic");

	
		//System.out.println(pic);
		PrintWriter out = response.getWriter();
	//	PrintWriter out1=response.getWriter();
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		String username = request.getSession().getAttribute("name").toString();
		System.out.println(username);
		Random rd = new Random();  
		int e=rd.nextInt(700)+1;
		String ranStr2=String.valueOf(e);
		String facefaceName=username+ranStr2+"picface.jpg";//勾出人脸的照片的路径
		String relativePath2=getServletContext().getContextPath() + "/IMAGE/" + facefaceName;
		System.out.println(relativePath2);
		
		String[] sqlparam3 = {relativePath2,username};
	//	String originalpath="";
		String[] sqlparam4={username};
		int[] WhichInt1={0,0};
		int[] WhichInt3={0,0};
		int[] WhichInt4={0};
		String sqlString3="update Login set Picface=? where UserName=?";
		String sqlString1 = "update  Picture set Picface=? where Pic=?";
		//String sqlString4="select Pic from Login where UserName=?";
		ConnectDB connect = new ConnectDB();
	//	boolean isSuccess3= connect.updatesql(sqlString3, sqlparam3, WhichInt3);
		//boolean isSuccess4= connect.updatesql(sqlString4, sqlparam4, WhichInt4);
		String obsolutelyPath2 = getServletContext().getRealPath("IMAGE")+File.separatorChar + facefaceName; 
		
		String temp="/Users/Daisy/Documents/workspaceforEE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps";
	/*	if(isSuccess3){
			System.out.println("true");
		} else {
			System.out.println("false");
		}*/
		ResultSet rsUserID1= connect.executeQuery("select Pic from Login where UserName=?",sqlparam4, WhichInt4);
		try {
			if(rsUserID1.next()){
				if(rsUserID1.getString("Pic")!=null){
				 //   session.setAttribute("pic", rsUserID.getString("Pic"));
					 
					 String[] sqlparam1= {relativePath2,rsUserID1.getString("Pic")};
					 ImageProcess IP=new ImageProcess();
					 
					
					 System.out.println(temp+rsUserID1.getString("Pic"));
					 System.out.println(obsolutelyPath2);
					 boolean isSuccess3= connect.updatesql(sqlString3, sqlparam3, WhichInt3);
					 boolean isSuccess= connect.updatesql(sqlString1, sqlparam1, WhichInt1);
					 IP.facerun(temp+rsUserID1.getString("Pic"), obsolutelyPath2);
				//	 IP.facerun("/Users/Daisy/Documents/workspaceforEE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BodyEvolutionRecord/IMAGE/Daisy776pic.jpg",  obsolutelyPath2);
				

						if(isSuccess&&isSuccess3){
							System.out.println("true");
						} else {
							System.out.println("false");
						}
				  
				}
				else{
					System.out.println("No picture");
					//session.setAttribute("pic", "/BodyEvolutionRecord/images/userinfor/u4.png");
					//out.print("/BodyEvolutionRecord/images/userinfor/u4.png"+","+"/BodyEvolutionRecord/images/userinfor/u4.png"+"/BodyEvolutionRecord/images/userinfor/u4.png");
				}
			}
		} catch (SQLException e6) {
			// TODO Auto-generated catch block
			
			e6.printStackTrace();
		}
		
	connect.closeConnection();
		
		
		
		
	   
	
	//	HttpSession session = request.getSession();
	 ConnectDB connect1 = new ConnectDB();
		String[] sqlparam = {username};
		int[] WhichInt = {0,0,0};
		ResultSet rsUserID= connect1.executeQuery("select Pic,Picline,Picface from Login where UserName=?",sqlparam, WhichInt);
		try {
			if(rsUserID.next()){
				if(rsUserID.getString("Pic")!=null&&rsUserID.getString("Picline")!=null&&rsUserID.getString("Picface")!=null){
				 //   session.setAttribute("pic", rsUserID.getString("Pic"));
				    out.print(rsUserID.getString("Pic")+","+rsUserID.getString("Picline")+","+rsUserID.getString("Picface"));
				    System.out.println(rsUserID.getString("Picface"));
				  
				}
				else{
					//session.setAttribute("pic", "/BodyEvolutionRecord/images/userinfor/u4.png");
					out.print("/BodyEvolutionRecord/images/userinfor/u4.png"+","+"/BodyEvolutionRecord/images/userinfor/u4.png"+"/BodyEvolutionRecord/images/userinfor/u4.png");
				}
			}
		} catch (SQLException e5) {
			// TODO Auto-generated catch block
			
			e5.printStackTrace();
		}
		connect.closeConnection();

	}

}
