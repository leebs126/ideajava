package ch5.ex4;

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
	
	public void addMember(MemberVO vo) {
		try{
			Connection con=dataFactory.getConnection();
			Statement stmt=con.createStatement();
			
			String id=vo.getId();
			String name=vo.getName();
			int height=vo.getHeight();
			int weight=vo.getWeight();
			int age=vo.getAge();
			String query="insert into t_member";
			query+= " (id,name,height,weight,age)";
			query+=" values('"+id+"','";
			query+=name+"',";
			query+=height+",";
			query+=weight+",";
			query+=age+")";
			System.out.println(query);
			stmt.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void delMember(MemberVO vo) {
		try{
			Connection con=dataFactory.getConnection();
			Statement stmt=con.createStatement();
			String id=vo.getId();
			String query="delete from t_member";
			query+=" where id='"+id+"'";
			System.out.println(query);
			stmt.executeUpdate(query);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
