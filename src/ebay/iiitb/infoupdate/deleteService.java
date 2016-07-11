//tables : user , seller , address , item
//user : u_surkey , user_id
//seller : u_surkey , seller_id , s_surkey
//address : u_surkey , address_surkey
//item : s_surkey
package ebay.iiitb.infoupdate;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import ebay.iiitb.*;
import ebay.iiitb.DBUtil.*;
import java.util.*;

public class deleteService {

	
	boolean status=false;
	int userid;
	
 
 public int getuserid(String user) {
	 System.out.println("hellow");
	 
	 DbConnection db = new DbConnection();
		Connection con = db.getConnection();
   
     System.out.println("the value of session id in service:"+user);
        
		//String query = "delete from user where user_id=?";
		String query1 = "select u_surkey from user where user_id=?";
		//String query2="delete from seller where u_surkey=?";
		//String query3="select seller_id from seller where u_surkey=?";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(query1);
			ps.setString(1,user);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				userid=rs.getInt(1);
				System.out.println("userid in view service is:"+userid);
			}
		}
		catch (SQLException e) {
   			e.printStackTrace();
		 }
		return userid;
			
}
public boolean deleteuser(String user,int userid)
{
	 DbConnection db = new DbConnection();
		Connection con = db.getConnection();
	String query = "delete from user where user_id=?";
	try{
		PreparedStatement ps1=con.prepareStatement(query);
		ps1.setString(1,user);
		
		
		if(ps1.executeUpdate()>0)
		{
			System.out.println("user table info deleted");
			status=true;
		}
	}
	catch (SQLException e) {
			e.printStackTrace();
	 }

			System.out.println("in service"+status);
			return status;
}
public boolean deleteseller(String user,int userid)
{
	 DbConnection db = new DbConnection();
		Connection con = db.getConnection();
	String query = "delete from seller where u_surkey=?";
	String query1="select seller_id from seller where u_surkey=?";
	try
	{
		PreparedStatement ps=con.prepareStatement(query1);
		ps.setInt(1,userid);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			try{
				PreparedStatement ps1=con.prepareStatement(query);
				ps1.setInt(1,userid);
				
				
				if(ps1.executeUpdate()>0)
				{
					System.out.println("seller table info deleted");
					status=true;
				}
				else
					System.out.println("user is not seller");
			}
			catch (SQLException e) {
					e.printStackTrace();
			 }

					
		}
			
	}
	catch (SQLException e) {
		e.printStackTrace();
 }
	return status;
}

public boolean deleteaddress(String user,int userid)
{
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
String query = "delete from address where u_surkey=?";
String query1="select address_surkey from address where u_surkey=?";
try
{
	PreparedStatement ps=con.prepareStatement(query1);
	ps.setInt(1,userid);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		try{
			PreparedStatement ps1=con.prepareStatement(query);
			ps1.setInt(1,userid);
			
			
			if(ps1.executeUpdate()>0)
			{
				System.out.println("address table info deleted");
				status=true;
			}
			else
				System.out.println("user does not have address");
		}
		catch (SQLException e) {
				e.printStackTrace();
		 }

				
	}
		
}
catch (SQLException e) {
	e.printStackTrace();
}
return status;
}
public boolean deleteselleritems(String user,int userid)
{
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	int seller;
String query1 = "select s_surkey from seller where u_surkey=?";
String query="delete from item  where s_surkey=?";
try
{
	PreparedStatement ps=con.prepareStatement(query1);
	ps.setInt(1,userid);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
		seller = rs.getInt(1);
		try{
			PreparedStatement ps1=con.prepareStatement(query);
			ps1.setInt(1,seller);
			
			
			if(ps1.executeUpdate()>0)
			{
				System.out.println("item table info deleted");
				status=true;
			}
			else
				System.out.println("user is not seller so no items in itemtable");
		}
		catch (SQLException e) {
				e.printStackTrace();
		 }

				
	}
	else
		System.out.println("cant delete as user is not seller");
}
catch (SQLException e) {
	e.printStackTrace();
}
return status;
}
}



