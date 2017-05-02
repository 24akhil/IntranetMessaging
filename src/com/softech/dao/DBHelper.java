package com.softech.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONObject;

 

public class DBHelper {
public static boolean executeUpdate(Connection cn,String query)
{ try{
     Statement smt=cn.createStatement();
     smt.executeUpdate(query);
     return(true);
    }
catch(Exception e)
{System.out.println(e);
	return(false);
	}}

public static ResultSet executeQuery(Connection cn,String query)
{try{
    Statement smt=cn.createStatement();
    ResultSet rs=smt.executeQuery(query);
    return(rs);
   }
catch(Exception e)
{return(null);
	}
	}
/////////////////JSon object//////////////////
public static ArrayList<JSONObject> getFormatedResult(ResultSet rs){

ArrayList<JSONObject> resList = new ArrayList<JSONObject>();
try{//column's names//
	ResultSetMetaData rsMeta = rs.getMetaData();
	int columnCnt=rsMeta.getColumnCount();
	ArrayList<String> columnNames = new ArrayList<String>();
	for(int i=1;i<=columnCnt;i++){
		columnNames.add(rsMeta.getColumnName(i).toUpperCase());
		
	}
	////converting JSONObject to Human Readable
	while(rs.next()){
		JSONObject obj= new JSONObject();
		for(int i=1;i<=columnCnt;i++){
			String key=columnNames.get(i-1);
			String valu=rs.getString(i);
			obj.put(key, valu);
			
		}
		resList.add(obj);
		
	}
	
}
catch(Exception e){
	System.out.println(e);
}finally{
	try{rs.close();
}catch(Exception e){System.out.println(e);}
}

return(resList);
}
/////////////////JSON object//////////////////
}



