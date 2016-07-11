//tables : user
//user : firstname , lastname , user_id
package ebay.iiitb.infoupdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;

public class changenameService {
	boolean status=false;
	int userid;
	
 
 public boolean updateinfo(String user,String fname,String lname) {
	 System.out.println("hellow");
	 
	 DbConnection db = new DbConnection();
		Connection con = db.getConnection();
   /*  HttpSession session = ServletActionContext.getRequest().getSession();
     String user = session.getAttribute("user").toString();*/
     System.out.println("the value of session id in service:"+user);
        
		String query = "update user set firstname=?,lastname=? where user_id=?";
		try{
			PreparedStatement ps1=con.prepareStatement(query);
			ps1.setString(1,fname);
			ps1.setString(2,lname);
			ps1.setString(3,user);
			
			if(ps1.executeUpdate()>0)
			{
				System.out.println("new name updated");
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

