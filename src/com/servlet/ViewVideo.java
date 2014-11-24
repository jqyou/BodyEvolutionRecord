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
 * Servlet implementation class ViewVideo
 */
@WebServlet("/ViewVideo")
public class ViewVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewVideo() {
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
		ConnectDB connect = new ConnectDB();
		String[] sqlparam = {username};
		int[] WhichInt = {0};
		ResultSet rsUserID= connect.executeQuery("select Video from Login where UserName=?",sqlparam, WhichInt);
		try {
			if(rsUserID.next()){
				if(rsUserID.getString("Video")!=null){
				
				    out.print(rsUserID.getString("Video"));
				    System.out.println(rsUserID.getString("Video"));
				  
				}
				else{
				
					out.print("");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		

	}
	}


