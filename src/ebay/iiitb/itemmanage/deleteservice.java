//tables : user , seller , item
//user : u_surkey , email
//seller : s_surkey , u_surkey
//item : s_surkey
package ebay.iiitb.itemmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import ebay.iiitb.DBUtil.DbConnection;

import com.opensymphony.xwork2.ActionContext;

public class deleteservice {
	DbConnection db=new DbConnection();
	Connection con =db.getConnection();
int s_id=0;
ArrayList<String> itemslist=new ArrayList<String>();
	//SessionMap<String, Object> session = (SessionMap<String, Object>) ActionContext.getContext().getSession();
	public ArrayList<String> deleteitem(String email){
	String userkey="select u_surkey from user where email=?";
	String sellersurrogate="select s_surkey from seller where u_surkey=?";//take this from session
	String itemsname="select * from item where s_surkey=?";
	PreparedStatement ps1,ps2,ps3;
	boolean status=false;
		try {
			//int userid=(int) session.get("u_key");
		int userid=0;
			
			ps3=con.prepareStatement(userkey);
			ps3.setString(1, email);
			 ResultSet rs1=ps3.executeQuery();
			 while(rs1.next())
				 userid=rs1.getInt(1);
			 System.out.println(userid+"in deleteservice for email"+email);
			
				ps1=con.prepareStatement(sellersurrogate);
		        ps1.setInt(1,userid);
			    System.out.println(ps1);
			   rs1=ps1.executeQuery();
		while(rs1.next())
		{
			System.out.println("in delete  service---------");
			 s_id=rs1.getInt(1);
			System.out.println("surrogate id for selleris"+s_id);
		}
		
		
		ps2=con.prepareStatement(itemsname);
		ps2.setInt(1,s_id);
		rs1=ps2.executeQuery();
		while(rs1.next())
		{
			itemslist.add(rs1.getString(2));
			System.out.println(rs1.getString(2));
			System.out.println("in seller service");
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return itemslist;
		
	}
	
}
