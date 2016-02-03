package ch4.ex3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class CalcServlet  extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //응답 화면에 한글 출력이 가능하도록 설정한다.
		PrintWriter out = response.getWriter();				  //데이터를 출력할 수 있는 스트림을 얻어온다.
		
		String operand1=request.getParameter("operand1");
		String operand2=request.getParameter("operand2");
		String operation=request.getParameter("operation");
		
		String result=calculate(operand1,operand2,operation);
		
		String data="<html>";
		data+="결과값:"+"<br>";
		data+=result+"<br>";
		
		out.print(data);
		
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
	
	private String calculate(String operand1,String operand2,String operation){
		float result=0f;
		float value1=Float.parseFloat(operand1);
		float value2=Float.parseFloat(operand2);
		
		if(operation.equals("add")){
			result=value1+value2;
			
		}else if(operation.equals("subtract")){
			result=value1-value2;
		}else if(operation.equals("multiply")){
			result=value1*value2;
		}else if(operation.equals("divide")){
			result=value1/value2;
		}
		
		
		return Float.toString(result);
		
	}

}
