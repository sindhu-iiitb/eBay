//tables : item , seller , user
//item : i_surkey
//seller : s_surkey
//user : u_surkey
package ebay.iiitb.itemdetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;


public class ItemDisplayService {
	
	public boolean itemdetails(ItemModel item) {
		boolean status=false;
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		PreparedStatement ps;
		String items="select * from item where i_surkey=?";
		String sellerdetails="select * from seller where s_surkey=?";
		String detailsfromuser="select * from user where u_surkey=?";
		try {
			ps=con.prepareStatement(items);
			ps.setInt(1, item.getI_surkey());
			
			rs=ps.executeQuery();
			while (rs.next()) {
				item.setPrice(rs.getInt(4));
				item.setCondition(rs.getString(14));
				item.setQuantity(rs.getString(8));
				item.setFreeshipping(rs.getString(21));
				item.setItem_Name(rs.getString(2));
				item.setSeller_id(rs.getInt(6));
				item.setPicture(rs.getString(3));
				item.setItem_desc(rs.getString(5));
				item.setDiscount(rs.getInt(7));
				item.setShipping_details(rs.getString(20));
				
				int priceafterdiscount=item.getPrice()-(item.getPrice()*item.getDiscount()/100);
				item.setPriceafterdiscount(priceafterdiscount);
				status=true;
			}
			ps=con.prepareStatement(sellerdetails);
			ps.setInt(1, item.getSeller_id());
			int user_id = 0;
			rs=ps.executeQuery();
			while(rs.next()){
				item.setSellerfeedback(rs.getString(3));
				item.setRating(rs.getString(7));
				item.setPhoneno(rs.getString(14));
				item.setNumberofbuyers(rs.getInt(15));
				user_id=rs.getInt(5);
			}
			
			ps=con.prepareStatement(detailsfromuser);
			ps.setInt(1, user_id);
			
			rs=ps.executeQuery();
			while(rs.next()){
			item.setSellername(rs.getString(1)+" "+rs.getString(2));
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
		
	}

}
