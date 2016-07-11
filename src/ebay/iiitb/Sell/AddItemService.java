//tables : category , seller , item , advt_detail_table , cat_sub_spec , itemspecattributes
//category : name , id
//seller : s_surkey , u_surkey
//item : i_surkey , item_name, picture, price, item_desc, s_surkey, discount, quantity, num_of_items_sold, warranty, advt_status, color, `condition`, weight, brand, expiry_date, duration, paymentmode, shippingdetails, handlingtime, shippingcost, c_surkey, sc_surkey, type, serviced_in_india, model, size, material, deal_eligible, deal_added, from_date, to_date, cost, adt_surkey
//advt_detail_table : adt_surkey , cost
//cat_sub_spec : cat_id , sub_cat_id
//itemspecattributes : attribute, value, i_surkey
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import java.lang.reflect.Field;


import ebay.iiitb.DBUtil.DbConnection;

public class AddItemService{

	
	SellItemModel itemModel;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public AddItemService(SellItemModel itemModel)
	{
		this.itemModel = itemModel;
	}
	
	
	public boolean AddItemDetails(int usr) throws Exception
	{
		System.out.println(usr+"============================================");	
		int cat,sub,seller;
		cat=0;
		sub=0;
		seller=0;
		System.out.println("============================"+itemModel.getAdvt_status());
		String getcategoryid = "select id from category where name = \'" + itemModel.getCategory_Name() + "\'";
		String getsubcategoryid = "select id from category where name = \'" + itemModel.getSubCategory_Name() + "\'";
		String getsellerid = "select s_surkey from seller where u_surkey = "+ usr;
		String insertitemdetails = "insert into item(item_name, picture, price, item_desc, s_surkey, discount, quantity, num_of_items_sold, warranty, advt_status, color, `condition`, weight, brand, expiry_date, duration, paymentmode, shippingdetails, handlingtime, shippingcost, c_surkey, sc_surkey, type, serviced_in_india, model, size, material, deal_eligible, deal_added) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		if(itemModel.getAdvt_status().equals("Yes")){
			insertitemdetails = "insert into item(item_name, picture, price, item_desc, s_surkey, discount, quantity, num_of_items_sold, warranty, advt_status, color, `condition`, weight, brand, expiry_date, duration, paymentmode, shippingdetails, handlingtime, shippingcost, c_surkey, sc_surkey, type, serviced_in_india, model, size, material, deal_eligible, deal_added, from_date, to_date, cost, adt_surkey) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println(insertitemdetails);
		}
		try
		{	
		    PreparedStatement pscat=con.prepareStatement(getcategoryid);
		    PreparedStatement pssub=con.prepareStatement(getsubcategoryid);
			PreparedStatement psseller=con.prepareStatement(getsellerid);
			ResultSet rs1=pscat.executeQuery();
			ResultSet rs2=pssub.executeQuery();
			ResultSet rs3=psseller.executeQuery();
			while(rs1.next()){
				cat=rs1.getInt(1);
			}
			while(rs2.next()){
				sub=rs2.getInt(1);
			}
			while(rs3.next()){
				seller=rs3.getInt(1);
			}
			PreparedStatement ps=con.prepareStatement(insertitemdetails);
			ps.setString(1, itemModel.getItem_Name());
			ps.setString(2, "Images/"+itemModel.getPicture());
			ps.setString(3, itemModel.getPrice());
			ps.setString(4, itemModel.getItem_desc());
			ps.setInt(5,seller);
			ps.setInt(6, itemModel.getDiscount());
			ps.setInt(7, itemModel.getQuantity());
			ps.setString(8, "0");
			ps.setString(9, itemModel.getWarranty());
			ps.setString(10, itemModel.getAdvt_status());
			ps.setString(11, itemModel.getColor());
			ps.setString(12, itemModel.getCondition());
			ps.setString(13, itemModel.getWeight());
			ps.setString(14, itemModel.getBrand());
			ps.setString(15, itemModel.getExpiry_date().substring(0,10));
			ps.setString(16, itemModel.getDuration());
			ps.setString(17, itemModel.getPaymentmode());		
			ps.setString(18, itemModel.getShippingdetails());
			ps.setString(19, itemModel.getHandlingtime());
			ps.setInt(20, itemModel.getShippingcost());
			ps.setInt(21, cat);
			ps.setInt(22, sub);
			ps.setString(23, itemModel.getType());
			ps.setString(24, itemModel.getServiced_in_india());
			ps.setString(25, itemModel.getModel());
			ps.setString(26, itemModel.getSize());
			ps.setString(27, itemModel.getMaterial());
			ps.setString(28, itemModel.getDeal_eligible());
			ps.setString(29, "No");
			
			if(itemModel.getAdvt_status().equals("Yes")){
				
				SimpleDateFormat from2 = new SimpleDateFormat("yyyy-MM-dd");
				
				Date fromdate = from2.parse(itemModel.getFrom_date().substring(0,10));      
				String from_date = itemModel.getFrom_date().substring(0,10);  
				
				Date todate = from2.parse(itemModel.getTo_date().substring(0,10));  
				String to_date = itemModel.getTo_date().substring(0,10); 
				
				long diff = Math.abs(fromdate.getTime() - todate.getTime());
				int diffDays = (int)diff / (24 * 60 * 60 * 1000);
				
				int cost=0;
				String getperdaycost = "select cost from advt_detail_table where adt_surkey ="+itemModel.getAdt_surkey();
				PreparedStatement pscost=con.prepareStatement(getperdaycost);
				ResultSet rscost=pscost.executeQuery();
				while (rscost.next()) {
					cost= rscost.getInt(1)*diffDays;
					break;
				}
				
				ps.setString(30, from_date);
				ps.setString(31, to_date);
				ps.setInt(32, cost);
				ps.setInt(33, itemModel.getAdt_surkey());
			}
			System.out.println("==============="+ps+"===============");			
			if(ps.executeUpdate()>0)
			{
				int ikey=0;
				String getitemkey = "select i_surkey from item where item_name = \'"+itemModel.getItem_Name()+"\' and s_surkey = "+seller;
				PreparedStatement ps1=con.prepareStatement(getitemkey);
				ResultSet rs4=ps1.executeQuery();
				while (rs4.next()) {
					ikey= rs4.getInt(1);
					break;
				}
				String updateitemid = "update item set itemid = \'"+itemModel.getItem_Name()+"_"+ikey+"\' where item_name = \'"+itemModel.getItem_Name()+"\' and s_surkey = "+seller;
				PreparedStatement psid=con.prepareStatement(updateitemid);
				if(psid.executeUpdate()>0)
				{
					System.out.println("item id updated");
				}
				
				List<String> specs = new ArrayList<String>();
				System.out.println("Successfull item add");
				String getSpec = "select * from cat_sub_spec where cat_id =\'"+cat+"\' AND " +
						"sub_cat_id=\'"+sub+"\'";
				PreparedStatement ps2=con.prepareStatement(getSpec);
				ResultSet rs5=ps2.executeQuery();
				while (rs5.next()) {
					
					specs = Arrays.asList(rs5.getString(3).split(","));
					break;
				}
				int itemid=0;
				String getitemid = "select i_surkey from item where item_name = \'"+itemModel.getItem_Name()+"\' and s_surkey= " + seller;
				PreparedStatement psi=con.prepareStatement(getitemid);
				ResultSet rsi=psi.executeQuery();
				while (rsi.next()) {
					itemid = rsi.getInt(1);
					break;
				}
				if(specs.size()>0){
					String insertspecs = "insert into itemspecattributes(attribute, value, i_surkey) values(\'";
					for (int i = 0; i < specs.size(); i++) {
						
						insertspecs += specs.get(i) + "\', \'";
						Field field = SellItemModel.class.getField("att"+i);
						insertspecs += field.get(itemModel) + "\',";
						insertspecs += itemid+"),(\'";
					}
					insertspecs = insertspecs.substring(0, insertspecs.length()-3);
					System.out.println(insertspecs);
					PreparedStatement ps3=con.prepareStatement(insertspecs);
					if(ps3.executeUpdate()>0){
						System.out.println("specs entered");
						
						return true;
					}
				}
				return true;
				
			}
		}catch (SQLException e) {			
			e.printStackTrace();			
		}
	 		return false;
		}
}
