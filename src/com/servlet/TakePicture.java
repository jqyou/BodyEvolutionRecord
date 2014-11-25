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


//import main.ImageProcess;






import main.ImageProcess;

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


	@SuppressWarnings("static-access")
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
		int d=rd.nextInt(500)+1;
		//int e=rd.nextInt(700)+1;
		String ranStr = String.valueOf(c);  
		String ranStr1=String.valueOf(d);
	//	String ranStr2=String.valueOf(e);
		String username=session.getAttribute("name").toString() ;
		String imageName = username +ranStr+"pic.jpg";//随机生成照片路径，区分用户
		String imagefaceName=username+ranStr1+"picline.jpg";//勾出轮廓后照片的路径
	//	String facefaceName=username+ranStr2+"picface.jpg";//勾出轮廓后照片的路径
		
		String relativePath = getServletContext().getContextPath() + "/IMAGE/" + imageName;//存在数据库中的路径
		String relativePath1=getServletContext().getContextPath() + "/IMAGE/" + imagefaceName;
	//	String relativePath2=getServletContext().getContextPath() + "/IMAGE/" + facefaceName;

		System.out.println(relativePath);
		System.out.println(relativePath1);
	//	System.out.println(relativePath2);
	//	String path = request.getParameter("relativepath");
		

		
		String[] sqlparam = {username,relativePath,relativePath1};
		String[] sqlparam1 = {relativePath,username};
		String[] sqlparam2 = {relativePath1,username};
	//	String[] sqlparam3 = {relativePath2,username};
		int[] WhichInt = {0,0,0};
		int[] WhichInt1={0,0};
		int[] WhichInt2={0,0};
	//	int[] WhichInt3={0,0};
		String sqlString = "insert into Picture (UserName,Pic,Picline) values(?,?,?)";
		String sqlString1="update Login set Pic=? where UserName=?";
		String sqlString2="update Login set Picline=? where UserName=?";
	//	String sqlString3="update Login set Picface=? where UserName=?";
		
		ConnectDB connect = new ConnectDB();
		boolean isSuccess = connect.updatesql(sqlString, sqlparam, WhichInt);
		boolean isSuccess1= connect.updatesql(sqlString1, sqlparam1, WhichInt1);
		boolean isSuccess2= connect.updatesql(sqlString2, sqlparam2, WhichInt2);
	//	boolean isSuccess3= connect.updatesql(sqlString3, sqlparam3, WhichInt3);
		
		if(isSuccess&&isSuccess1&&isSuccess2){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		String obsolutelyPath = getServletContext().getRealPath("IMAGE")+File.separatorChar + imageName;
		System.out.println(obsolutelyPath);
		String obsolutelyPath1 = getServletContext().getRealPath("IMAGE")+File.separatorChar + imagefaceName; 
		System.out.println(obsolutelyPath1);
	//	String obsolutelyPath2 = getServletContext().getRealPath("IMAGE")+File.separatorChar + facefaceName; 
	//	System.out.println(obsolutelyPath2);

		String imageString = request.getParameter("img");	
		if (imageString.equals("") || imageString == null)
			System.out.println("null");
		
		try{
			BASE64Decoder decoder = new BASE64Decoder();
			OutputStream  writes = new FileOutputStream(obsolutelyPath);
		//	OutputStream  writes1 = new FileOutputStream(obsolutelyPath1);
	        
	        byte[] decoderBytes = decoder.decodeBuffer(imageString);
	        for (int i = 0; i < decoderBytes.length; i++) {
	        	if(decoderBytes[i]<0){//调整异常数据
	        		decoderBytes[i]+=256;
                }
			}
	        writes.write(decoderBytes);
	        writes.flush();
	        writes.close();
	    
	      /*  writes1.write(decoderBytes);
	        writes1.flush();
	        writes1.close();*/
	        System.out.println("Decoding the picture Success");
	        
	       // ImageProcess ip=new ImageProcess();//处理图像
	        //ip.run(obsolutelyPath, obsolutelyPath1);
	    
	       ImageProcess IP=new ImageProcess();
	       IP.run(obsolutelyPath,obsolutelyPath1);
	  //     ImageProcess IP1=new ImageProcess();
	   //    IP1.facerun(obsolutelyPath, obsolutelyPath2);
	       
	        
	        out.print("OK");
            
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
        }
		connect.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
