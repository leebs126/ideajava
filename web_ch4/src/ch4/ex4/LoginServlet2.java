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
		System.out.println("init �޼��� ȣ��");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");   
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter();		
		String id = request.getParameter("user_id");  
		String pw = request.getParameter("user_pw"); 
		String address=request.getParameter("user_address");
		System.out.println("���̵�   : "+ id);  
		System.out.println("�н����� : "+ pw);
		
		String data="<html>";  
		data+="<body>";
		data+="���̵� : " + id ;
		data+="<br>";
		data+="�н����� : " + pw;
		data+="<br>";
		data+="�ּ� : " + address;
		data+="</html>";
		data+="</body>";
		
		out.print(data);
	}

	public void destroy(){
		System.out.println("destroy �޼��� ȣ��");
	}
}
