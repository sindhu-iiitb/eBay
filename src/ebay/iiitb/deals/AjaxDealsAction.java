// tables :item 
// item : price , s_surkey , item_name , quantity , deal_eligible ,deal_added
package ebay.iiitb.deals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import ebay.iiitb.DBUtil.DbConnection;

public class AjaxDealsAction implements SessionAware {
	private String itemName1;
	private String itemName2;
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
	public String getItemName2() {
		return itemName2;
	}
	public void setItemName2(String itemName2) {
		this.itemName2 = itemName2;
	}
	
	@SuppressWarnings("resource")
	public String execute(){
		String email=(String) session.get("email");
		int sellerId = (Integer) session.get("sellerId");
		DbConnection db=new DbConnection();
		Connection con =db.getConnection();
		PreparedStatement ps,ps1;
		ResultSet rs,rs1;
		int price1 = 0,price2 = 0;
		
		String getQuery = "select price from item where s_surkey=? and item_name=?";
		String getQuery1 = "select price from item where s_surkey=? and item_name=?";
		System.out.println("in Ajax User Action");
		System.out.println("in ajax third action");
		System.out.println("itemName="+itemName1);
		System.out.println("itemName="+itemName2);
		Integer i =1;
		int price = 0;
		try {
			ps = con.prepareStatement(getQuery);
			ps1 = con.prepareStatement(getQuery1);
			ps.setInt(1, sellerId);
			ps.setString(2, itemName1);
			ps1.setInt(1, sellerId);
			ps1.setString(2, itemName2);
			rs=ps.executeQuery();
			rs1=ps1.executeQuery();
			System.out.println("AjaxDealsAction");
			while(rs.next()){
				price1 = rs.getInt(1);
				System.out.println("price="+price1+" itemName1="+itemName1);
			}
			while(rs1.next()){
				price2 = rs1.getInt(1);
				System.out.println("price="+price2+" itemName2="+itemName2);
			}
			price = Math.min(price1, price2);
			System.out.println(price);
			//getQuery = "select item_name from item where s_surkey=? and quantity>? and price<=? and item_name not in (?,?) and deal_eligible=? and deal_added=?";
			getQuery = "select item_name from item where s_surkey=? and quantity>? and item_name not in (?,?) and deal_eligible=? and deal_added=?";
			ps = con.prepareStatement(getQuery);
			ps.setInt(1, sellerId);
			ps.setInt(2, 0);
			//ps.setInt(3, price);
			ps.setString(3, itemName1);
			ps.setString(4, itemName2);
			ps.setString(5, "Yes");
			ps.setString(6, "No");
			rs=ps.executeQuery();
			
			String index;
			while(rs.next()){
				String name = rs.getString(1);
				index = i.toString();
				itemNames.put(index,name);
				System.out.println("index="+index+" name="+name);
				i++;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!itemName1.equals(itemName2)){
				//getQuery="select item_name from item where s_surkey=? and item_name=? and quantity>? and price<=?";
				//getQuery1 = "select item_name from item where s_surkey=? and item_name=? and quantity>? and price<=?";
				getQuery="select item_name from item where s_surkey=? and item_name=? and quantity>?";
				getQuery1 = "select item_name from item where s_surkey=? and item_name=? and quantity>?";
				try {
					ps = con.prepareStatement(getQuery);
					ps1 = con.prepareStatement(getQuery1);
					ps.setInt(1, sellerId);
					ps.setString(2, itemName1);
					ps.setInt(3, 1);
					//ps.setInt(4, price);
					ps1.setInt(1, sellerId);
					ps1.setString(2, itemName2);
					ps1.setInt(3, 1);
					//ps1.setInt(4, price);
					rs = ps.executeQuery();
					rs1 = ps1.executeQuery();
					while(rs.next()){
						itemNames.put(i.toString(), rs.getString(1));
						i++;
					}
					while(rs1.next()){
						itemNames.put(i.toString(), rs1.getString(1));
						i++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				//getQuery="select item_name from item where s_surkey=? and item_name=? and quantity>? and price<=?";
				getQuery="select item_name from item where s_surkey=? and item_name=? and quantity>?";
				try {
					ps = con.prepareStatement(getQuery);
					ps.setInt(1, sellerId);
					ps.setString(2, itemName1);
					ps.setInt(3, 2);
					//ps.setInt(4, price);
					rs = ps.executeQuery();
					while(rs.next()){
						itemNames.put(i.toString(), rs.getString(1));
						i++;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		return "success";
		
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
}
