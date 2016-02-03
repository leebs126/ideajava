package ch5.ex1;

import java.sql.*;
import java.util.*;

public class MemberDAO{
	private static final String driver="oracle.jdbc.driver.OracleDriver";  //상수에 DB연결 관련 데이터를 세팅한다.
	private static final String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "scott";
	private static final String pwd="tiger";
	
	private Connection con;  //DB연결에 사용되는 객체를  선언한다.
    private	Statement stmt;
    private ResultSet rs;	

	public ArrayList list(){   
	  ArrayList list =  new ArrayList();
	  try{			
			connDB();  //DB와 연결하는 메서드 
			String query = "select * from t_member ";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery( query);	//쿼리를 실행한 후 리턴되는 레코드 셋을 rs에 저장한다.		 

			 while( rs.next() ){				        //rs의 레코드셋을 변수에 할당한다.
				 String id=rs.getString("id");
				String name = rs.getString("name");
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				int age = rs.getInt("age");

				MemberVO data = new MemberVO();     //VO객체를 생성한다.
				data.setId(id); 
				data.setName(name); 
				data.setName(name);                //변수값을 VO객체의 멤버변수에 세팅한다.
				data.setHeight(height);
				data.setWeight(weight);
				data.setAge(age);
				
				list.add( data);					//list에 VO객체를 추가한다.
			} //end while 
			rs.close();
			stmt.close();
			con.close();
	  }catch(Exception e){
		e.printStackTrace();	
	  }

	  return list;
	} //end list()

	public void connDB(){
		try{
			Class.forName(driver);  
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");

			stmt = con.createStatement();
			System.out.println("Statement 생성 성공");		
		}catch(Exception e){
		e.printStackTrace();	
		}
	}
}//end class MemberDAO

