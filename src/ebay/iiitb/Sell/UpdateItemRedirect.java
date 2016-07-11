//tables : seller , item
//seller : s_surkey , u_surkey
//item : s_surkey , item_name
package ebay.iiitb.Sell; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ebay.iiitb.DBUtil.DbConnection;

public class UpdateItemRedirect extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6339621514430159804L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	ArrayList<String>  items = new ArrayList<String>();
	
	public ArrayList<String> getItems() {
		return items;
	}

	public void setItems(ArrayList<String> items) {
		this.items = items;
	}

	public String execute(){
		DbConnection db=new DbConnection();
		Connection con =db.getConnection();
		
		
		int userId = (Integer) session.get("user_surr_key");
		int sellerId=0;
		String getseller="Select s_surkey from seller where u_surkey=?";
		ResultSet resultseller;
		
		
		
		String getQuery = "select item_name from item where s_surkey=? ";
		
		PreparedStatement ps;
		ResultSet rs;
		try {
			PreparedStatement psseller=con.prepareStatement(getseller);
			psseller.setInt(1, userId);
			resultseller=psseller.executeQuery();
			while(resultseller.next()){
				sellerId=resultseller.getInt(1);
			}
			
			ps = con.prepareStatement(getQuery);
			ps.setInt(1, sellerId);
			rs = ps.executeQuery();
			String str;
			System.out.println("in update redirect");
			while(rs.next()){
				str = rs.getString(1);
				System.out.println("itemNmae" + rs.getString(1));
				items.add(str);
				System.out.println("in update redirect");
				System.out.println(str);
			}
			System.out.println(items);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
