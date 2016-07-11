//tables : user , seller
//user : u_surkey , email
//seller : u_surkey
package ebay.iiitb.itemmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import ebay.iiitb.DBUtil.DbConnection;


public class StartSellingService implements SessionAware {

boolean status=false;
int id;

DbConnection db=new DbConnection();
Connection con =db.getConnection();
private Map<String, Object> session;
//HttpSession session = ServletActionContext.getRequest().getSession();
//SessionMap<String, Object> session = (SessionMap<String, Object>) ActionContext.getContext().getSession();

	public boolean validSeller(String email) throws SQLException
	{
		System.out.println("start selling service");
//		 String email =  (String) session.get("email");
//		
	System.out.println(email+"as logged in");
//		sessionservice serv = new sessionservice();
//		System.out.println("accessing from sess service"+serv.show());

		String queryid="select u_surkey from user where email=?";
		PreparedStatement ps1,ps2;
		ps1=con.prepareStatement(queryid);
		ps1.setString(1,email);
		System.out.println("query in startsellingservice "+ ps1);
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{
			System.out.println("in start selling service");
			 id=rs1.getInt(1);
			System.out.println(" start selling service id for email"+email+"is"+id);
		}
		rs1.close();
		
		//session.put("u_key", id);
		// ((Object) session).set("u_key",id);
		
		//System.out.println(" start selling service surr key for user	"+session.getAttribute("u_key"));
		String checkseller="select * from seller where u_surkey=?";
		ps2=con.prepareStatement(checkseller);
		ps2.setInt(1,id);
		System.out.println(" start selling service"+ ps2);
		rs1=ps2.executeQuery();
		while(rs1.next())
		{
			 
		 System.out.println("validseller");
			 status=true;
		 }
		System.out.println(status +	"------------- start selling service----------------------------------------");
		return status;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
		
	}
	
}
