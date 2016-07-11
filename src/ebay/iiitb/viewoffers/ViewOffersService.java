package ebay.iiitb.viewoffers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import ebay.iiitb.DBUtil.DbConnection;
import ebay.iiitb.cart.CartService;

public class ViewOffersService {

	ArrayList<ViewOffersModel> tempitems=new ArrayList<ViewOffersModel>();
	ArrayList<ViewOffersModel> viewoffers=new ArrayList<ViewOffersModel>();
	ArrayList<Integer> itemids=new ArrayList<Integer>();
	DbConnection db=new DbConnection();
	Connection con =db.getConnection();
	
	
	
	public ArrayList<ViewOffersModel> viewOffers(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		int userId = (Integer) session.get("user_surr_key");
		int totalcost=0;
		int vat=0;
		System.out.println(userId);
		ArrayList<ViewOffersModel> cartitems=new ArrayList<ViewOffersModel>();
		int item1index,item2index,item3index;
		ViewOffersModel viewOffersModel4=null;
		ViewOffersModel viewOffersModel5=null;
		ViewOffersModel viewOffersfree=null;
		
				
		try{
			// getting cart details
			String updatecart="update cart set freequantity=0 where u_surkey=?";
			String getfromcart="select * from cart where u_surkey=?";
			PreparedStatement ps=con.prepareStatement(updatecart);
			ps.setInt(1, userId);
			ps.executeUpdate();
			ps=con.prepareStatement(getfromcart);
			ps.setInt(1, userId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ViewOffersModel viewOffersModel=new ViewOffersModel();
				viewOffersModel.setI_surkey(rs.getInt(3));
				viewOffersModel.setQuantity(rs.getInt(4));
				cartitems.add(viewOffersModel);
			}
			
			//getting details and adding to temp array list
			for (Iterator iterator = cartitems.iterator(); iterator.hasNext();) {
				ViewOffersModel viewOffersModel = (ViewOffersModel) iterator.next();
				String getitemdetails="select * from item where i_surkey=?";
				PreparedStatement ps1=con.prepareStatement(getitemdetails);
				ps1.setInt(1, viewOffersModel.getI_surkey());
				ResultSet res1=ps1.executeQuery();
				while(res1.next()){
					ViewOffersModel viewOffersModel1=new ViewOffersModel();
					viewOffersModel1.setQuantity(viewOffersModel.getQuantity());
					viewOffersModel1.setItem_Name(res1.getString(2));
					viewOffersModel1.setPicture(res1.getString(3));
					viewOffersModel1.setPrice(res1.getInt(4));
					viewOffersModel1.setItem_desc(res1.getString(5));
					viewOffersModel1.setDiscount(res1.getInt(7));
					viewOffersModel1.setBrand(res1.getString(16));
					viewOffersModel1.setColor(res1.getString(13));
					viewOffersModel1.setShipping_details(res1.getString(20));
					viewOffersModel1.setShippingcost(res1.getInt(22));
					viewOffersModel1.setCategory_id(res1.getInt(23));
					viewOffersModel1.setSubcategory_id(res1.getInt(24));
					viewOffersModel1.setDeal_eligible(res1.getString(34));
					viewOffersModel1.setDealitems(res1.getString(33));
					viewOffersModel1.setI_surkey(viewOffersModel.getI_surkey());
					viewOffersModel1.setDeal_added(res1.getString("deal_added"));
					itemids.add(viewOffersModel.getI_surkey());
					tempitems.add(viewOffersModel1);
				}
			}
			
			for (Iterator iterator = tempitems.iterator(); iterator.hasNext();) {
				ViewOffersModel viewOffersModel = (ViewOffersModel) iterator.next();
				System.out.println(viewOffersModel.getI_surkey());
			}
			
				//logic for view offers
				while(!tempitems.isEmpty()){
					
					ViewOffersModel viewOffersModel2 = tempitems.get(0);
					
					//if deals are present for viewOffersModel2
					System.out.println(viewOffersModel2.getI_surkey());
					System.out.println(viewOffersModel2.getDeal_eligible());
					if(viewOffersModel2.getDeal_added().equals("Yes"))
					{
						String[] dealitemsstring=viewOffersModel2.getDealitems().split(",");
						int[] dealitems=new int[3];
						dealitems[0]=Integer.parseInt(dealitemsstring[0]);
						dealitems[1]=Integer.parseInt(dealitemsstring[1]);
						dealitems[2]=Integer.parseInt(dealitemsstring[2]);
						/**
						 * If deals have the same items same
						 */
									
						
						// two non free items present

						if(itemids.contains(dealitems[0]) && itemids.contains(dealitems[1])){
							
							// free item also present
							
							if(itemids.contains(dealitems[2]))
							{
								if(dealitems[0]==dealitems[1] && dealitems[1]==dealitems[2] ){
									
									// all with same id i1,i1,i1
									int totalquantity=viewOffersModel2.getQuantity();
									
									if(totalquantity<=1)
									{
										computeNoDeal(viewOffersModel2);
										itemids.remove(0);
										tempitems.remove(0);
									}
									
									else if(totalquantity==2){
										
										
										computeNoDeal(viewOffersModel2);
										
										ViewOffersModel viewOffersModelfree=new ViewOffersModel();
										int itemavailable=0;
										try{
											// getting cart details
											String extraitems="select quantity from item where i_surkey=?";
											PreparedStatement ps1=con.prepareStatement(extraitems);
											ps1.setInt(1,dealitems[0]);
											ResultSet rs1=ps1.executeQuery();
											while(rs1.next()){
												itemavailable=rs1.getInt(1);
											}
											
										}catch (SQLException e) {
											
											e.printStackTrace();
										}
										if(itemavailable>=3)
										{
											viewOffersModelfree.setQuantity(1);
											viewOffersModelfree.setPrice(0);
											viewOffersModelfree.setPicture(viewOffersModel2.getPicture());
											viewOffersModelfree.setItem_Name(viewOffersModel2.getItem_Name());
											viewOffersModelfree.setI_surkey(viewOffersModel2.getI_surkey());
											updatecart(dealitems[0], 3);
											//updatefreeattribute(userId, dealitems[2], 1);
										}
										else
										{
											viewOffersModelfree.setQuantity(1);
											viewOffersModelfree.setPrice(0);
											viewOffersModelfree.setPicture(viewOffersModel2.getPicture());
											viewOffersModelfree.setNotavailable(1);
											viewOffersModelfree.setItem_Name(viewOffersModel2.getItem_Name());
											viewOffersModelfree.setI_surkey(viewOffersModel2.getI_surkey());
											
										}
										viewoffers.add(viewOffersModelfree);
										itemids.remove(0);
										tempitems.remove(0);
									}
									else {
																
										int numberofpriceditems=((totalquantity/3)*2)+(totalquantity%3);
										int numberoffreeitems=numberofpriceditems/2;
										ViewOffersModel viewOffersModel=new ViewOffersModel();
										ViewOffersModel viewOffersModelfree=new ViewOffersModel();
										int totalcost1;
										int priceafterdiscount;
										int discount;
										int shippingcost;
										int price;
										
										price=viewOffersModel2.getPrice();
										discount=viewOffersModel2.getDiscount();
										shippingcost=viewOffersModel2.getShippingcost();
										priceafterdiscount=price-(price*discount/100);
										totalcost1=(priceafterdiscount)*numberofpriceditems+shippingcost;
										viewOffersModel.setTotalcost(totalcost1);
										viewOffersModel.setPriceafterdiscount(priceafterdiscount);
										viewOffersModel.setPicture(viewOffersModel2.getPicture());
										viewOffersModel.setQuantity(numberofpriceditems);
										viewOffersModel.setPrice(viewOffersModel2.getPrice());
										viewOffersModel.setShippingcost(shippingcost);
										viewOffersModel.setDiscount(discount);
										viewOffersModel.setI_surkey(viewOffersModel2.getI_surkey());
										viewoffers.add(viewOffersModel);
										
										int itemavailable=0;
										try{
											// getting cart details
											String extraitems="select quantity from item where i_surkey=?";
											PreparedStatement ps1=con.prepareStatement(extraitems);
											ps1.setInt(1,dealitems[0]);
											ResultSet rs1=ps1.executeQuery();
											while(rs1.next()){
												itemavailable=rs1.getInt(1);
											}
											
										}catch (SQLException e) {
											e.printStackTrace();
										}
										if(numberoffreeitems+numberofpriceditems>itemavailable)
										{
											int temp=itemavailable-numberofpriceditems;
											viewOffersModelfree.setQuantity(numberoffreeitems);
											viewOffersModelfree.setPicture(viewOffersModel2.getPicture());
											viewOffersModelfree.setNotavailable(numberoffreeitems-temp);
											viewOffersModelfree.setI_surkey(dealitems[2]);
											updatecart(dealitems[0], itemavailable);
											//updatefreeattribute(userId, viewOffersModelfree.getI_surkey(), temp);
										}
										else
										{
											viewOffersModelfree.setQuantity(numberoffreeitems);
											viewOffersModelfree.setPicture(viewOffersModel2.getPicture());
//											viewOffersModelfree.setI_surkey(viewOffersfree.getI_surkey());
											viewOffersModelfree.setI_surkey(dealitems[2]);
											updatecart(dealitems[0], numberoffreeitems+numberofpriceditems);
											//updatefreeattribute(userId, dealitems[2], numberoffreeitems);
										}
										viewoffers.add(viewOffersModelfree);
										itemids.remove(0);
										tempitems.remove(0);
										
									}
									
									
								}
								
								else if(dealitems[0]==dealitems[1]){
									//different free item and all present i1,i1,i2
									
									
									item1index=itemids.indexOf(dealitems[0]);
									
									item3index=itemids.indexOf(dealitems[2]);
									 viewOffersModel4=tempitems.get(item1index);
									 
									 viewOffersfree=tempitems.get(item3index);
									computeDeal(viewOffersModel4,viewOffersfree);
									itemids.remove(new Integer(dealitems[0]));
									
									itemids.remove(new Integer(dealitems[2]));
									tempitems.remove(viewOffersModel4);
									
									tempitems.remove(viewOffersfree);
								
									
									
								}
								
								else if((dealitems[0]==dealitems[2]) ){
									// i1,i2,i1
									
									
									item1index=itemids.indexOf(dealitems[1]);
									
									item3index=itemids.indexOf(dealitems[2]);
									 viewOffersModel4=tempitems.get(item1index);
									 
									 viewOffersfree=tempitems.get(item3index);
									computeDeal(viewOffersModel4,viewOffersfree,true);
									itemids.remove(new Integer(dealitems[1]));
									
									itemids.remove(new Integer(dealitems[2]));
									tempitems.remove(viewOffersModel4);
									
									tempitems.remove(viewOffersfree);
									
									
									
								}
								else if((dealitems[1]==dealitems[2])){
									//i1,i2,i2
									
									item1index=itemids.indexOf(dealitems[0]);
									
									item3index=itemids.indexOf(dealitems[2]);
									 viewOffersModel4=tempitems.get(item1index);
									 
									 viewOffersfree=tempitems.get(item3index);
									computeDeal(viewOffersModel4,viewOffersfree,true);
									itemids.remove(new Integer(dealitems[0]));
									
									itemids.remove(new Integer(dealitems[2]));
									tempitems.remove(viewOffersModel4);
									
									tempitems.remove(viewOffersfree);
									
									
								}
								
								else{
									item1index=itemids.indexOf(dealitems[0]);
									item2index=itemids.indexOf(dealitems[1]);
									item3index=itemids.indexOf(dealitems[2]);
									 viewOffersModel4=tempitems.get(item1index);
									 viewOffersModel5=tempitems.get(item2index);
									 viewOffersfree=tempitems.get(item3index);
									computeDeal(viewOffersModel4,viewOffersModel5,viewOffersfree);
									itemids.remove(new Integer(dealitems[0]));
									itemids.remove(new Integer(dealitems[1]));
									itemids.remove(new Integer(dealitems[2]));
									tempitems.remove(viewOffersModel4);
									tempitems.remove(viewOffersModel5);
									tempitems.remove(viewOffersfree);
								}
							}
							
							//free item not present
							
							else
							{
								if(dealitems[0]==dealitems[1]){
									// free item diff and not present code
									
	
									
									item1index=itemids.indexOf(dealitems[0]);
									
									
									 viewOffersModel4=tempitems.get(item1index);

										String getitemdetails="select * from item where i_surkey=?";
									 PreparedStatement ps1;
										ViewOffersModel freeitemmodel=null;
										try {
											ps1 = con.prepareStatement(getitemdetails);
											ps1.setInt(1, dealitems[2]);
											ResultSet res1=ps1.executeQuery();
											while(res1.next()){
												freeitemmodel=new ViewOffersModel();
												freeitemmodel.setItem_Name(res1.getString(2));
												freeitemmodel.setPicture(res1.getString(3));
												freeitemmodel.setPrice(0);
												freeitemmodel.setItem_desc(res1.getString(5));
//												freeitemmodel.setDiscount(res1.getInt(7));
												
												freeitemmodel.setBrand(res1.getString(16));
												freeitemmodel.setColor(res1.getString(13));
												freeitemmodel.setShipping_details(res1.getString(20));
												freeitemmodel.setShippingcost(res1.getInt(22));
												freeitemmodel.setCategory_id(res1.getInt(23));
												freeitemmodel.setSubcategory_id(res1.getInt(24));
												freeitemmodel.setDeal_eligible(res1.getString(35));
												freeitemmodel.setDealitems(res1.getString(34));
												freeitemmodel.setI_surkey(res1.getInt(1));
											}
											
										}catch (SQLException e)
										{
											System.out.println(e);
										}
									
									computeDeal(viewOffersModel4,freeitemmodel);
									itemids.remove(new Integer(dealitems[0]));
									
									
									tempitems.remove(viewOffersModel4);
									
								
									
								}
								else
								{	
								item1index=itemids.indexOf(dealitems[0]);
								item2index=itemids.indexOf(dealitems[1]);
								 viewOffersModel4=tempitems.get(item1index);
								 viewOffersModel5=tempitems.get(item2index);
								computeDeal(viewOffersModel4,viewOffersModel5,dealitems[2]);
								itemids.remove(new Integer(dealitems[0]));
								itemids.remove(new Integer(dealitems[1]));
								tempitems.remove(viewOffersModel4);
								tempitems.remove(viewOffersModel5);
								}
							}
													
						}
						
						// free item and non free item present
						
						
						else if(itemids.contains(dealitems[0]) && itemids.contains(dealitems[2])){
							
							if(dealitems[0]==dealitems[2])
							{
								//when 1 and free item are same compute nodeals 
								item1index=itemids.indexOf(dealitems[0]);
								viewOffersModel5=tempitems.get(item1index);
								 computeNoDeal(viewOffersModel5);
								 itemids.remove(new Integer(dealitems[0]));
								 tempitems.remove(viewOffersModel5);

							}
							
							
							else{
								item1index=itemids.indexOf(dealitems[0]);
								item3index=itemids.indexOf(dealitems[2]);
	    						 viewOffersModel5=tempitems.get(item1index);
								 viewOffersfree=tempitems.get(item3index);
								 computeNoDeal(viewOffersModel5);
								 computeNoDeal(viewOffersfree);
							    itemids.remove(new Integer(dealitems[0]));
								itemids.remove(new Integer(dealitems[2]));
								tempitems.remove(viewOffersModel5);
								tempitems.remove(viewOffersfree);
							}
						}
						
						
						//
						else if(itemids.contains(dealitems[1]) && itemids.contains(dealitems[2])){
							
							if(dealitems[1]==dealitems[2])
							{
								//when 1 and free item are same compute nodeals 
								item1index=itemids.indexOf(dealitems[1]);
								viewOffersModel5=tempitems.get(item1index);
								 computeNoDeal(viewOffersModel5);
								 itemids.remove(new Integer(dealitems[1]));
								 tempitems.remove(viewOffersModel5);
							}
							else{
								item2index=itemids.indexOf(dealitems[1]);
								item3index=itemids.indexOf(dealitems[2]);
								viewOffersModel4=tempitems.get(item2index);
								viewOffersfree=tempitems.get(item3index);
								 computeNoDeal(viewOffersModel4);
								 computeNoDeal(viewOffersfree);
								 itemids.remove(new Integer(dealitems[1]));
								itemids.remove(new Integer(dealitems[2]));
								tempitems.remove(viewOffersModel4);
								tempitems.remove(viewOffersfree);
							}
						}
						
						else {
							if(itemids.contains(dealitems[0]))
							{
								item1index=itemids.indexOf(dealitems[0]);
								viewOffersModel5=tempitems.get(item1index);
								 computeNoDeal(viewOffersModel5);
								  itemids.remove(new Integer(dealitems[0]));
								tempitems.remove(viewOffersModel5);
							}
							else if(itemids.contains(dealitems[1])){
								item1index=itemids.indexOf(dealitems[1]);
								viewOffersModel5=tempitems.get(item1index);
								 computeNoDeal(viewOffersModel5);
								  itemids.remove(new Integer(dealitems[1]));
								tempitems.remove(viewOffersModel5);
							}
							else
							{
								item1index=itemids.indexOf(dealitems[2]);
								viewOffersModel5=tempitems.get(item1index);
								 computeNoDeal(viewOffersModel5);
								  itemids.remove(new Integer(dealitems[2]));
								tempitems.remove(viewOffersModel5);
							}
							
						}
						
						
						
					}
						
					else
					{
					    computeNoDeal(viewOffersModel2);
					    tempitems.remove(0);
						itemids.remove(0);
					}
				}
			}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("view offers size"+viewoffers.size());
		for(ViewOffersModel v:viewoffers){
			totalcost=totalcost+v.getTotalcost();
		}
		int vat_percent =getVatPercentage();
		vat = (totalcost*vat_percent)/100;
		
		ViewOffersModel total=new ViewOffersModel();
		total.setVat(vat);
		total.setTotalcost(totalcost);
		viewoffers.add(total);
		freeQtyUpdate(viewoffers);
		
		return viewoffers;
	}



	private void computeDeal(ViewOffersModel viewOffersModel4, ViewOffersModel viewOffersfree, boolean b) {
		int quantity1=0,quantity2=0,quantity3=0;
		quantity1=viewOffersModel4.getQuantity();
		
		quantity3=viewOffersfree.getQuantity();
		int totalcost1;
		int priceafterdiscount1;
		int discount1;
		int shippingcost1;
		int price1;
		
		
		/**
		 * Adding the non free items to viewOffers arraylist
		 */
		
		

		Map<String, Object> session = ActionContext.getContext().getSession();
		int u_surkey = (Integer) session.get("user_surr_key");
		int itemavailable=0;
		try{
			// getting cart details
			String extraitems="select quantity from item where i_surkey=?";
			PreparedStatement ps=con.prepareStatement(extraitems);
			ps.setInt(1, viewOffersfree.getI_surkey());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				itemavailable=rs.getInt(1);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(viewOffersfree.getQuantity()>viewOffersModel4.getQuantity())
		{
			int diff=viewOffersfree.getQuantity()-viewOffersModel4.getQuantity();
			
			computeNoDeal(viewOffersModel4);
			ViewOffersModel viewOffersModelfree=new ViewOffersModel();
			viewOffersModelfree.setItem_Name(viewOffersfree.getItem_Name());
			viewOffersModelfree.setPicture(viewOffersfree.getPicture());
			
			viewOffersModelfree.setItem_desc(viewOffersfree.getItem_desc());
			
			viewOffersModelfree.setBrand(viewOffersfree.getBrand());
			viewOffersModelfree.setColor(viewOffersfree.getColor());
			viewOffersModelfree.setShipping_details(viewOffersfree.getShipping_details());
			
			viewOffersModelfree.setCategory_id(viewOffersfree.getCategory_id());
			viewOffersModelfree.setSubcategory_id(viewOffersfree.getSubcategory_id());
			viewOffersModelfree.setQuantity(viewOffersModel4.getQuantity());
			viewOffersModelfree.setI_surkey(viewOffersfree.getI_surkey());
			viewoffers.add(viewOffersModelfree);
			//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), viewOffersModelfree.getQuantity());
			viewOffersfree.setQuantity(diff);
			computeNoDeal(viewOffersfree);
			
			
		}
		
		else
		{
			
			computeNoDeal(viewOffersModel4);
			ViewOffersModel viewOffersModelfree=new ViewOffersModel();
			viewOffersModelfree.setItem_Name(viewOffersfree.getItem_Name());
			viewOffersModelfree.setPicture(viewOffersfree.getPicture());
			viewOffersModelfree.setI_surkey(viewOffersfree.getI_surkey());
			viewOffersModelfree.setItem_desc(viewOffersfree.getItem_desc());
			
			viewOffersModelfree.setBrand(viewOffersfree.getBrand());
			viewOffersModelfree.setColor(viewOffersfree.getColor());
			viewOffersModelfree.setShipping_details(viewOffersfree.getShipping_details());
			
			viewOffersModelfree.setCategory_id(viewOffersfree.getCategory_id());
			viewOffersModelfree.setSubcategory_id(viewOffersfree.getSubcategory_id());
			
			
			if(itemavailable-viewOffersfree.getQuantity()>=viewOffersfree.getQuantity()){
				viewOffersModelfree.setQuantity(viewOffersfree.getQuantity());
				updatecart(viewOffersModelfree.getI_surkey(), viewOffersfree.getQuantity()*2);
				//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), viewOffersModelfree.getQuantity());
				
			}
			else
			{
				viewOffersModelfree.setNotavailable(2*viewOffersfree.getQuantity()-itemavailable);
				viewOffersModelfree.setQuantity(itemavailable-viewOffersfree.getQuantity());
				updatecart(viewOffersModelfree.getI_surkey(), viewOffersfree.getQuantity()+viewOffersModelfree.getQuantity());
				//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), viewOffersModelfree.getQuantity()-viewOffersfree.getNotavailable());
			}
			
//			viewOffersModelfree.setQuantity(viewOffersModel4.getQuantity());
			viewoffers.add(viewOffersModelfree);
//			viewOffersfree.setQuantity(diff);
			computeNoDeal(viewOffersfree);
			
			
			
		}
		
	}



	private void computeDeal(ViewOffersModel viewOffersModel4, ViewOffersModel viewOffersfree) {
	
		int quantity1=0,quantity2=0,quantity3=0;
		quantity1=viewOffersModel4.getQuantity();
		
		quantity3=viewOffersfree.getQuantity();
		int totalcost1;
		int priceafterdiscount1;
		int discount1;
		int shippingcost1;
		int price1;
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		int u_surkey = (Integer) session.get("user_surr_key");
	
		/**
		 * Adding the non free items to viewOffers arraylist
		 */
		
		price1=viewOffersModel4.getPrice();
		discount1=viewOffersModel4.getDiscount();
		shippingcost1=viewOffersModel4.getShippingcost();
		priceafterdiscount1=price1-(price1*discount1/100);
		totalcost1=(priceafterdiscount1)*quantity1+shippingcost1;				
		viewOffersModel4.setTotalcost(totalcost1);
		viewOffersModel4.setPriceafterdiscount(priceafterdiscount1);
		viewOffersModel4.setQuantity(quantity1);
		viewoffers.add(viewOffersModel4);
		
		int itemavailable=0;
		try{
			// getting cart details
			String extraitems="select quantity from item where i_surkey=?";
			PreparedStatement ps=con.prepareStatement(extraitems);
			ps.setInt(1, viewOffersfree.getI_surkey());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				itemavailable=rs.getInt(1);
			}
			
		}catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		if(quantity1==1)
		{
			
			 computeNoDeal(viewOffersModel4);
			 computeNoDeal(viewOffersfree);
			 
		}
		
		else
		{
			int freeitemnumber=quantity1/2;
			int freeextra=freeitemnumber-viewOffersfree.getQuantity();
			
			if(freeextra==0)
			{
				viewOffersfree.setQuantity(freeitemnumber);
				viewOffersfree.setPrice(0);
				viewOffersfree.setDiscount(0);
				viewOffersfree.setShippingcost(0);
				
				viewoffers.add(viewOffersfree);
				//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), freeitemnumber);
			}
			else if(freeextra>0)
			{
				if(freeextra<= (itemavailable-viewOffersfree.getQuantity())){
					viewOffersfree.setQuantity(freeitemnumber);
					viewOffersfree.setPrice(0);
					viewOffersfree.setDiscount(0);
					viewOffersfree.setShippingcost(0);
					viewoffers.add(viewOffersfree);
					updatecart(viewOffersfree.getI_surkey(), freeitemnumber);
					//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), freeitemnumber);
				}
				else
				{
					viewOffersfree.setQuantity(freeitemnumber);
					viewOffersfree.setPrice(0);
					viewOffersfree.setDiscount(0);
					viewOffersfree.setShippingcost(0);
					int notavailable=freeextra-itemavailable;
					viewOffersfree.setNotavailable(notavailable);
					viewoffers.add(viewOffersfree);
					updatecart(viewOffersfree.getI_surkey(), itemavailable);
					//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), freeitemnumber-notavailable);
				}
			}
			else
			{
				
				ViewOffersModel freeitemwithprice=new ViewOffersModel();
				freeitemwithprice.setItem_Name(viewOffersfree.getItem_Name());
				freeitemwithprice.setPicture(viewOffersfree.getPicture());
				freeitemwithprice.setPrice(viewOffersfree.getPrice());
				freeitemwithprice.setItem_desc(viewOffersfree.getItem_desc());
				freeitemwithprice.setDiscount(viewOffersfree.getDiscount());
				freeitemwithprice.setBrand(viewOffersfree.getBrand());
				freeitemwithprice.setColor(viewOffersfree.getColor());
				freeitemwithprice.setShipping_details(viewOffersfree.getShipping_details());
				freeitemwithprice.setShippingcost(viewOffersfree.getShippingcost());
				freeitemwithprice.setCategory_id(viewOffersfree.getCategory_id());
				freeitemwithprice.setSubcategory_id(viewOffersfree.getSubcategory_id());
				freeitemwithprice.setDeal_eligible(viewOffersfree.getDeal_eligible());
				freeitemwithprice.setDealitems(viewOffersfree.getDealitems());
				freeitemwithprice.setI_surkey(viewOffersfree.getI_surkey());
				viewOffersfree.setQuantity(freeitemnumber);
				viewOffersfree.setPrice(0);
				viewOffersfree.setTotalcost(0);
				viewoffers.add(viewOffersfree);
				//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), freeitemnumber);
				//adding price to the extra free items
				
				int totalcost;
				int priceafterdiscount;
				int discount;
				int shippingcost;
				int price;
				
				
				price=freeitemwithprice.getPrice();
				discount=freeitemwithprice.getDiscount();
				shippingcost=freeitemwithprice.getShippingcost();
				priceafterdiscount=price-(price*discount/100);
				
				totalcost=(priceafterdiscount+shippingcost)*Math.abs(freeextra);
				freeitemwithprice.setQuantity(Math.abs(freeextra));
				freeitemwithprice.setTotalcost(totalcost);
				freeitemwithprice.setPriceafterdiscount(priceafterdiscount);
						
				viewoffers.add(freeitemwithprice);
			
			}
			
		}
		
		
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
	private void computeDeal(ViewOffersModel viewOffersModel4, ViewOffersModel viewOffersModel5,int freeid) {
		
		

		int quantity1=0,quantity2=0;
		quantity1=viewOffersModel4.getQuantity();
		quantity2=viewOffersModel5.getQuantity();
		
		int totalcost1,totalcost2;
		int priceafterdiscount1,priceafterdiscount2;
		int discount1,discount2;
		int shippingcost1,shippingcost2;
		int price1,price2;
		
		
		/**
		 * Adding the non free items to viewOffers arraylist
		 */
		
		price1=viewOffersModel4.getPrice();
		discount1=viewOffersModel4.getDiscount();
		shippingcost1=viewOffersModel4.getShippingcost();
		priceafterdiscount1=price1-(price1*discount1/100);
		totalcost1=(priceafterdiscount1)*quantity1+shippingcost1;				
		viewOffersModel4.setTotalcost(totalcost1);
		viewOffersModel4.setPriceafterdiscount(priceafterdiscount1);
		viewOffersModel4.setQuantity(quantity1);
		viewoffers.add(viewOffersModel4);

		price2=viewOffersModel5.getPrice();
		discount2=viewOffersModel5.getDiscount();
		shippingcost2=viewOffersModel5.getShippingcost();
		priceafterdiscount2=price2-(price2*discount2/100);
		totalcost2=(priceafterdiscount2)*quantity2+shippingcost2;				
		viewOffersModel5.setTotalcost(totalcost2);
		viewOffersModel5.setPriceafterdiscount(priceafterdiscount2);
		viewOffersModel5.setQuantity(quantity2);
		viewoffers.add(viewOffersModel5);
		
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		int u_surkey = (Integer) session.get("user_surr_key");
		
		
		
		
		// Code to fetch free item details
				
		String getitemdetails="select * from item where i_surkey=?";
		PreparedStatement ps1;
		ViewOffersModel freeitemmodel=null;
		try {
			ps1 = con.prepareStatement(getitemdetails);
			ps1.setInt(1, freeid);
			ResultSet res1=ps1.executeQuery();
			while(res1.next()){
				freeitemmodel=new ViewOffersModel();
				freeitemmodel.setItem_Name(res1.getString(2));
				freeitemmodel.setPicture(res1.getString(3));
				freeitemmodel.setPrice(0);
				freeitemmodel.setItem_desc(res1.getString(5));
				freeitemmodel.setDiscount(res1.getInt(7));
				freeitemmodel.setBrand(res1.getString(16));
				freeitemmodel.setColor(res1.getString(13));
				freeitemmodel.setShipping_details(res1.getString(20));
				freeitemmodel.setShippingcost(res1.getInt(22));
				freeitemmodel.setCategory_id(res1.getInt(23));
				freeitemmodel.setSubcategory_id(res1.getInt(24));
				freeitemmodel.setDeal_eligible(res1.getString(35));
				freeitemmodel.setDealitems(res1.getString(34));
				freeitemmodel.setI_surkey(res1.getInt(1));
				
			}
			
			
			int itemavailable=0;
			try{
				// getting cart details
				String extraitems="select quantity from item where i_surkey=?";
				PreparedStatement ps=con.prepareStatement(extraitems);
				ps.setInt(1,freeid );
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					itemavailable=rs.getInt(1);
				}
				
			}catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
			
			if(quantity1==quantity2)
			{
				int unavailable=0;
				if(quantity1>itemavailable)
				{
					unavailable=quantity1-itemavailable;
					freeitemmodel.setQuantity(quantity1);
					freeitemmodel.setPrice(0);
					freeitemmodel.setDiscount(0);
					freeitemmodel.setNotavailable(unavailable);
					updatecart(freeid, itemavailable);
				}
				else
				{
					freeitemmodel.setPrice(0);
					freeitemmodel.setDiscount(0);
				freeitemmodel.setQuantity(quantity1);
				freeitemmodel.setNotavailable(unavailable);
				updatecart(freeid, quantity1);
				}
				//updatefreeattribute(u_surkey, freeid,quantity1-unavailable);
			}
			else
			{
				int min= quantity1 < quantity2 ? quantity1 : quantity2;
				System.out.println("MIn"+min);
				int unavailable=0;
				if(min>itemavailable)
				{
					unavailable=min-itemavailable;
					freeitemmodel.setNotavailable(unavailable);
					freeitemmodel.setPrice(0);
					freeitemmodel.setDiscount(0);
					freeitemmodel.setQuantity(min);
					updatecart(freeid, itemavailable);
				}
				else
				{
				freeitemmodel.setNotavailable(unavailable);
				freeitemmodel.setQuantity(min);
				freeitemmodel.setPrice(0);
				freeitemmodel.setDiscount(0);
				updatecart(freeid, min);
				}
				//updatefreeattribute(u_surkey, freeid,min-unavailable);
			}
			viewoffers.add(freeitemmodel);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * Computing deals with all items present
	 * @param viewOffersModel4
	 * @param viewOffersModel5
	 */
	private void computeDeal(ViewOffersModel viewOffersModel4, ViewOffersModel viewOffersModel5, ViewOffersModel viewOffersfree) {

		int quantity1=0,quantity2=0,quantity3=0;
		quantity1=viewOffersModel4.getQuantity();
		quantity2=viewOffersModel5.getQuantity();
		quantity3=viewOffersfree.getQuantity();
		int totalcost1,totalcost2;
		int priceafterdiscount1,priceafterdiscount2;
		int discount1,discount2;
		int shippingcost1,shippingcost2;
		int price1,price2;
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		int u_surkey = (Integer) session.get("user_surr_key");
		
		
		
		/**
		 * Adding the non free items to viewOffers arraylist
		 */
		
		price1=viewOffersModel4.getPrice();
		discount1=viewOffersModel4.getDiscount();
		shippingcost1=viewOffersModel4.getShippingcost();
		priceafterdiscount1=price1-(price1*discount1/100);
		if(quantity1>0){
		totalcost1=(priceafterdiscount1)*quantity1+shippingcost1;				
		viewOffersModel4.setTotalcost(totalcost1);
		}
		viewOffersModel4.setPriceafterdiscount(priceafterdiscount1);
		viewOffersModel4.setQuantity(quantity1);
		viewoffers.add(viewOffersModel4);

		price2=viewOffersModel5.getPrice();
		discount2=viewOffersModel5.getDiscount();
		shippingcost2=viewOffersModel5.getShippingcost();
		priceafterdiscount2=price2-(price2*discount2/100);
		if(quantity2>0){
		totalcost2=(priceafterdiscount2)*quantity2+shippingcost2;				
		viewOffersModel5.setTotalcost(totalcost2);
		}
		viewOffersModel5.setPriceafterdiscount(priceafterdiscount2);
		viewOffersModel5.setQuantity(quantity2);
		viewoffers.add(viewOffersModel5);
		
		int itemavailable=0;
		try{
			// getting cart details
			String extraitems="select quantity from item where i_surkey=?";
			PreparedStatement ps=con.prepareStatement(extraitems);
			ps.setInt(1, viewOffersfree.getI_surkey());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				itemavailable=rs.getInt(1);
			}
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		/**
		 *  non free items are in equal quantity 
		 */
			if((quantity1==quantity2) )
			{
		
					if(quantity2==quantity3){
							viewOffersfree.setPrice(0);
							viewOffersfree.setTotalcost(0);
							viewOffersfree.setDiscount(0);
							viewoffers.add(viewOffersfree);
							updatecart(viewOffersfree.getI_surkey(), quantity3);
							//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(),quantity3);
					}
					
					else
					{

						if(quantity3<quantity2)
						{
							int unavailable=0;
							if(quantity2>itemavailable)
							{
								unavailable=quantity2-itemavailable;
								viewOffersfree.setQuantity(quantity2);
								viewOffersfree.setPrice(0);
								viewOffersfree.setTotalcost(0);
								viewOffersfree.setDiscount(0);
								viewOffersfree.setNotavailable(unavailable);
								viewoffers.add(viewOffersfree);
								updatecart(viewOffersfree.getI_surkey(),itemavailable);
							}
							
							else{
							int diff=quantity2-quantity3;
							int updatedquantity=viewOffersfree.getQuantity()+diff;
							viewOffersfree.setQuantity(updatedquantity);
							viewOffersfree.setPrice(0);
							viewOffersfree.setTotalcost(0);
							viewOffersfree.setDiscount(0);
							viewOffersfree.setNotavailable(unavailable);
							viewoffers.add(viewOffersfree);
							updatecart(viewOffersfree.getI_surkey(), quantity2);
							}
							//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(), updatedquantity-unavailable);
						}
						else
						{
							int diff=quantity3-quantity2;
							ViewOffersModel freeitemwithprice=new ViewOffersModel();
							freeitemwithprice.setItem_Name(viewOffersfree.getItem_Name());
							freeitemwithprice.setPicture(viewOffersfree.getPicture());
							freeitemwithprice.setPrice(viewOffersfree.getPrice());
							freeitemwithprice.setItem_desc(viewOffersfree.getItem_desc());
							freeitemwithprice.setDiscount(viewOffersfree.getDiscount());
							freeitemwithprice.setBrand(viewOffersfree.getBrand());
							freeitemwithprice.setColor(viewOffersfree.getColor());
							freeitemwithprice.setShipping_details(viewOffersfree.getShipping_details());
							freeitemwithprice.setShippingcost(viewOffersfree.getShippingcost());
							freeitemwithprice.setCategory_id(viewOffersfree.getCategory_id());
							freeitemwithprice.setSubcategory_id(viewOffersfree.getSubcategory_id());
							freeitemwithprice.setDeal_eligible(viewOffersfree.getDeal_eligible());
							freeitemwithprice.setDealitems(viewOffersfree.getDealitems());
							freeitemwithprice.setI_surkey(viewOffersfree.getI_surkey());
							viewOffersfree.setQuantity(quantity2);
							viewOffersfree.setPrice(0);
							viewOffersfree.setTotalcost(0);
							viewoffers.add(viewOffersfree);
							//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(),quantity2);
							
							//adding price to the extra free items
							
							int totalcost;
							int priceafterdiscount;
							int discount;
							int shippingcost;
							int price;
							
							
							price=freeitemwithprice.getPrice();
							discount=freeitemwithprice.getDiscount();
							shippingcost=freeitemwithprice.getShippingcost();
							priceafterdiscount=price-(price*discount/100);
							totalcost=(priceafterdiscount+shippingcost)*diff;
							freeitemwithprice.setQuantity(diff);
							freeitemwithprice.setTotalcost(totalcost);
							freeitemwithprice.setPriceafterdiscount(priceafterdiscount);
									
							viewoffers.add(freeitemwithprice);
							updatecart(viewOffersfree.getI_surkey(), quantity3);
						}
					}
			}
			/**
			 * non free items are in unequal quantity
			 */
			
			if(quantity1!=quantity2)
			{
				int min= quantity1 < quantity2 ? quantity1 : quantity2;
					if(quantity3==min){
						
						int unavailable=0;
						if(min>itemavailable)
						{
							unavailable=min-itemavailable;
							viewOffersfree.setPrice(0);
							viewOffersfree.setTotalcost(0);
							viewOffersfree.setQuantity(min);
							viewOffersfree.setNotavailable(unavailable);
							viewoffers.add(viewOffersfree);
							updatecart(viewOffersfree.getI_surkey(), itemavailable);
						}
						else{
							viewOffersfree.setPrice(0);
							viewOffersfree.setTotalcost(0);
							viewOffersfree.setQuantity(min);
							viewoffers.add(viewOffersfree);
							updatecart(viewOffersfree.getI_surkey(), min);
						}
						
						//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(),min);
						}
					
					else
					{
		
						if(quantity3<min)
						{
							int unavailable=0;
							if(min>itemavailable)
							{
								
								unavailable=min-itemavailable;
								viewOffersfree.setQuantity(min);
								viewOffersfree.setPrice(0);
								viewOffersfree.setTotalcost(0);
								viewOffersfree.setDiscount(0);
								viewOffersfree.setShippingcost(0);
								viewOffersfree.setNotavailable(unavailable);
								viewoffers.add(viewOffersfree);
								updatecart(viewOffersfree.getI_surkey(),quantity3);
								System.out.println("quantity check"+unavailable);
							}
							else{
							int diff=min-quantity3;
							int updatedquantity=viewOffersfree.getQuantity()+diff;
							viewOffersfree.setQuantity(updatedquantity);
							viewOffersfree.setPrice(0);
							viewOffersfree.setTotalcost(0);
							viewOffersfree.setDiscount(0);
							viewOffersfree.setShippingcost(0);
							viewOffersfree.setNotavailable(unavailable);
							viewoffers.add(viewOffersfree);
							updatecart(viewOffersfree.getI_surkey(),min);
							}
							//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(),updatedquantity-unavailable);
						}
						else
						{
							int diff=quantity3-min;
							ViewOffersModel freeitemwithprice=new ViewOffersModel();
							
							freeitemwithprice.setItem_Name(viewOffersfree.getItem_Name());
							freeitemwithprice.setPicture(viewOffersfree.getPicture());
							freeitemwithprice.setPrice(viewOffersfree.getPrice());
							freeitemwithprice.setItem_desc(viewOffersfree.getItem_desc());
							freeitemwithprice.setDiscount(viewOffersfree.getDiscount());
							freeitemwithprice.setBrand(viewOffersfree.getBrand());
							freeitemwithprice.setColor(viewOffersfree.getColor());
							freeitemwithprice.setShipping_details(viewOffersfree.getShipping_details());
							freeitemwithprice.setShippingcost(viewOffersfree.getShippingcost());
							freeitemwithprice.setCategory_id(viewOffersfree.getCategory_id());
							freeitemwithprice.setSubcategory_id(viewOffersfree.getSubcategory_id());
							freeitemwithprice.setDeal_eligible(viewOffersfree.getDeal_eligible());
							freeitemwithprice.setDealitems(viewOffersfree.getDealitems());
							freeitemwithprice.setI_surkey(viewOffersfree.getI_surkey());
							viewOffersfree.setQuantity(min);
							viewOffersfree.setPrice(0);
							viewOffersfree.setTotalcost(0);
							viewoffers.add(viewOffersfree);
							//updatefreeattribute(u_surkey, viewOffersfree.getI_surkey(),min);
							//adding price to the extra free items
							
							int totalcost;
							int priceafterdiscount;
							int discount;
							int shippingcost;
							int price;
							
							
							price=freeitemwithprice.getPrice();
							discount=freeitemwithprice.getDiscount();
							shippingcost=freeitemwithprice.getShippingcost();
							priceafterdiscount=price-(price*discount/100);
							totalcost=(priceafterdiscount+shippingcost)*diff;
							freeitemwithprice.setQuantity(diff);
							freeitemwithprice.setPrice(price);
							freeitemwithprice.setTotalcost(totalcost);
							freeitemwithprice.setPriceafterdiscount(priceafterdiscount);		
							viewoffers.add(freeitemwithprice);
							updatecart(viewOffersfree.getI_surkey(),quantity3);
						}
					}
				
			}
			
		
			
			
		
	}
	
	/**
	 * Updating cart table
	 * @param viewOffersModel2
	 */
	private void updatecart(int freeitemid,int quantity){
		CartService cartService=new CartService();
		Map<String, Object> session = ActionContext.getContext().getSession();
		int u_surkey = (Integer) session.get("user_surr_key");
		int cartId = cartService.getCartId(u_surkey, freeitemid);
		if(cartId == 0 && freeitemid!= 0)
		{
			cartService.insertIntoCart(u_surkey,freeitemid,quantity,0,"No",0);
		}
		else 
		{
			
					int qty = cartService.getCartQty(u_surkey, freeitemid);
					System.out.println("In update cart else "+ qty +"quantity"+quantity);
					if(cartService.Updateqty(cartId, quantity, freeitemid))
					{
						System.out.println("In update cart else if"+qty +"quantity"+quantity);
					}
					
				
		}
	}

	private void computeNoDeal(ViewOffersModel viewOffersModel2) {
		
		CartService cartService=new CartService();
		Map<String, Object> session = ActionContext.getContext().getSession();
		int u_surkey = (Integer) session.get("user_surr_key");
		int totalcost;
		int priceafterdiscount;
		int discount;
		int shippingcost;
		int price;
		int quantity;
		quantity=viewOffersModel2.getQuantity();
		price=viewOffersModel2.getPrice();
		discount=viewOffersModel2.getDiscount();
		shippingcost=viewOffersModel2.getShippingcost();
		priceafterdiscount=price-(price*discount/100);
		if(quantity>0)
		{
		totalcost=(priceafterdiscount)*quantity+shippingcost;
		viewOffersModel2.setTotalcost(totalcost);
		}
		viewOffersModel2.setPriceafterdiscount(priceafterdiscount);
		viewoffers.add(viewOffersModel2);
//		//updatefreeattribute(u_surkey, viewOffersModel2.getI_surkey(),0);
		
		
	}
	
	
	public void freeQtyUpdate(ArrayList<ViewOffersModel> model)
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		int userId = (Integer) session.get("user_surr_key");
		
		for(ViewOffersModel v : model)
		{
//			updatefreeattribute(userId, v.getI_surkey(), 0);
			int freeavailable = 0;
			
			if(v.getPrice() == 0)
			{
				freeavailable = v.getQuantity() - v.getNotavailable();
				updatefreeattribute(userId, v.getI_surkey(), freeavailable);
			}
		}
	}
	
	private void updatefreeattribute(int u_surkey, int i_surkey, int freeqty){
		try{
			String updatefreequantity="update cart set freequantity = ? where u_surkey =? and i_surkey = ?";
			
			PreparedStatement ps=con.prepareStatement(updatefreequantity);
			ps.setInt(1, freeqty);
			ps.setInt(2, u_surkey);
			ps.setInt(3, i_surkey);
			ps.executeUpdate();	
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}