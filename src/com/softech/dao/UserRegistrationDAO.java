package com.softech.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



import com.softech.model.UsersRegistration;

public class UserRegistrationDAO {
 static String provider="jdbc:mysql://localhost:3306/intranetmessaging";	
	
public static boolean addNewrecord(UsersRegistration U)
{ try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="insert into user values("+U.getUserId()+",'"+U.getUserName()+"','"+U.getBirthDate()+"','"+U.getGender()+"','"+U.getEmailId()+"','"+U.getPassword()+"')";
	System.out.println(query);
	boolean st=DBHelper.executeUpdate(cn, query);
	
	return(st);
	
}catch(Exception e){
return(false);	
}	
}
public static boolean checkUserId(String uid)
{ try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from user where userId='"+uid+"'";
	System.out.println(query);
	ResultSet rs=DBHelper.executeQuery(cn, query);
	if(rs.next())
	{ return true;}
	else
	{return false;}

	
}catch(Exception e){
	System.out.println(e);
return(false);	
	
}}
	
	public static UsersRegistration checkUserLogin(String uid,String password){
		try{Class.forName("com.mysql.jdbc.Driver");
			Connection cn=DriverManager.getConnection(provider,"root","123");
			String query="select * from user where userId='"+uid+"'and password='"+password+"'";
			ResultSet rs=DBHelper.executeQuery(cn, query);
			if(rs.next()){
				UsersRegistration u=new UsersRegistration();
				u.setUserId(rs.getString(1));
				u.setUserName(rs.getString(2));
				u.setBirthDate(rs.getString(3));
				u.setGender(rs.getString(4));
				u.setEmailId(rs.getString(5));
				return(u);
				
			}else{
				return(null);
			}		
		}catch(Exception e){
			return(null);
		}
	}

	public static boolean changePassword(String uid,String op,String up)
	{ try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="select * from user where userId='"+uid+"'and password='"+op+"'";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		if(rs.next())
		{ rs.close();
		query="update user set password='"+up+"' where userid='"+uid+"'";
		System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn,query);
	      return st;
		}
		else
		{return false;}

		
	}catch(Exception e){
		System.out.println(e);
	return(false);	
		
	}}
	public static ResultSet friendslist(String pat){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,"root","123");
			System.out.println(pat+"qw1");
			String query = "select userName,userId from user where userName like '%"+pat+"%'";
			ResultSet rs =DBHelper.executeQuery(cn, query);
			return(rs);
		}catch(Exception e){
			System.out.println(e);
			return(null);
		}
	}

}
