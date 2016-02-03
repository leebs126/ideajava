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
		
		ServletContext context = getServletContext();				 //ServletContext ��ü�� ���´�.
		ArrayList member = (ArrayList)context.getAttribute("member");    //data Ű�� ���� list�� �Ҵ��Ѵ�.
		String name = (String)member.get(0);
		int age = (Integer)member.get(1);

		context.log("�����̸��� >>"+name +" ���̴�>>" + age);    //�����̳� �α� ���Ͽ� �����Ѵ�.

		out.print("<html><body>");
		out.print(name +"<br>");
		out.print(age + "<br>");
		out.print("</body></html>");

	} //end doGet()
} //end class