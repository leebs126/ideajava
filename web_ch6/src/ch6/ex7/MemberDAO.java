package ch6.ex7;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	
	public MemberDAO(){
		try{
			Context ctx=new InitialContext();
			dataFactory=(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList list(){
		ArrayList list=new ArrayList();
		try{
			Connection con=dataFactory.getConnection();
			Statement stmt=con.createStatement();
			
			String query="select * from t_member";
			System.out.println(query);
			ResultSet rs=stmt.executeQuery(query);
			
			while(rs.next()){
				String id=rs.getString("id");
				String name=rs.getString("name");
				int height=rs.getInt("height");
				int weight=rs.getInt("weight");
				int age=rs.getInt("age");
				
				MemberVO data=new MemberVO();
				data.setId(id);
				data.setName(name);
				data.setHeight(height);
				data.setWeight(weight);
				data.setAge(age);
				
				list.add(data);
			}
			
			rs.close();
			stmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return list;
	}

}
