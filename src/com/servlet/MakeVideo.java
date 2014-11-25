package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.ImageProcess;

import com.javabeans.ConnectDB;

/**
 * Servlet implementation class MakeVideo
 */
@WebServlet("/MakeVideo")
public class MakeVideo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeVideo() {
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
		PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
       
		File file =new File(getServletContext().getRealPath("/") + "video");  
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("//不存在");
		    //file.setWritable(true, false);
		    System.out.println(file .mkdir());    
		} else   
		{  
		    System.out.println("//目录存在");  
		}

		
		HttpSession session = request.getSession();
		
		String username=session.getAttribute("name").toString() ;
		Random rd = new Random();   
		int c = rd.nextInt(1000)+1; 
		String ranStr = String.valueOf(c);
		String VideoName = username +ranStr+".mp4";
		String relativePath = getServletContext().getContextPath() + "/video/" + VideoName;
		System.out.println(relativePath);

		String[] sqlparam = {username,relativePath};
		String[] sqlparam1 = {relativePath,username};
	
		int[] WhichInt = {0,0};
		int[] WhichInt1={0,0};

		String sqlString = "insert into Video (UserName,VideoPath) values(?,?)";
		String sqlString1="update Login set Video=? where UserName=?";
		
		ConnectDB connect = new ConnectDB();
		boolean isSuccess = connect.updatesql(sqlString, sqlparam, WhichInt);
		boolean isSuccess1= connect.updatesql(sqlString1, sqlparam1, WhichInt1);
		if(isSuccess&&isSuccess1){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		String obsolutelyPath = getServletContext().getRealPath("video")+File.separatorChar + VideoName;
		System.out.println(obsolutelyPath);

	//	String videoString = request.getParameter("video");	
    //		if (videoString.equals("") || videoString == null)
	//		System.out.println("null");
		
		ImageProcess IP=new ImageProcess();
		Vector<String> pics = new Vector<String>();
		String[] sqlparam2={username};
		int[] WhichInt2={0};
		ResultSet rsUserID= connect.executeQuery("select Picline from Picture where UserName=?",sqlparam2, WhichInt2);
		

	
		
		try {
			while(rsUserID.next()){
				if(rsUserID.getString("Picline")!=null){
				
					pics.add("/Users/Daisy/Documents/workspaceforEE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps"+rsUserID.getString("Picline"));
				    System.out.println("/Users/Daisy/Documents/workspaceforEE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps"+rsUserID.getString("Picline"));
				  
				}
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		

		IP.sequenceVideo(pics, obsolutelyPath);
		out.print("OK");
		
		
		
		
		
	}
}


