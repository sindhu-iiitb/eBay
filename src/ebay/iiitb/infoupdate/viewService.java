//tables : user , address
//user : u_surkey , user_id , firstname , lastname , email , dob
//address : line1 , line2 , city , state , pincode , u_surkey
package ebay.iiitb.infoupdate;

import ebay.iiitb.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ebay.iiitb.DBUtil.DbConnection;
import java.util.*;

public class viewService {

	viewmodel r;
	//LoginModel loginmodel;
	boolean status=false;
	int userid;
	
 public void viewService(viewmodel r) {
		 this.r=r;	
		}
 public ArrayList<viewmodel> getItemlist(String user) {
	 System.out.println("hellow");
	 ArrayList<viewmodel> view=new ArrayList<viewmodel>();
	 DbConnection db = new DbConnection();
		Connection con = db.getConnection();
   
     System.out.println("the value of session id in view service  is:"+user);
   
		String query = "select u_surkey from user where user_id=?";
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
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
		String query1="select firstname,lastname,email,dob from user where u_surkey =?" ;
		String query2="select line1,line2,city,state,pincode from address where u_surkey=?";
		
		try
		{
			PreparedStatement ps1=con.prepareStatement(query1);
			ps1.setInt(1,userid);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
			{
				viewmodel r = new viewmodel();
				r.setEmail(rs1.getString(3));
				r.setFirstname(rs1.getString(1));
				r.setLastname(rs1.getString(2));
				r.setUser_id(user);
				try{
					PreparedStatement ps2=con.prepareStatement(query2);
					ps2.setInt(1,userid);
					ResultSet rs2=ps2.executeQuery();
					if(rs2.next())
					{
						r.setLine1(rs2.getString(1));
						r.setLine2(rs2.getString(2));
						r.setCity(rs2.getString(3));
						r.setState(rs2.getString(4));
						r.setPincode(rs2.getString(5));
						
					}
					else
					{
						r.setLine1("Address not available");
					}
					view.add(r);
				
				}
				catch (SQLException e) {
		   			e.printStackTrace();
				 }		
			}
		}
		catch (SQLException e) {
   			e.printStackTrace();
		 }
		
	
		
	   
   			
   			return view;
		}
}

	

