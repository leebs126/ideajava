package ch4.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*@WebServlet("/login2")*/
public class LoginServlet  extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("init �޼��� ȣ��");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //���� ȭ�鿡 �ѱ� ����� �����ϵ��� �����Ѵ�.
		PrintWriter out = response.getWriter();				  //�����͸� ����� �� �ִ� ��Ʈ���� ���´�.

		String id = request.getParameter("user_id");  //request ��ü���� userID�� ���� ���� id�� �Ҵ��Ѵ�.
		String pw = request.getParameter("user_pw");  //request ��ü���� passwd�� ���� ���� pw�� �Ҵ��Ѵ�.

		System.out.println("���̵�   : "+ id);  //console�� ����Ѵ�.
		System.out.println("�н����� : "+ pw);

		String data="<html>";  //����� �����͸� HTML�� �����.
		data+="<body>";
		data+="���̵� : " + id ;
		data+="<br>";
		data+="�н����� : " + pw;
		data+="</html>";
		data+="</body>";
		
		out.print(data);  //�������� ����ϱ� ���ؼ� HTML ������� �����͸� �����Ѵ�.
		
	}

	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
	}
}
