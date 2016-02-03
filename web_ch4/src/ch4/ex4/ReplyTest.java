package ch4.ex4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*@WebServlet("/replyTest")*/
public class ReplyTest extends HttpServlet{  

	public void init(){	
		System.out.println("init �޼��� ȣ��");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");   //�ѱ� ó���� �����ϰ� �����Ѵ�.
		response.setContentType("text/html;charset=utf-8");  //���� ȭ�鿡 �ѱ� ����� �����ϵ��� �����Ѵ�.
		PrintWriter out = response.getWriter();		
		
		String id = request.getParameter("user_id");  
		String pw = request.getParameter("user_pw");  
		
		System.out.println("���̵�   : "+ id);  //consolr�� ����Ѵ�.
		System.out.println("�н����� : "+ pw);
		
		if(id!= null &&(id.length()!=0)){

			out.print("<html>");  //�������� ����ϱ� ���ؼ� HTML ������� �����͸� �����Ѵ�.
			out.print("<body>");
			out.print( id +" ��!! �α��� �ϼ̽��ϴ�." );
			out.print("</html>");
			out.print("</body>");
		}else{
			out.print("<html>");  //�������� ����ϱ� ���ؼ� HTML ������� �����͸� �����Ѵ�.
			out.print("<body>");
			out.print("�̸��� �Է��ϼ���!!!" ) ;
			out.print("<br>");
			out.print("<a href='http://localhost:8090/web_ch4/loginTest.html'>�α���â���� �̵�  </a>");
			out.print("</html>");
			out.print("</body>");
		}
	}

	public void destroy(){
		System.out.println("destroy �޼��� ȣ��");
	}
}
