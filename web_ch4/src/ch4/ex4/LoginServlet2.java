package ch4.ex4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet{  
	public void init(){	
		System.out.println("init 메서드 호출");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");   
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();		
		String id = request.getParameter("user_id");  
		String pw = request.getParameter("user_pw"); 
		String address=request.getParameter("user_address");
		System.out.println("아이디   : "+ id);  
		System.out.println("패스워드 : "+ pw);
		
		String data="<html>";  
		data+="<body>";
		data+="아이디 : " + id ;
		data+="<br>";
		data+="패스워드 : " + pw;
		data+="<br>";
		data+="주소 : " + address;
		data+="</html>";
		data+="</body>";
		
		out.print(data);
	}

	public void destroy(){
		System.out.println("destroy 메서드 호출");
	}
}
