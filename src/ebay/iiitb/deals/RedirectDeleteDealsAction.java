//tables : seller , item
// seller : s_surkey , u_surkey
//item : deal_title , s_surkey , deal_added
package ebay.iiitb.deals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ebay.iiitb.DBUtil.DbConnection;

public class RedirectDeleteDealsAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6339621514430159804L;
	Map<String, Object> session = ActionContext.getContext().getSession();
	ArrayList<String>  deals = new ArrayList<String>();
	public ArrayList<String> getDeals() {
		return deals;
	}
	public void setDeals(ArrayList<String> deals) {
		this.deals = deals;
	}
	public String execute(){
		DbConnection db=new DbConnection();
		Connection con =db.getConnection();
		
		
		int userId = (Integer) session.get("user_surr_key");
		int sellerId=0;
		String getseller="Select s_surkey from seller where u_surkey=?";
		ResultSet resultseller;
		
		
		
		String getQuery = "select distinct deal_title from item where s_surkey=? and deal_added = ?";
		
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
			ps.setString(2, "Yes");
			rs = ps.executeQuery();
			String str;
			while(rs.next()){
				str = rs.getString("deal_title");
				System.out.println("Getting titles" + rs.getString(1));
				deals.add(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
