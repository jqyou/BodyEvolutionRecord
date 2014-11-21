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

import com.javabeans.ConnectDB;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
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
        PrintWriter out = response.getWriter();
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");


		String username = request.getSession().getAttribute("name").toString();
		System.out.println(username);

	
	//	HttpSession session = request.getSession();
		ConnectDB connect = new ConnectDB();
		String[] sqlparam = {};
		int[] WhichInt = {0};
		ResultSet rsUserID= connect.executeQuery("select Pic from Picture",sqlparam, WhichInt);
		try {
			String result = "";
			while(rsUserID.next()){
				
				 //   session.setAttribute("pic", rsUserID.getString("Pic"));
				    String tempresult=rsUserID.getString("Pic");
				    result = result + "," + tempresult;
				   
				    System.out.println(result);
			}
			if (!result.equals("")){
				result = result.substring(1, result.length() - 1);
			}
			
			out.print(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
	}
}