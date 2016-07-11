//tables : orderspecific , item
//item : i_surkey ,
//orderspecific : o_surkey
package ebay.iiitb.trackOrder;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;



public class OrderItemsService {
 
	
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	
	
	public ArrayList<TrackOrderItemModel> getOrders(int orderid)
	{
		
		
		ArrayList<TrackOrderItemModel> items = new ArrayList<TrackOrderItemModel>();
		String getItems = "select * from orderspecific where o_surkey=?";
		String getItemDetails="select * from item where i_surkey=?";
		//String getOrderKey = "select o_surkey from category where name = ?"; 
		try
		{
			PreparedStatement ps1=con.prepareStatement(getItems);
			//PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setInt(1, orderid);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				int item_surkey=rs1.getInt(3);
				int quantity=rs1.getInt(5);
				PreparedStatement ps2=con.prepareStatement(getItemDetails);
				ps2.setInt(1, item_surkey);
				ResultSet rs2=ps2.executeQuery();
				
				while(rs2.next())
				{
				TrackOrderItemModel itemModel = new TrackOrderItemModel();
				itemModel.setItem_name((rs2.getString(2)));
				itemModel.setPicture((rs2.getString(3)));
				itemModel.setPrice((rs2.getString(4)));
				itemModel.setQuantity(quantity);
			
				items.add(itemModel);
				}
			}
			   
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return items;	
		
	}
	
	






	

}
