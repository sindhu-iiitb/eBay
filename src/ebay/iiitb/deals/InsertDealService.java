//tables : item , deals
//item : deal_added , items_in_deal , deal_title , i_surkey , item_name , s_surkey
//deals : itemid1 , itemid2 , freeitemid , sellerid , dealstitle , dealscost
package ebay.iiitb.deals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import ebay.iiitb.DBUtil.DbConnection;

public class InsertDealService {

	public boolean insertDeal(InsertDealModel insertDealModel) {
		Map<String, Object> session = ActionContext.getContext().getSession();
		int sellerId = (Integer) session.get("sellerId");
		DbConnection db=new DbConnection();
		Connection con =db.getConnection();
		int itemid1 = 0,itemid2 = 0,itemid3 = 0,cost1=0,cost2=0;
		String updatedeal= "update item set deal_added = ?, items_in_deal =? ,deal_title=? where i_surkey =? ";
		String getitemid="select * from item where item_name=? and s_surkey=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps =con.prepareStatement(getitemid);
			ps.setString(1, insertDealModel.getItem1());	
			ps.setInt(2, sellerId);
			rs =ps.executeQuery();
			while(rs.next()){
				itemid1=rs.getInt(1);
				cost1=rs.getInt(4);
			}
			ps.setString(1, insertDealModel.getItem2());
			ResultSet rs1=ps.executeQuery();
			while(rs1.next()){
				itemid2=rs1.getInt(1);
				cost2=rs1.getInt(4);
			}
			ps.setString(1, insertDealModel.getItem3());
			ResultSet rs2=ps.executeQuery();
			while(rs2.next()){
				itemid3=rs2.getInt(1);
			}
			int totalcost=cost1+cost2;
			String insertdeal="insert into deals (itemid1,itemid2,freeitemid,sellerid,dealstitle,dealscost) values (?,?,?,?,?,?)";
			ps=con.prepareStatement(insertdeal);		
			ps.setInt(1, itemid1);
			ps.setInt(2, itemid2);
			ps.setInt(3, itemid3);
			ps.setInt(4, sellerId);
			ps.setString(5, insertDealModel.getDeal_title());
			ps.setInt(6, totalcost);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String items = ""+ itemid1 + "," + itemid2 + "," + itemid3 ;
		try {
			ps =con.prepareStatement(updatedeal);
			ps.setString(1, "Yes");
			ps.setString(2, items);
			ps.setString(3, insertDealModel.getDeal_title());
			ps.setInt(4, itemid1);
			if(ps.executeUpdate()>0)
				System.out.println("insertd");
			else
				System.out.println("not up");
			ps.setInt(4, itemid2);
			ps.executeUpdate();
			ps.setInt(4, itemid3);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}

}
