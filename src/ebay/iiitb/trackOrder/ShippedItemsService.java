//tables : orders
//orders : u_surkey , status
package ebay.iiitb.trackOrder;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;





public class ShippedItemsService {
 
	
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	
	
	public ArrayList<TrackOrderModel> getOrders(int u_surkey)
	{
	
		
		ArrayList<TrackOrderModel> items = new ArrayList<TrackOrderModel>();
		String getItems = "select * from orders where u_surkey = ? and status=?";
		
		try
		{
			PreparedStatement ps1=con.prepareStatement(getItems);
			//PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setInt(1, u_surkey);
		
			ps1.setString(2, "Shipped");
			
			
			
			//System.out.println(category_Name);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				
				TrackOrderModel trackOrderModel = new TrackOrderModel();
				//order_surkey = rs1.getInt(1);
				trackOrderModel.setOrder_id(rs1.getInt(1));
				trackOrderModel.setTotalcost(rs1.getInt(11));
				trackOrderModel.setTransaction_date(rs1.getString(3));
				trackOrderModel.setShip_before(rs1.getString(5));
				trackOrderModel.setOrder_status(rs1.getString(7));
				items.add(trackOrderModel);
			}
			   
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return items;	
		
	}
	
	






	

}
