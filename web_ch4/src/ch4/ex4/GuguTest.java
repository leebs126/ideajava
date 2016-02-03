package ch4.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guguTest")
public class GuguTest extends HttpServlet{  
	public void init(){	
		System.out.println("init 메서드 호출");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");   //한글 처리를 가능하게 설정한다.
		response.setContentType("text/html;charset=utf-8");  //응답 화면에 한글 출력이 가능하도록 설정한다.
		PrintWriter out = response.getWriter();		
		
		int dan =Integer.parseInt( request.getParameter("dan"));  //request 객체에서 userID에 대한 값을 id에 할당한다.
		
		out.print(" <table border=1 width=800 align=center>");
		 out.print("<tr align=center bgcolor='#FFFF66'>"); 
		 out.print("<td colspan=2>" +  dan+ " 단 출력  </td>");
		 out.print("</tr>");
		  
		  for(int i=1; i<10;i++){ //for문으로 연속적으로 결과를 행으로 출력하라.
		    out.print("<tr align=center>"); 
		    out.print("<td width=400>"); 
		    out.print(dan+" *  "+i );    
		  	out.print("</td>");
		  	out.print("<td width=400>");
		  	 out.print(i*dan); 
		  	out.print("</td>");
		   out.print("</tr>");
		  }

		out.print("</table>");
	}

	public void destroy(){
		System.out.println("destroy 메서드 호출");
	}
}
