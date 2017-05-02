package com.softech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.softech.model.Profile;

public class ProfileDAO{
	static String provider="jdbc:mysql://localhost:3306/intranetmessaging";	

public static boolean addNewRecord(Profile p){
	try{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="insert into profile values('"+p.getUserid()+"','"+p.getAddress()+"','"+p.getState()+"','"+p.getCity()+"','"+p.getStatus()+"','"+p.getWork()+"','"+p.getQualification()+"')";
		boolean st=DBHelper.executeUpdate(cn, query);
		return(st);
	}catch(Exception e){
		System.out.println(e);
		return(false);
	}	
	}
public static ResultSet fetchState()
{ try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from states";
	ResultSet rs=DBHelper.executeQuery(cn, query);
	return(rs);

}catch(Exception e){
	System.out.println(e);
return(null);	
}}
public static ResultSet fetchCities(String uid)
{ try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from cities where stateId='"+uid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query);
	return(rs);

}catch(Exception e){
	System.out.println(e);
return(null);	
}}
public static ResultSet checkFirstTime(String uid){
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="select * from profile  where userId='"+uid+"'";
		ResultSet st=DBHelper.executeQuery(cn, query);
		return(st);
	}catch(Exception e){
		System.out.println(e);
		return(null);
	}	
	}
public static String checkPhotograph(String uid)
{ try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="select * from photo where userId='"+uid+"'";
	ResultSet rs=DBHelper.executeQuery(cn, query);
	if(rs.next())
	{ 
		
	return(rs.getString(2));
		
		
	}
	else
	{return null;}

}catch(Exception e){
	System.out.println(e);
return(null);	
}}
public static boolean addPhoto(String uid,String file){
	try{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="";
		if(checkPhotograph(uid)==null){
		query="insert into photo values('"+uid+"','"+file+"')";
		System.out.println(query);
		}
		else{
			query="update photo set img='"+file+"' where userId='"+uid+"'";
			System.out.println(query);
		}
		boolean st=DBHelper.executeUpdate(cn, query);
		return(st);
	}catch(Exception e){
		System.out.println(e);
		return(false);
	}	
	}



}
