//tables : user , seller , item
//user : u_surkey , email
//seller : s_surkey , u_surkey
//item : item_name , s_surkey , quantity , deal_eligible , deal_added
package ebay.iiitb.deals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

import ebay.iiitb.DBUtil.DbConnection;

public class DealsFirstService{
	DbConnection db=new DbConnection();
	Connection con =db.getConnection();
	Map<String, Object> session = ActionContext.getContext().getSession();
	public ArrayList<String> getItemNames(String email){
		String getQuery = "select u_surkey from user where email=?";
		PreparedStatement ps1,ps2;
		int userId = 0,sellerId=0;
		ArrayList<String> itemNames = new ArrayList<String>();
		ResultSet rs1,rs2;
		try {
			ps1 = con.prepareStatement(getQuery);
			ps1.setString(1, email);
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				userId = rs1.getInt(1);
			}
			System.out.println("deals first services");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getQuery = "select s_surkey from seller where u_surkey=?";
		try {
			ps1 = con.prepareStatement(getQuery);
			ps1.setInt(1, userId);
			rs1 = ps1.executeQuery();
			while(rs1.next()){
				sellerId = rs1.getInt(1);
				session.put("sellerId", sellerId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getQuery = "select item_name from item where s_surkey=? and quantity>? and deal_eligible=? and deal_added=?";
		try {
			ps1 = con.prepareStatement(getQuery);
			ps1.setInt(1, sellerId);
			ps1.setInt(2, 0);
			ps1.setString(3, "Yes");
			ps1.setString(4, "No");
			rs1 = ps1.executeQuery();
			
			while(rs1.next()){
				itemNames.add(rs1.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemNames;
	}
}
