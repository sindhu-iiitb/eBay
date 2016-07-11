//tables : seller , item , deals
//seller : s_surkey , u_surkey
//item : items_in_deal , deal_title , deal_added , deal_title , i_surkey
//deals : dealstitle , sellerid
package ebay.iiitb.deals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ebay.iiitb.DBUtil.DbConnection;

public class DeleteDealAction extends ActionSupport{
	private String deal;
	Map<String, Object> session = ActionContext.getContext().getSession();
	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}
	
	public String execute(){
		String items = null;
		int userId = (Integer) session.get("user_surr_key");
		int sellerId=0;
		String getseller="Select s_surkey from seller where u_surkey=?";
		ResultSet resultseller;
		
		String selectitems = "select distinct items_in_deal from item where deal_title =?";
		String updateItem = "update item set items_in_deal =?, deal_added =?,deal_title = ? where i_surkey = ?";
		DbConnection db=new DbConnection();
		Connection con =db.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try {
			PreparedStatement psseller=con.prepareStatement(getseller);
			psseller.setInt(1, userId);
			resultseller=psseller.executeQuery();
			while(resultseller.next()){
				sellerId=resultseller.getInt(1);
			}
			
			
			ps = con.prepareStatement(selectitems);
			ps.setString(1, deal);
			rs=ps.executeQuery();
			while(rs.next())
			{
				items = rs.getString("items_in_deal");
			}
			String itemlist[] = items.trim().split(",");
			
			for (int i = 0; i < itemlist.length; i++) {
				ps  = con.prepareStatement(updateItem);
				ps.setString(1, "");
				ps.setString(2, "No");
				ps.setString(3, "");
				ps.setInt(4, Integer.parseInt(itemlist[i]));
				ps.executeUpdate();
			}
			String deleteQuery = "delete from deals where dealstitle=? and sellerid=?";
			try {
				ps = con.prepareStatement(deleteQuery);
				ps.setString(1, deal);
				ps.setInt(2, sellerId);
				if(ps.executeUpdate()>0)
					return SUCCESS;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ERROR;
	}
}
