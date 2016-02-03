package ch6.ex1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;


/*@WebServlet("/second")*/
public class SecondServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("redirect 방법 실습입니다.");
		out.println("</body></html>");
	}// end doGet()

}