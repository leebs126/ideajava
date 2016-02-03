package ch6.ex7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMember")
public class ViewServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			 throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		ArrayList member_list=(ArrayList)request.getAttribute("member_list");
		
		out.print("<html><body>");
		out.print("<table border=1><tr>");
		out.print("<td>아이디</td><td>이름</td><td>키 </td><td>체중</td><td>나이</td></tr>");
		for (int i=0; i<member_list.size();i++){
			MemberVO data=(MemberVO)member_list.get(i);
			String id=data.getId();
			String name=data.getName();
			int height=data.getHeight();
			int weight=data.getWeight();
			int age=data.getAge();
			
			out.print("<tr><td>"+id+"</td><td>"+
					            name+"</td><td>"+
								height+"</td><td>"+
								weight+"</td><td>"+
								age+"</td></tr>");		
		}
		
		out.print("</table></body></html>");
				
	}
	
}
