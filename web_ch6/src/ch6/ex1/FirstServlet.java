package ch6.ex1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

/*@WebServlet("/first")*/
public class FirstServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		response.sendRedirect("second");

		//RequestDispatcher dispatch = request.getRequestDispatcher("second");  
		//dispatch.forward(request, response);
	}
}

