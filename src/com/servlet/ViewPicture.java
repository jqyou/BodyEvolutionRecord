package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	
	//	HttpSession session = request.getSession();
		ConnectDB connect = new ConnectDB();
		String[] sqlparam = {username};
		int[] WhichInt = {0,0};
		ResultSet rsUserID= connect.executeQuery("select Pic,Picline from Login where UserName=?",sqlparam, WhichInt);
		try {
			if(rsUserID.next()){
				if(rsUserID.getString("Pic")!=null&&rsUserID.getString("Picline")!=null){
				 //   session.setAttribute("pic", rsUserID.getString("Pic"));
				    out.print(rsUserID.getString("Pic")+","+rsUserID.getString("Picline"));
				    System.out.println(rsUserID.getString("Pic"));
				    System.out.println(rsUserID.getString("Picline"));
				}
				else{
					//session.setAttribute("pic", "/BodyEvolutionRecord/images/userinfor/u4.png");
					out.print("/BodyEvolutionRecord/images/userinfor/u4.png"+","+"/BodyEvolutionRecord/images/userinfor/u4.png");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		

	}

}
