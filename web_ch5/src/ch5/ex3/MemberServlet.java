package ch5.ex3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member3")
public class MemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			 throws IOException,ServletException{
		doHandle(request,response);
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			 throws IOException,ServletException{
		doHandle(request,response);
		
	}
	private void doHandle(HttpServletRequest request,HttpServletResponse response)
	 throws IOException,ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao=new MemberDAO();
		PrintWriter out=response.getWriter();
		String command=request.getParameter("command");
		if(command.equals("addMember")){
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			int height=Integer.parseInt(request.getParameter("height"));
			int weight=Integer.parseInt(request.getParameter("weight"));
			int age=Integer.parseInt(request.getParameter("age"));
			MemberVO vo=new MemberVO();
			vo.setId(id);
			vo.setName(name);
			vo.setHeight(height);
			vo.setWeight(weight);
			vo.setAge(age);
			dao.addMember(vo);
			
		}
		ArrayList list=dao.list();
		out.print("<html><body>");
		out.print("<table border=1><tr>");
		out.print("<td>아이디</td><td>이름</td><td>키 </td><td>체중</td><td>나이</td></tr>");
		for (int i=0; i<list.size();i++){
			MemberVO data=(MemberVO) list.get(i);
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
			out.print("<a href='/web_ch5/addMember.html'>새 회원 등록하기</a");
	
	}

}
