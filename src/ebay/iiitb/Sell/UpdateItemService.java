//tables : seller , item , itemspecattributes
//seller : s_surkey , u_surkey
//item : i_surkey, item_name, price, item_desc,  discount, quantity, num_of_items_sold, warranty, advt_status, color, `condition`, weight, brand, expiry_date, duration, paymentmode, shippingdetails, handlingtime, shippingcost, c_surkey, sc_surkey, type, serviced_in_india, model, size, material,
//item : from_date, to_date, cost, adt_surkey, deal_eligible, picture , item_name , s_surkey
//itemspecattributes : attribute, value, i_surkey
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;

import java.lang.reflect.Field;


import ebay.iiitb.DBUtil.DbConnection;

public class UpdateItemService{

	
	SellItemModel itemModel;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public UpdateItemService(SellItemModel itemModel)
	{
		this.itemModel = itemModel;
	}
	
	
	public Map<String,String> UpdateItemDetails(int usr) throws Exception
	{
		System.out.println(usr+"============================================");	
		int cat,sub,seller;
		Map<String,String> specs = new LinkedHashMap<String, String>();
		cat=0;
		sub=0;
		seller=0;
		System.out.println("============================"+itemModel.getAdvt_status());
		String getsellerid = "select s_surkey from seller where u_surkey = "+ usr;
		PreparedStatement psseller=con.prepareStatement(getsellerid);
		ResultSet rs3=psseller.executeQuery();
		while(rs3.next()){
			seller=rs3.getInt(1);
		}
		String getitemdetails = "select i_surkey, item_name, price, item_desc,  discount, quantity, num_of_items_sold, warranty, advt_status, color, `condition`, weight, brand, expiry_date, duration, paymentmode, shippingdetails, handlingtime, shippingcost, c_surkey, sc_surkey, type, serviced_in_india, model, size, material, from_date, to_date, cost, adt_surkey, deal_eligible, picture from item where item_name = \'"+itemModel.getItem_Name()+"\' and s_surkey = "+seller ;
		try
		{	
			
			PreparedStatement ps=con.prepareStatement(getitemdetails);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("========query===================="+getitemdetails);
			System.out.println("=====rs======================="+rs.getFetchSize());
			while(rs.next()){
				itemModel.setI_surkey(rs.getString(1));
				itemModel.setItem_Name(rs.getString(2));
				itemModel.setPrice(rs.getString(3));
				itemModel.setItem_desc(rs.getString(4));
				itemModel.setDiscount(rs.getInt(5));
				itemModel.setQuantity(rs.getInt(6));
				itemModel.setSold(rs.getString(7));
				itemModel.setWarranty(rs.getString(8));
				itemModel.setAdvt_status(rs.getString(9));
				itemModel.setColor(rs.getString(10));
				itemModel.setCondition(rs.getString(11));
				itemModel.setWeight(rs.getString(12));
				itemModel.setBrand(rs.getString(13));
				itemModel.setExpiry_date(rs.getString(14));
				itemModel.setDuration(rs.getString(15));
				itemModel.setPaymentmode(rs.getString(16));
				itemModel.setShippingdetails(rs.getString(17));
				itemModel.setHandlingtime(rs.getString(18));
				itemModel.setShippingcost(rs.getInt(19));
				itemModel.setCategoryId(rs.getInt(20));
				itemModel.setSubCategoryId(rs.getInt(21));
				itemModel.setType(rs.getString(22));
				itemModel.setServiced_in_india(rs.getString(23));
				//adt_surkey
				
				itemModel.setModel(rs.getString(24));
				itemModel.setSize(rs.getString(25));
				itemModel.setMaterial(rs.getString(26));
				if((rs.getString(27) != "") && (rs.getString(27) != null)){
					SimpleDateFormat from2 = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat from1 = new SimpleDateFormat("yyyy-MM-dd");
					
					Date fromdate = from1.parse(rs.getString(27));      
					String from_date = from2.format(fromdate);  
					
					Date todate = from1.parse(rs.getString(28));  
					String to_date = from2.format(todate);
					itemModel.setFrom_date(from_date);
					itemModel.setTo_date(to_date);
				}
				
				//29cost- not to be stored in item model
				itemModel.setAdvt_cost(rs.getInt(29));
				itemModel.setAdt_surkey(rs.getInt(30));
				itemModel.setDeal_eligible(rs.getString(31));
				itemModel.setPicture(rs.getString(32));
				cat=rs.getInt(20);
				sub=rs.getInt(21);
				break;
			}
			System.out.println("============================"+itemModel.getServiced_in_india());
			System.out.println("============================"+itemModel.getModel());
			System.out.println("============================"+itemModel.getSize());
			System.out.println("============================"+itemModel.getMaterial());
			System.out.println("============================"+itemModel.getFrom_date());
			System.out.println("============================"+itemModel.getTo_date());
			String getspecs = "select attribute, value, i_surkey from itemspecattributes where i_surkey ="+itemModel.getI_surkey();
			PreparedStatement psspecs=con.prepareStatement(getspecs);
			ResultSet rsspecs = psspecs.executeQuery();
			while(rsspecs.next()){
				specs.put(rsspecs.getString(1),rsspecs.getString(2));
			}
			System.out.println("==========Specs=================="+specs);
		}catch (SQLException e) {			
			e.printStackTrace();			
		}
	 		return specs;
		}
}
