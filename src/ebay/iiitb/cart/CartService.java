// tables : deals , item , vat , cart
// deals : deals_id
//item : i_surkey , quantity , i_surkey , s_surkey, discount , shippingcost , item_name, picture, price, item_desc,
// vat : vat_percentage , vat_surkey
// cart : u_surkey , i_surkey , quantity , deals_id , freeitem , freeitemprice , cart_surkey , u_surkey

package ebay.iiitb.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;



public class CartService {
	
	CartModel cartModel;
	ArrayList<CartModel> listOfItems = new ArrayList<CartModel>();
	ArrayList<CartItemModel> dealsItems = new ArrayList<CartItemModel>();
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public ArrayList<CartItemModel> getItemsOfDeals(int deals_id)
	{
		String getdealsItems = "select * from deals where deals_id = ?";
		String getItemdetails = "select * from item where i_surkey=?";
		try{
			PreparedStatement ps1=con.prepareStatement(getdealsItems);
			PreparedStatement ps2=con.prepareStatement(getItemdetails);
			ps1.setInt(1, deals_id);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
				for (int i = 2; i < 5 ;i++) {
					
					ps2.setInt(1, rs1.getInt(i));
					ResultSet rs2 = ps2.executeQuery();
						while(rs2.next())
						{
							CartItemModel item1 = new CartItemModel();
							item1.setI_surkey(rs2.getInt("i_surkey"));
							item1.setItemName(rs2.getString("item_name"));
							item1.setItem_desc(rs2.getString("item_desc"));
							item1.setPicture(rs2.getString("picture"));
							item1.setPrice(rs2.getInt("price"));
							item1.setQuantity(Integer.toString(rs2.getInt("quantity")));
							item1.setDiscount(rs2.getInt("item.discount"));
							item1.setShippingcost(rs2.getInt("shippingcost"));
							
							item1.setFreeflag(i);
							dealsItems.add(item1);
						}
				}
			}
		
		}catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		
		
		return dealsItems;
	}
	public int getVatPercentage()
	{
		int vat_per = 0;
		String getVatPercent = "select vat_percentage from vat where vat_surkey = ?";
		try{
			PreparedStatement ps1=con.prepareStatement(getVatPercent);
			ps1.setInt(1, 1);
			
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next())
			{
				vat_per = rs1.getInt(1);
				System.out.println(vat_per);
				
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
		return vat_per;
	}
	public int getCartId(int u_surkey, int i_surkey)
	{
		int cart_Id = 0;
		System.out.println("In service");
		String getCartId = "select * from cart where u_surkey = ? and i_surkey = ?";
		try{
			PreparedStatement ps1=con.prepareStatement(getCartId);
			ps1.setInt(1, u_surkey);
			ps1.setInt(2,i_surkey);
			ResultSet rs1 = ps1.executeQuery();
			System.out.println( u_surkey + " " + i_surkey);
			while(rs1.next())
			{
				cart_Id = rs1.getInt(1);
				System.out.println(cart_Id);
				
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return cart_Id;
		
	}
	public int getCartQty(int u_surkey, int i_surkey)
	{
		int qty = 0;
		System.out.println("In service");
		String getCartId = "select * from cart where u_surkey = ? and i_surkey = ?";
		try{
			PreparedStatement ps1=con.prepareStatement(getCartId);
			ps1.setInt(1, u_surkey);
			ps1.setInt(2,i_surkey);
			ResultSet rs1 = ps1.executeQuery();
			System.out.println( u_surkey + " " + i_surkey);
			while(rs1.next())
			{
				qty = rs1.getInt(4);
				
				
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return qty;
		
	}
	
	public void insertIntoCart(int u_surkey, int i_surkey, int qty, int deals_id, String freeitem, int price)
	{
		String insertCart = "insert into cart(u_surkey,i_surkey,quantity,deals_id,freeitem,freeitemprice) values(?,?,?,?,?,?)";
		try{
				PreparedStatement ps2=con.prepareStatement(insertCart);
				ps2.setInt(1, u_surkey);
				ps2.setInt(2,i_surkey);
				ps2.setInt(3, qty);
				ps2.setInt(4, deals_id);
				ps2.setString(5, freeitem);
				ps2.setInt(6, price);
				ps2.executeUpdate();
				
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean Updateqty(int cart_key, int qty, int item_key)
	{
		int avail_qty = 0;
		System.out.println("In update");
		String updateQuantity ="update cart set quantity = ? where cart_surkey = ?" ;
		String checkAvailableQuantity ="select quantity from item where i_surkey = ?";
		try{
			PreparedStatement ps6=con.prepareStatement(checkAvailableQuantity);
			ps6.setInt(1, item_key);
			ResultSet rs6 = ps6.executeQuery();
			while(rs6.next())
			{
				avail_qty = rs6.getInt(1);
			}
			
			if(avail_qty >= qty)
			{
				PreparedStatement ps3=con.prepareStatement(updateQuantity);
				ps3.setInt(1, qty);
				ps3.setInt(2,cart_key);
				ps3.executeUpdate();
			}
			else
			{
				return false;
			}
		}catch(SQLException e)
			{
				e.printStackTrace();
			}
		return true;
	}
	public ArrayList<CartModel> itemsInYourCart(int u_surkey)
	{
		String itemsInCart ="select cart.cart_surkey, cart.deals_id, cart.freeitem, cart.freeitemprice,"
				+ "item.i_surkey , item.s_surkey, item.discount,item.shippingcost,"
				+ "item.item_name, item.picture, item.price, item.item_desc,"
				+ "item.discount, cart.quantity from cart, item where cart.i_surkey = item.i_surkey and u_surkey =?";
//		String sellerDetails = "select user.firstname from user, seller where seller.s_surkey = ? and seller.u_surkey "
		try{
			PreparedStatement ps4=con.prepareStatement(itemsInCart);
			ps4.setInt(1, u_surkey);
			ResultSet rs4 = ps4.executeQuery();
			while(rs4.next())
			{
				CartModel cartitem = new CartModel();
				cartitem.setCartId(rs4.getInt(1));
				cartitem.setDeals_id(rs4.getInt("deals_id"));
				cartitem.setFreeitem(rs4.getString("freeitem"));
				cartitem.setFreeitemprice(rs4.getInt("freeitemprice"));
				CartItemModel item1 = new CartItemModel();
				item1.setI_surkey(rs4.getInt("i_surkey"));
				item1.setItemName(rs4.getString("item_name"));
				item1.setItem_desc(rs4.getString("item_desc"));
				item1.setPicture(rs4.getString("picture"));
				item1.setPrice(rs4.getInt("price"));
				item1.setQuantity(Integer.toString(rs4.getInt("quantity")));
				item1.setDiscount(rs4.getInt("item.discount"));
				item1.setShippingcost(rs4.getInt("shippingcost"));

				cartitem.setItem(item1);
				listOfItems.add(cartitem);
			}
		
		}catch(SQLException e)
			{
				e.printStackTrace();
			}
		return listOfItems;
	}
	
	public void removeFromCart(int cart_key)
	{
		String deletefromCart = "delete from cart where cart_surkey = ?";
		try{
			PreparedStatement ps5=con.prepareStatement(deletefromCart);
			ps5.setInt(1, cart_key);
			ps5.executeUpdate();
		
		}catch(SQLException e)
			{
				e.printStackTrace();
			}
		
	}

}
