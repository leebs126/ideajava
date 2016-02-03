package ch6.ex7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listMember")
public class MemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		doHandle(request,response);
	}
	
	
	private void doHandle(HttpServletRequest request,HttpServletResponse response)
	 throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		MemberDAO dao=new MemberDAO();
		ArrayList member_list=dao.list();
		
		request.setAttribute("member_list", member_list);
		RequestDispatcher dispatch = request.getRequestDispatcher("viewMember");  
		dispatch.forward(request, response);
	}
}
