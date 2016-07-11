//tables : user
//user : email , user_id
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

public class changeemailService {

	
	boolean status=false;
	int userid;
	
 
 public boolean updateinfo(String user,String email) {
	 System.out.println("hellow");
	 
	 DbConnection db = new DbConnection();
		Connection con = db.getConnection();
   /*  HttpSession session = ServletActionContext.getRequest().getSession();
     String user = session.getAttribute("user").toString();*/
     System.out.println("the value of session id in service:"+user);
        
		String query = "update user set email=? where user_id=?";
		try{
			PreparedStatement ps1=con.prepareStatement(query);
			ps1.setString(1,email);
			ps1.setString(2,user);
			
			if(ps1.executeUpdate()>0)
			{
				System.out.println("new email updated");
				status=true;
			}
		}
		catch (SQLException e) {
   			e.printStackTrace();
		 }
	
   			System.out.println("in service"+status);
   			return status;
		}

			
}

