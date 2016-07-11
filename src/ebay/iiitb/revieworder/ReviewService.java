//tables : user , address
//address : line1 , line2 , city , state , u_surkey
//user : firstname , lastname , u_surkey , email
package ebay.iiitb.revieworder;

import ebay.iiitb.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ebay.iiitb.DBUtil.*;
import java.util.*;

public class ReviewService {

	Reviewmodel reviewmodel = new Reviewmodel();
	boolean status=false;
	public ArrayList<Reviewmodel> getAddress(String user) {
		System.out.println("hellow");
		ArrayList<Reviewmodel> TL=new ArrayList<Reviewmodel>();
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
   
		System.out.println("the value of session id in service:"+user);
    
		String query = " select u_surkey from user where email=? ";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,user);
			ResultSet rs=ps.executeQuery();
			
    
			while(rs.next())
			{
				int key = rs.getInt(1);
				System.out.println("retrieved key is:"+key);
				String query1="select firstname,lastname,line1,line2,city,state from address,user where address.u_surkey=? and address.u_surkey=user.u_surkey";
           	
				try
				{
					PreparedStatement ps1=con.prepareStatement(query1);
   			    ps1.setInt(1,key);
   			    ResultSet rs1=ps1.executeQuery();
   			    while(rs1.next())
   			    {
   			    	Reviewmodel r = new Reviewmodel();
   			    	r.setFirstname(rs1.getString(1));
   			    	r.setLastname(rs1.getString(2));
   			    	r.setLine1(rs1.getString(3));
   			    	System.out.println("line 1 is:"+rs1.getString(3));
   			    	r.setLine2(rs1.getString(4));
   			    	r.setCity(rs1.getString(5));
   			    	r.setState(rs1.getString(6));
   			    	TL.add(r);
   			    	
   			    }
   	
           }
           catch (SQLException e) {
   			e.printStackTrace();
   			
   		                           }	
                }
 }
		catch (SQLException e) {
			e.printStackTrace();
			
		                        }	
	 
	  
	  return TL;
	 
		 
	 }
	}

 
  
