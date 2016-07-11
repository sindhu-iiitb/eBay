//tables : seller , orderspecific , item
//seller : s_surkey , u_surkey , rating , Num_of_buyers_rated
//orderspecific : o_surkey , item_status , s_surkey
//item : i_surkey ,s_surkey
package ebay.iiitb.trackOrder;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;



public class ShippedOrderItemsService {
 
	
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	
	
	public ArrayList<TrackOrderItemModel> getOrders(int orderid,int u_surkey)
	{
		
		int s_surkey=0;
		ArrayList<TrackOrderItemModel> items = new ArrayList<TrackOrderItemModel>();
		String getSellerSurkey="select s_surkey from seller where u_surkey=?";
		String getItems = "select * from orderspecific where o_surkey=? and item_status=? and s_surkey=?";
		String getItemDetails="select * from item where i_surkey=?";
		//String getOrderKey = "select o_surkey from category where name = ?"; 
		try
		{
			PreparedStatement ps3=con.prepareStatement(getSellerSurkey);
			ps3.setInt(1, u_surkey);
			ResultSet rs3=ps3.executeQuery();
			if(rs3.next())
				s_surkey=rs3.getInt(1);
			PreparedStatement ps1=con.prepareStatement(getItems);
			ps1.setInt(1, orderid);
			ps1.setString(2, "Money Paid");
			ps1.setInt(3, s_surkey);
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
				itemModel.setO_surkey(orderid);
				itemModel.setI_surkey(rs2.getInt(1));
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
	public  ArrayList<TrackOrderItemModel> getReceivedItems(int orderid)
	{
		ArrayList<TrackOrderItemModel> items = new ArrayList<TrackOrderItemModel>();
		String getItems = "select * from orderspecific where o_surkey=? ";
		String getItemDetails="select * from item where i_surkey=?";
		try
		{
			PreparedStatement ps1=con.prepareStatement(getItems);
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
				itemModel.setO_surkey(orderid);
				itemModel.setI_surkey(rs2.getInt(1));
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
	public ArrayList<TrackOrderItemModel> getShippedItems(int orderid,int u_surkey)
	{
		
		int s_surkey=0;
		ArrayList<TrackOrderItemModel> items = new ArrayList<TrackOrderItemModel>();
		String getSellerSurkey="select s_surkey from seller where u_surkey=?";
		String getItems = "select * from orderspecific where o_surkey=? and item_status=?";
		String getItemDetails="select * from item where i_surkey=?";
		//String getOrderKey = "select o_surkey from category where name = ?"; 
		try
		{
			PreparedStatement ps3=con.prepareStatement(getSellerSurkey);
			ps3.setInt(1, u_surkey);
			ResultSet rs3=ps3.executeQuery();
			if(rs3.next())
				s_surkey=rs3.getInt(1);
			PreparedStatement ps1=con.prepareStatement(getItems);
			ps1.setInt(1, orderid);
			ps1.setString(2, "Shipped");
			//ps1.setInt(3, s_surkey);
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
				itemModel.setO_surkey(orderid);
				itemModel.setI_surkey(rs2.getInt(1));
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
	public boolean sellerRating(int item_key,float rate)
	{
		int seller_surkey=0;
		float seller_rating=0;
		int buyers=0;
		String getSeller="select s_surkey from item where i_surkey = ?";
		String getRating ="select rating from seller where s_surkey = ?";
		String getNumberOfBuyers="select Num_of_buyers_rated from seller where s_surkey = ?";
		String updateNumOfBuyers="update seller set Num_of_buyers_rated=? where s_surkey= ?";
		String updateRating="update seller set rating = ? where s_surkey= ? ";
		try
		{
			PreparedStatement ps1=con.prepareStatement(getSeller);
			//PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setInt(1, item_key);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				seller_surkey=rs1.getInt(1);
				PreparedStatement ps4=con.prepareStatement(getNumberOfBuyers);
				ps4.setInt(1, seller_surkey);
				ResultSet rs4=ps4.executeQuery();
				if(rs4.next())
					buyers=rs4.getInt(1);
				PreparedStatement ps5=con.prepareStatement(updateNumOfBuyers);
				System.out.println("Buyers :"+buyers);
				ps5.setInt(1, buyers+1);
				ps5.setInt(2, seller_surkey);
				ps5.executeUpdate();
				PreparedStatement ps2=con.prepareStatement(getRating);
				ps2.setInt(1, seller_surkey);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next())
					seller_rating=rs2.getFloat(1);
				System.out.println("Previous Rate:"+seller_rating);
				System.out.println("Given "+rate);
				PreparedStatement ps3=con.prepareStatement(updateRating);
				rate=((seller_rating * buyers)+rate)/(buyers+1);
				System.out.println("rate :"+rate);
				ps3.setFloat(1, rate);
				ps3.setInt(2, seller_surkey);
				if(ps3.executeUpdate()>0)
					return true;
			}
			   
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
		
	}






	

}
