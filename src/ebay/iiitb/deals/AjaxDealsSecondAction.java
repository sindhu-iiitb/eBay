//tables : item
//item : item_name , s_surkey , item_name , quantity , deal_eligible , deal_added=?
package ebay.iiitb.deals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import ebay.iiitb.DBUtil.DbConnection;

public class AjaxDealsSecondAction implements SessionAware {
	private String itemName1;
	
	private Map<String, Object> session;
	private Map<String, String> itemNames = new LinkedHashMap<String, String>();
	public Map<String, String> getItemNames() {
		return itemNames;
	}
	public void setItemNames(Map<String, String> itemNames) {
		this.itemNames = itemNames;
	}
	
	public String getItemName1() {
		return itemName1;
	}
	public void setItemName1(String itemName1) {
		this.itemName1 = itemName1;
	}
	
	public String execute(){
		
		System.out.println("in ajax second action");
		String email=(String) session.get("email");
		int sellerId = (Integer) session.get("sellerId");
		DbConnection db=new DbConnection();
		Connection con =db.getConnection();
		PreparedStatement ps,ps1;
		ResultSet rs,rs1;
		String getQuery = "select item_name from item where s_surkey=? and item_name=? and quantity>?";
		String getQuery1 = "select item_name from item where s_surkey=? and item_name!=? and quantity>? and deal_eligible=? and deal_added=?";
		System.out.println("in Ajax User Action");
		System.out.println("itemName="+itemName1);
		try {
			ps = con.prepareStatement(getQuery);
			ps1 = con.prepareStatement(getQuery1);
			ps.setInt(1, sellerId);
			ps.setString(2, itemName1);
			ps.setInt(3, 1);
			ps1.setInt(1, sellerId);
			ps1.setString(2, itemName1);
			ps1.setInt(3, 0);
			ps1.setString(4, "Yes");
			ps1.setString(5, "No");
			rs=ps.executeQuery();
			rs1=ps1.executeQuery();
			Integer i=1;
			while(rs.next()){
				itemNames.put(i.toString(), rs.getString(1));
				i++;
				System.out.println(" itemName1="+rs.getString(1));
			}
			
			while(rs1.next()){
				itemNames.put(i.toString(), rs1.getString(1));
				System.out.println(" itemName2="+rs1.getString(1));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "success";
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
}
