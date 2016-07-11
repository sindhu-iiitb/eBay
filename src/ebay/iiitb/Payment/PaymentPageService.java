//tables : user , bank , cart , item , address , orders , orderspecific
//user : u_surkey , email 
//bank : balance , card_id
//cart : i_surkey , u_surkey ,quantity , freequantity 
//item : num_of_items_sold , i_surkey , quantity , s_surkey , price , discount , shippingcost
//address : line1 , line2 , city , state , pincode , mobile  , u_surkey
//orders : u_surkey , orderdate , reqdate , shipdate , salestax , status , timestamp , numofdays , deliverydate , totalamount , line1 , line2 , city , state , pincode , mobile , seller_status , user_status , user_cardnum , o_surkey
//orderspecific : o_surkey , i_surkey , s_surkey , quantity , priceafterdiscount , salestax , freequantity , item_status



package ebay.iiitb.Payment;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork2.ActionContext;

import ebay.iiitb.DBUtil.DbConnection;

public class PaymentPageService 
{	
	Map<String, Object> session = ActionContext.getContext().getSession();
	PaymentModel paymentModel;
	String status1,status2;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public PaymentPageService(PaymentModel paymentModel)
	{
		this.paymentModel = paymentModel;
	}
	int amount,osurkey;String line1,line2,city,state;
	int userid,count,grandtotal,time,item,qua,grandtotal1;
	String pincode,mobile;
	public String PaymentPageMethod(String user,String cardid)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		System.out.println("in service Class");
		String query = "select u_surkey from user where email=?";
		try
		{
						PreparedStatement ps=con.prepareStatement(query);
						ps.setString(1,user);
						ResultSet rs=ps.executeQuery();
						if(rs.next())
						{
							userid=rs.getInt(1);
							System.out.println("userid is:"+userid);
						}
					}//end of try
					catch (SQLException e) {
			   			e.printStackTrace();
					 }
		int price,totalprice,disc,shipp_cost;
				/*	String query2="select price,cart.quantity,item.handlingtime,item.shippingcost,item.discount from item,cart where cart.u_surkey=? and cart.i_surkey=item.i_surkey";
					int price,totalprice,disc,shipp_cost;*/
		            try
		    		{
		            	/*grandtotal=0;
		    			PreparedStatement ps3=con.prepareStatement(query2);
		    			ps3.setInt(1,userid);
		    			ResultSet rs2=ps3.executeQuery();
		                while(rs2.next())
		                 {
			               price=rs2.getInt(1);
			               disc = (rs2.getInt("item.discount")*price)/100;
			               shipp_cost = rs2.getInt("item.shippingcost");
			               price = price - disc;
			               totalprice= (price*(rs2.getInt(2)) ) + shipp_cost;
			               //grandtotal=grandtotal+totalprice;
			               System.out.println("grand total in query execution is:"+grandtotal);
			               }*/
		           grandtotal = (Integer)session.get("grandtotal");
		    	String checkAvailBalance="select balance from bank where card_id=?";
				PreparedStatement ps=con.prepareStatement(checkAvailBalance);				
				ps.setString(1, cardid);
				ResultSet rs=ps.executeQuery();
				System.out.println("hello1executed check balance");
				if(rs.next()) 
				{
					System.out.println("chck blance if");
					int temp=rs.getInt(1);
					
					System.out.println(temp);
					if(grandtotal<=temp)
					{				
						System.out.println("chck blance if if");
						status1="true";
						String updateBuyerAccount="update bank set balance = balance - ? where card_id=?";
						String updateeBayAccount="update bank set balance = balance + ? where card_id=?";
						ps=con.prepareStatement(updateBuyerAccount);
						ps.setInt(1, grandtotal);
						ps.setString(2, cardid);
						ps.executeUpdate();
						System.out.println("executed update");
						ps=con.prepareStatement(updateeBayAccount);	
						ps.setInt(1, grandtotal);
						ps.setString(2,"eBayAccount");
						ps.executeUpdate();
						System.out.println("executed update2");
						
						;
						String cartInfo="select i_surkey,quantity from cart where u_surkey=?";
						PreparedStatement ps2=con.prepareStatement(cartInfo);
						ps2.setInt(1, userid);
						ResultSet rs3=ps2.executeQuery();
						while(rs3.next())	
						{	System.out.println("in rs3.next()");
							item=rs3.getInt(1);
							qua=rs3.getInt(2);
							System.out.println("quantity purchaed"+qua);
							String itemUpdate="update item set quantity=? , num_of_items_sold=?  where i_surkey=?";
							String fetchQuantity="Select quantity,num_of_items_sold from item where i_surkey=?";
							PreparedStatement ps6=con.prepareStatement(fetchQuantity);
							ps6.setInt(1, item);
							ResultSet rs6=ps6.executeQuery();
							int count=0,sold=0;
							while(rs6.next())
							{
							count=rs6.getInt(1);	
							sold=rs6.getInt(2);
							System.out.println(count);
							System.out.println(sold);
							}
							int updatecount=count-qua;
							int updatesold=sold+qua;
							PreparedStatement ps4=con.prepareStatement(itemUpdate);
							System.out.println("in rs3.next() quantity"+item+" "+qua);
							ps4.setInt(1,updatecount);
							ps4.setInt(2, updatesold);
							ps4.setInt(3, item);
							ps4.executeUpdate();				
							System.out.println("out of rs3.next();");
							
						}
						String addressFetch="select line1,line2,city,state,pincode,mobile from address where u_surkey=?";
						
						PreparedStatement ps5=con.prepareStatement(addressFetch);
						ps5.setInt(1, userid);
						ResultSet rs5=ps5.executeQuery();
						System.out.println("inserting in order table address fetching");
						while(rs5.next())
						{	
							line1=rs5.getString(1);
							System.out.println(line1);
							line2=rs5.getString(2);

							System.out.println(line2);
														city=rs5.getString(3);

														System.out.println(city);
							state=rs5.getString(4);
							System.out.println(state);
							pincode=rs5.getString(5);
							mobile=rs5.getString(6);
							System.out.println(pincode+" "+mobile);
						}

						String orderinsert="insert into orders(u_surkey,orderdate,reqdate,shipdate,salestax,"
								+ "status,timestamp,numofdays,deliverydate,totalamount,line1,line2,city,state,"
								+ "pincode,mobile,seller_status,user_status,user_cardnum) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
						PreparedStatement ps4=con.prepareStatement(orderinsert);
						ps4.setInt(1, userid);
						System.out.println(new java.sql.Date(System.currentTimeMillis()));
						ps4.setDate(2, new java.sql.Date(System.currentTimeMillis()));
						ps4.setDate(3, new java.sql.Date(System.currentTimeMillis()));
						ps4.setDate(4, new java.sql.Date(System.currentTimeMillis()));
						ps4.setDouble(5,.25);
						ps4.setString(6,"Money Paid");
						ps4.setTimestamp(7, new java.sql.Timestamp(System.currentTimeMillis()));
						ps4.setInt(8, 8);
						ps4.setDate(9,new java.sql.Date(System.currentTimeMillis()));
						ps4.setInt(10,grandtotal);
													System.out.println("heloooooooooooooooooooooo  "+grandtotal);
						ps4.setString(11,line1);
						ps4.setString(12,line2);
						ps4.setString(13,city);
						ps4.setString(14,state);
						pincode=rs5.getString(5);
						mobile=rs5.getString(6);
						ps4.setString(17,"Payment Recieved");
						ps4.setString(18,"Payment Done");
						ps4.setString(19,cardid);
						System.out.println("done....");
						if(ps4.executeUpdate()>0){
							System.out.println("success");
						}
						System.out.println("inserting in order table done");
						
						String FetchOrderSurkey="select o_surkey from orders where u_surkey=?";
							System.out.println("executing FetchOrderSurkey");
						ps4=con.prepareStatement(FetchOrderSurkey);
						ps4.setInt(1,userid);
						rs5=ps4.executeQuery();
						while(rs5.next())
						{
							osurkey=rs5.getInt(1);
						}
						System.out.println("executed FetchOrderSurkey");
						
						String orderSpecificInfo="insert into orderspecific(o_surkey,i_surkey,s_surkey,"
								+ "quantity,priceafterdiscount, salestax,freequantity,item_status) values(?,?,?,?,?,?,?,?)";
						
						ps4=con.prepareStatement(orderSpecificInfo);
						ps4.setInt(1,osurkey);
						ps4.setDouble(6,14.04);
						String InfoCartItem="select i.i_surkey,i.s_surkey,c.quantity,c.freequantity,i.price,i.discount,i.shippingcost from item as i,cart as c "
								+ "where i.i_surkey=c.i_surkey ";
						ps2=con.prepareStatement(InfoCartItem);
						System.out.println("executing item cart info query");
						//ps2.setInt(1,userid);
						ResultSet rs6=ps2.executeQuery();
						while(rs6.next())
						{
						
							System.out.println(" "+rs6.getInt(1)+" "+rs6.getInt(2)+" "+rs6.getInt(3)+" "+rs6.getInt(4));
							ps4.setInt(2,rs6.getInt(1));
							ps4.setInt(3,rs6.getInt(2));
							ps4.setInt(4,rs6.getInt(3));
							
							   price=rs6.getInt("i.price");
				               disc = (rs6.getInt("i.discount")*price)/100;
				               shipp_cost = rs6.getInt("i.shippingcost");
				               price = price - disc + shipp_cost;
//				               totalprice= (price*(rs6.getInt(2)) ) + shipp_cost;
//				               grandtotal1=grandtotal1+totalprice;
							ps4.setInt(5,price);
							ps4.setInt(7, rs6.getInt("c.freequantity"));
							ps4.setString(8, "Money Paid");
							ps4.executeUpdate();
							System.out.println("entry done in OrderSpecific table");
						}		
						String clearCart="Delete from cart";
						ps4=con.prepareStatement(clearCart);
						ps4.executeUpdate();
						
					}
					else
					{
						
						status2="failure";
						System.out.println("insufficient balance");
						return status2;
					}
					
				}	
				rs.close();
				}
		            catch(SQLException e) {
			   			e.printStackTrace();
					 }

			
				
	return status1;
	}
			
				
	}

