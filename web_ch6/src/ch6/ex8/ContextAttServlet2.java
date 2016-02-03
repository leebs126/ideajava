package ch6.ex8;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


@WebServlet("/cget")
public class ContextAttServlet2 extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		
		ServletContext context = getServletContext();				 //ServletContext 객체를 얻어온다.
		ArrayList member = (ArrayList)context.getAttribute("member");    //data 키의 값을 list에 할당한다.
		String name = (String)member.get(0);
		int age = (Integer)member.get(1);

		context.log("저장이름은 >>"+name +" 나이는>>" + age);    //컨테이너 로그 파일에 저장한다.

		out.print("<html><body>");
		out.print(name +"<br>");
		out.print(age + "<br>");
		out.print("</body></html>");

	} //end doGet()
} //end class