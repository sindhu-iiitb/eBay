//tables : seller , orderspecific , orders , bank , item
//item : price ,discount ,shippingcost,i_surkey
//seller : u_surkey , s_surkey
//orderspecific : item_status , o_surkey , i_surkey , s_surkey
//orders : o_surkey , status , u_surkey , totalamount
// bank : balance , b_surkey , u_surkey
package ebay.iiitb.trackOrder;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;



public class ChangeStatusService {
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	private ArrayList<TrackOrderModel> items = new ArrayList<TrackOrderModel>();
	
	public boolean checkSeller(int user_surkey)
	{
		String isSeller="select * from seller where u_surkey = ?";
		try
		{
			PreparedStatement ps1=con.prepareStatement(isSeller);
			//PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setInt(1, user_surkey);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next())
				return true;
			else 
				return false;
			
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
	
	public boolean updateOrder_asShipped(int o_surkey,int i_surkey)
	{
		boolean flag=false;
		String updateStatus="update orderspecific set item_status =? where o_surkey=? and i_surkey=? ";
		String checkStatus="select * from orderspecific where o_surkey = ? and item_status not like ?";
		String updateOrder="update orders set status =? where o_surkey=?";
		try
		{
			PreparedStatement ps1=con.prepareStatement(updateStatus);
			//PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setString(1, "Shipped");
			ps1.setInt(2, o_surkey);
			ps1.setInt(3, i_surkey);
			if(ps1.executeUpdate()==0)
				return false;
			else
			{
				PreparedStatement ps2=con.prepareStatement(checkStatus);
				ps2.setInt(1, o_surkey);
				ps2.setString(2,"Shipped");
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next())
					flag=true;
			}
			if(!flag)
			{
				PreparedStatement ps2=con.prepareStatement(updateOrder);
				ps2.setString(1, "Shipped");
				ps2.setInt(2, o_surkey);
				ps2.executeUpdate();
				System.out.println("In Flag");
			}
				return true;
			
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return true;
	}
	
	public ArrayList<TrackOrderModel> getPaidOrders(int user_surkey)
	{
		int seller_surkey=0;
		String getSeller_surkey="select s_surkey from seller where u_surkey=?";
		String getSellerOrders="select distinct o_surkey from orderspecific where s_surkey=?";
		String getItems="select * from orders where o_surkey = ? and status = ?";
		
		try
		{
			PreparedStatement ps2=con.prepareStatement(getSeller_surkey);
			ps2.setInt(1, user_surkey);
			ResultSet rs2=ps2.executeQuery();
			if(rs2.next())
				seller_surkey=rs2.getInt(1);
				
			PreparedStatement ps3=con.prepareStatement(getSellerOrders);
			ps3.setInt(1,seller_surkey);
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next())
			{
			
			PreparedStatement ps1=con.prepareStatement(getItems);
			ps1.setInt(1, rs3.getInt(1));
			ps1.setString(2, "Money Paid");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				TrackOrderModel trackOrderModel=new TrackOrderModel();
				trackOrderModel.setOrder_id(rs1.getInt(1));
				trackOrderModel.setTotalcost(rs1.getInt(11));
				trackOrderModel.setTransaction_date(rs1.getString(3));
				trackOrderModel.setShip_before(rs1.getString(5));
				trackOrderModel.setOrder_status(rs1.getString(7));
				items.add(trackOrderModel);
				
			}
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return items;
	}
	
	public ArrayList<TrackOrderModel> getShippedOrders(int user_surkey)
	{
		String getItems="select * from orders where u_surkey = ? and status = ?";
		
		try
		{
			PreparedStatement ps1=con.prepareStatement(getItems);
			//PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setInt(1, user_surkey);
			ps1.setString(2, "Shipped");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				TrackOrderModel trackOrderModel=new TrackOrderModel();
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
	
	public boolean updateOrder_asReceived(int o_surkey)
	{
		int itemcost=0,ordercost=0;
		int eBayBalance=0;
		int sellerBalance=0;
		int user_surkey =0;
		int bank_surkey=0;
		int qty=0,price=0,freeqty=0;
		int eBayaccount=16;
		String updateStatus="update orders set status =? where o_surkey=? ";
		String getOrderCost="select totalamount from orders where o_surkey = ?";
		String getItemsCost="select * from orderspecific where o_surkey = ?";
		String updateBalance ="update bank set balance = ? where b_surkey = ?";
		String getBalance="select balance from bank where b_surkey = ?";
		String getSeller="select u_surkey from seller where s_surkey = ?";
		String getBankKey="select b_surkey from bank where u_surkey = ?";
		String getItemPriceDetails="select price ,discount ,shippingcost from item where i_surkey=? ";
		
		try
		{
			PreparedStatement ps1=con.prepareStatement(updateStatus);
			//PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setString(1, "Received");
			ps1.setInt(2, o_surkey);
			if(ps1.executeUpdate()==0)
				return false;
			else
			{
				PreparedStatement ps2=con.prepareStatement(getItemsCost);
				ps2.setInt(1, o_surkey);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next())
				{
					int i_surkey=rs2.getInt(3);
					itemcost=0;
					qty=rs2.getInt(5);
					freeqty=rs2.getInt(8);
					price=rs2.getInt(6);
					if((qty-freeqty)>1)
					{
						PreparedStatement ps8=con.prepareStatement(getItemPriceDetails);
						ps8.setInt(1, i_surkey);
						ResultSet rs8=ps8.executeQuery();
						if(rs8.next())
						{
							int pr=rs8.getInt(1);
							int discount=rs8.getInt(2);
							int shippingCost=rs8.getInt(3);
							int priceafterdiscount=pr-((pr*discount)/100);
							itemcost=((qty-freeqty)*priceafterdiscount)+shippingCost;
						}
						
					}
					else
						itemcost=(qty-freeqty)*price;
					System.out.println("qty ="+qty+" price="+price+" itemcost"+ itemcost);
					PreparedStatement ps5=con.prepareStatement(getSeller);
					ps5.setInt(1, rs2.getInt(4));
					ResultSet rs5=ps5.executeQuery();
					if(rs5.next())
						user_surkey=rs5.getInt(1);
					
					PreparedStatement ps6=con.prepareStatement(getBankKey);
					ps6.setInt(1, user_surkey);
					ResultSet rs6=ps6.executeQuery();
					if(rs6.next())
						bank_surkey=rs6.getInt(1);
					System.out.println("Bank:"+bank_surkey);
					PreparedStatement ps7=con.prepareStatement(getBalance);
					ps7.setInt(1, bank_surkey);
					ResultSet rs7=ps7.executeQuery();
					if(rs7.next())
						sellerBalance=itemcost+(rs7.getInt(1));
					System.out.println(sellerBalance);
					PreparedStatement ps8=con.prepareStatement(updateBalance);
					ps8.setInt(1,sellerBalance);
					ps8.setInt(2, bank_surkey);
					ps8.executeUpdate();
				}
				
				PreparedStatement ps9=con.prepareStatement(getOrderCost);
				ps9.setInt(1, o_surkey);
				ResultSet rs9=ps9.executeQuery();
				if(rs9.next())
					ordercost=rs9.getInt(1);
				
				PreparedStatement ps3=con.prepareStatement(getBalance);
				ps3.setInt(1,eBayaccount);
				ResultSet rs3=ps3.executeQuery();
				if(rs3.next())
					eBayBalance=rs3.getInt(1)-(ordercost);
					
				
				PreparedStatement ps4=con.prepareStatement(updateBalance);
				ps4.setInt(1,eBayBalance);
				ps4.setInt(2,eBayaccount);
				ps4.executeUpdate();
				
				
				return true;
			}
			
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
	
	
}