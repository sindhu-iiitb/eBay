//tables : user
//user : pwd , user_id
package ebay.iiitb.infoupdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;

public class changepasswordService {
	

	boolean status=false;
	int userid;
	
 
 public boolean updateinfo(String user,String password) {
	 System.out.println("hellow");
	 
	 DbConnection db = new DbConnection();
		Connection con = db.getConnection();
   /*  HttpSession session = ServletActionContext.getRequest().getSession();
     String user = session.getAttribute("user").toString();*/
     System.out.println("the value of session id in password service:"+user);
        
		String query = "update user set pwd=? where user_id=?";
		try{
			PreparedStatement ps1=con.prepareStatement(query);
			ps1.setString(1,password);
			ps1.setString(2,user);
			
			if(ps1.executeUpdate()>0)
			{
				System.out.println("new password updated");
				status=true;
			}
		}
		catch (SQLException e) {
   			e.printStackTrace();
		 }
	
   			System.out.println("in password service"+status);
   			return status;
		}


}
