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
		System.out.println("init �޼��� ȣ��");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //���� ȭ�鿡 �ѱ� ����� �����ϵ��� �����Ѵ�.
		PrintWriter out = response.getWriter();				  //�����͸� ����� �� �ִ� ��Ʈ���� ���´�.
		
		String operand1=request.getParameter("operand1");
		String operand2=request.getParameter("operand2");
		String operation=request.getParameter("operation");
		
		String result=calculate(operand1,operand2,operation);
		
		String data="<html>";
		data+="�����:"+"<br>";
		data+=result+"<br>";
		
		out.print(data);
		
	}

	public void destroy() {
		System.out.println("destroy �޼��� ȣ��");
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
