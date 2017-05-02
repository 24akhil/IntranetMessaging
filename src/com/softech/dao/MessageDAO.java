package com.softech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.softech.model.Messages;

public class MessageDAO {
	static String provider="jdbc:mysql://localhost:3306/intranetmessaging";
	public static boolean addNewrecord(Messages M){
		try{Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="insert into messages(msgdatetime,userID,userID_to,messages,status,subject) values('"+M.getMsgdatetime()+"','"+M.getUserid()+"','"+M.getUserid_to()+"','"+M.getMessage()+"','"+M.getStatus()+"','"+M.getSubject()+"')";
	    boolean st=DBHelper.executeUpdate(cn, query);
	    return(st);
	    }catch(Exception e){
	    	System.out.println(e);
	    	return(false);
	    }
	}
		public static ResultSet displayInbox(String uid){
		try{Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="select msgid,(select userName from user u where u.userId=m.userId), userId,subject,messages,msgdatetime,status from messages m where userId_to='"+uid+"'";
	    ResultSet rs=DBHelper.executeQuery(cn,query);
	    return(rs);
	    }catch(Exception e){
	    	System.out.println(e);
	    	return(null);
	    }
	}
		public static ResultSet displaySent(String uid,String pat){
			try{Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,"root","123");
			String query="select * from messages where userid='"+uid+"'and userid_to like '%"+pat+"%'";
		    ResultSet rs=DBHelper.executeQuery(cn,query);
		    return(rs);
		    }catch(Exception e){
		    	System.out.println(e);
		    	return(null);
		    }
		}
		public static String countUnreadMsg(String uid)
	{ try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,"root","123");
		String query="select count(*) from messages where userid_to='"+uid+"' and status='UnRead'";
		ResultSet rs=DBHelper.executeQuery(cn, query);
		if(rs.next())
		{
		 return(rs.getString(1));	
		}
	  return(null);
	}catch(Exception e){
		System.out.println(e);
	return(null);	
		
	}}
		public static ResultSet displayMsg(String mid){
			try{Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,"root","123");
			String query="update messages set status='Read' where msgid='"+mid+"'";
			DBHelper.executeUpdate(cn, query);
			query="select * from messages where msgid='"+mid+"'";
		    ResultSet rs=DBHelper.executeQuery(cn,query);
		    return(rs);
		    }catch(Exception e){
		    	System.out.println(e);
		    	return(null);
		    }
	
}public static boolean deleteMessage(String mid)
{ try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="delete from messages where msgid='"+mid+"'";
	boolean st=DBHelper.executeUpdate(cn, query);
	return st;

}catch(Exception e){
	System.out.println(e);
return(false);	
	
}
}public static boolean trashMessage(String mid)
{ try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,"root","123");
	String query="update messages set status='Trash' where msgid='"+mid+"'";
	boolean st=DBHelper.executeUpdate(cn, query);
	return st;

}catch(Exception e){
	System.out.println(e);
return(false);	
	
}}
		}
