package com.servlet;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javabeans.ConnectDB;

import sun.misc.BASE64Decoder;



/**
 * Servlet implementation class TakePicture
 */
@WebServlet("/TakePicture")
public class TakePicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TakePicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		File file =new File(getServletContext().getRealPath("/") + "IMAGE");  
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
		Random rd = new Random();   
		int c = rd.nextInt(1000)+1;   
		String ranStr = String.valueOf(c);  
		String username=session.getAttribute("name").toString() ;
		String imageName = username +ranStr+"pic.jpg";//随机生成照片路径，区分用户
		
		String relativePath = getServletContext().getContextPath() + "/IMAGE/" + imageName;//存在数据库中的路径
		System.out.println(relativePath);
	//	String path = request.getParameter("relativepath");

		
		String[] sqlparam = {username,relativePath};
		String[] sqlparam1 = {relativePath,username};
		int[] WhichInt = {0,0};
		int[] WhichInt1={0,0};
		String sqlString = "insert into Picture (UserName,Pic) values(?,?)";
		String sqlString1="update Login set Pic=? where UserName=?";
		
		ConnectDB connect = new ConnectDB();
		boolean isSuccess = connect.updatesql(sqlString, sqlparam, WhichInt);
		boolean isSuccess1= connect.updatesql(sqlString1, sqlparam1, WhichInt1);
		
		if(isSuccess&&isSuccess1){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		String obsolutelyPath = getServletContext().getRealPath("IMAGE")+File.separatorChar + imageName;
		

		String imageString = request.getParameter("img");	
		if (imageString.equals("") || imageString == null)
			System.out.println("null");
		
		try{
			BASE64Decoder decoder = new BASE64Decoder();
			OutputStream  writes = new FileOutputStream(obsolutelyPath);
	        
	        byte[] decoderBytes = decoder.decodeBuffer(imageString);
	        for (int i = 0; i < decoderBytes.length; i++) {
	        	if(decoderBytes[i]<0){//调整异常数据
	        		decoderBytes[i]+=256;
                }
			}
	        writes.write(decoderBytes);
	        writes.flush();
	        writes.close();
	        System.out.println("Decoding the picture Success");
	        out.print("OK");
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
