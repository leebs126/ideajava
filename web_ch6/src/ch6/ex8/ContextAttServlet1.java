package ch6.ex8;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/cset")
public class ContextAttServlet1 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();

		ServletContext context = getServletContext();  //ServletContext 객체를 얻어온다.

		ArrayList member = new ArrayList();
		member.add("이순신");
		member.add(new Integer(30));  

		context.setAttribute("member", member);  //Context 객체에 데이터를 바인딩한다.

		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("</body></html>");			

	} //end doGet()
}  //end class