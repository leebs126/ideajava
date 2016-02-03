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

		ServletContext context = getServletContext();  //ServletContext ��ü�� ���´�.

		ArrayList member = new ArrayList();
		member.add("�̼���");
		member.add(new Integer(30));  

		context.setAttribute("member", member);  //Context ��ü�� �����͸� ���ε��Ѵ�.

		out.print("<html><body>");
		out.print("�̼��Ű� 30 ����");
		out.print("</body></html>");			

	} //end doGet()
}  //end class