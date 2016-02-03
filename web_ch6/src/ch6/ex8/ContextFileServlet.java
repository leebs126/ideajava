package ch6.ex8;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


@WebServlet("/cfile")
public class ContextFileServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();

		//ServletContext 객체 얻기
		ServletContext context = getServletContext();
		
		//파일읽기
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

		String s= null;
		String menu_member = null;
		String menu_order = null;
		String menu_goods = null;


		while( (s=buffer.readLine()) !=null){
			StringTokenizer tokens = new StringTokenizer(s, ",");  //&구분자로 파싱한다.
			menu_member=tokens.nextToken();
			menu_order=tokens.nextToken();
			menu_goods=tokens.nextToken();
		}

		out.print("<html><body>");
		out.print(menu_member + "<br>");
		out.print(menu_order+ "<br>");
		out.print(menu_goods + "<br>");
		out.print("</body></html>");
		out.close();
	}//end doGet()
} //end class