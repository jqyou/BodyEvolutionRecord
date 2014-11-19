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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			boolean isexist = checkUser(request, response);
			if(isexist){
				out.print("true");
			} else {
				out.print("false");
			}
			
		} catch (SQLException e) {
			out.print("false");
			e.printStackTrace();
		}
	}
	
	boolean checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
//		PrintWriter out = response.getWriter();
		String username = request.getParameter("UserName");
		String password =request.getParameter("UserPwD");
		System.out.println(username);
		System.out.println(password);
		HttpSession session = request.getSession();
		ConnectDB connect = new ConnectDB();
		String[] sqlparam = {username,password};
		int[] WhichInt = {0,0};
		ResultSet rsUserID= connect.executeQuery("select * from Login where UserName=? and PwD=?",sqlparam, WhichInt);
		if(rsUserID.next()) {
			session.setAttribute("name", rsUserID.getString("username"));
			return true;
		} else {
			return false;
		}

	}

}

