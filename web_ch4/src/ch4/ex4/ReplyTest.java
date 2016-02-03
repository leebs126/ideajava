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
		System.out.println("init 메서드 호출");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("utf-8");   //한글 처리를 가능하게 설정한다.
		response.setContentType("text/html;charset=utf-8");  //응답 화면에 한글 출력이 가능하도록 설정한다.
		PrintWriter out = response.getWriter();		
		
		String id = request.getParameter("user_id");  
		String pw = request.getParameter("user_pw");  
		
		System.out.println("아이디   : "+ id);  //consolr에 출력한다.
		System.out.println("패스워드 : "+ pw);
		
		if(id!= null &&(id.length()!=0)){

			out.print("<html>");  //브라우저에 출력하기 위해서 HTML 방식으로 데이터를 전송한다.
			out.print("<body>");
			out.print( id +" 님!! 로그인 하셨습니다." );
			out.print("</html>");
			out.print("</body>");
		}else{
			out.print("<html>");  //브라우저에 출력하기 위해서 HTML 방식으로 데이터를 전송한다.
			out.print("<body>");
			out.print("이름을 입력하세요!!!" ) ;
			out.print("<br>");
			out.print("<a href='http://localhost:8090/web_ch4/loginTest.html'>로그인창으로 이동  </a>");
			out.print("</html>");
			out.print("</body>");
		}
	}

	public void destroy(){
		System.out.println("destroy 메서드 호출");
	}
}
