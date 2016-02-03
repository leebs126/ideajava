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
		System.out.println("init 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //응답 화면에 한글 출력이 가능하도록 설정한다.
		PrintWriter out = response.getWriter();				  //데이터를 출력할 수 있는 스트림을 얻어온다.

		String id = request.getParameter("user_id");  //request 객체에서 userID에 대한 값을 id에 할당한다.
		String pw = request.getParameter("user_pw");  //request 겍체에서 passwd에 대한 값을 pw에 할당한다.

		System.out.println("아이디   : "+ id);  //console에 출력한다.
		System.out.println("패스워드 : "+ pw);

		String data="<html>";  //출력할 데이터를 HTML로 만든다.
		data+="<body>";
		data+="아이디 : " + id ;
		data+="<br>";
		data+="패스워드 : " + pw;
		data+="</html>";
		data+="</body>";
		
		out.print(data);  //브라우저에 출력하기 위해서 HTML 방식으로 데이터를 전송한다.
		
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}
