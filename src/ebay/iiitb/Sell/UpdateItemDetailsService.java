//tables : seller , item , advt_detail_table , cat_sub_spec , itemspecattributes
//seller : s_surkey , u_surkey
//item : item_name , price ,item_desc , s_surkey , discount , warranty , quantity , advt_status , color , brand
//item : condition , weight ,duration,paymentmode , shippingcost , shippingdetails , handlingtime , type ,  model , size , material , itemid
//item : from_date , to_date , cost , adt_surkey , picture , i_surkey , c_surkey , sc_surkey
//advt_detail_table : cost , adt_surkey
//cat_sub_spec : cat_id , sub_cat_id
//itemspecattributes : value , attribute , i_surkey
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

public class UpdateItemDetailsService {
	SellItemModel itemModel;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public UpdateItemDetailsService(SellItemModel itemModel)
	{
		this.itemModel = itemModel;
	}
	
	
	public boolean UpdateItemDetails(int usr) throws Exception
	{
		System.out.println(usr+"============================================");	
		int cat,sub,seller;
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
		String insertitemdetails = "update item set item_name = \'" + itemModel.getItem_Name()+"\' , price = "+itemModel.getPrice();
		insertitemdetails += ", item_desc =\'"+itemModel.getItem_desc()+"\' , s_surkey ="+seller+", discount ="+itemModel.getDiscount();
		insertitemdetails += ", quantity="+itemModel.getQuantity()+" , warranty =\'"+itemModel.getWarranty()+"\'";
		insertitemdetails += ", advt_status=\'"+itemModel.getAdvt_status()+"\' ,color = \'"+itemModel.getColor()+"\' ,brand=\'"+itemModel.getBrand()+"\'";
		insertitemdetails += ", `condition` =\'"+itemModel.getCondition()+"\' ,weight ="+itemModel.getWeight();
		insertitemdetails += ", duration=\'"+itemModel.getDuration()+"\' ,paymentmode=\'"+itemModel.getPaymentmode()+"\' ,shippingcost="+itemModel.getShippingcost();
		insertitemdetails += ", shippingdetails=\'"+itemModel.getShippingdetails().trim()+"\' ,handlingtime="+itemModel.getHandlingtime()+" ,type=\'"+itemModel.getType()+"\'";
		insertitemdetails += ", model=\'"+itemModel.getModel()+"\' ,size="+itemModel.getSize()+" ,material=\'"+itemModel.getMaterial()+"\'";
		insertitemdetails += ", itemid = \'"+itemModel.getItem_Name()+"_"+itemModel.getI_surkey()+"\'";
//		insertitemdetails += ", deal_eligible=\'"+itemModel.getDeal_eligible()+"\'";
		
		
		if(itemModel.getExpiry_date() != null){
			insertitemdetails +=" ,expiry_date=\'"+itemModel.getExpiry_date().substring(0,10)+"\'";
		}
		if(itemModel.getAdvt_status().equals("Yes")){
			
			SimpleDateFormat from2 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date fromdate = from2.parse(itemModel.getFrom_date().substring(0,10));      
			String from_date = itemModel.getFrom_date().substring(0,10);  
			
			Date todate = from2.parse(itemModel.getTo_date());  
			String to_date = itemModel.getTo_date().substring(0,10); 
			
			long diff = Math.abs(fromdate.getTime() - todate.getTime());
			int diffDays = (int)(diff / (24 * 60 * 60 * 1000));
			
			
			int cost=0;
			String getperdaycost = "select cost from advt_detail_table where adt_surkey ="+itemModel.getAdt_surkey();
			PreparedStatement pscost=con.prepareStatement(getperdaycost);
			ResultSet rscost=pscost.executeQuery();
			while (rscost.next()) {
				cost= rscost.getInt(1)*diffDays;
				break;
			}
			insertitemdetails += ", from_date=\'"+from_date+"\' ,to_date=\'"+to_date+"\' ,cost="+cost+" ,adt_surkey="+itemModel.getAdt_surkey(); 
			System.out.println(insertitemdetails);
		}
		else{
		    
			insertitemdetails += ", from_date=NULL,to_date=NULL,cost=0,adt_surkey=NULL"; 
		}
		if(itemModel.getPicture() != null){
			insertitemdetails += ", picture = \'Images/"+itemModel.getPicture()+"\'"; 
			System.out.println(insertitemdetails);
		}
		insertitemdetails += " where i_surkey="+itemModel.getI_surkey();
		System.out.println("Query is : "+insertitemdetails);
		//added
		String getcatsub = "select c_surkey , sc_surkey from item where i_surkey="+itemModel.getI_surkey();
		PreparedStatement pscatsub = con.prepareStatement(getcatsub);
		ResultSet rscatsub = pscatsub.executeQuery();
		while(rscatsub.next())
		{
			cat = rscatsub.getInt(1);
			sub = rscatsub.getInt(2);
		}
		System.out.println(cat + "================== " + sub);
		
		//added
		
		try
		{	
			PreparedStatement ps=con.prepareStatement(insertitemdetails);
			if(ps.executeUpdate()>0)
			{
				int ikey=Integer.parseInt(itemModel.getI_surkey());
				
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
				if(specs.size()>0){
					String updatespecs;
					for (int i = 0; i < specs.size(); i++) {
						Field field = SellItemModel.class.getField("att"+i);
						updatespecs = "update itemspecattributes set value = \'"+field.get(itemModel) + "\' where attribute=\'"+specs.get(i)+"\'";
						updatespecs += "and i_surkey="+ikey;
						System.out.println(updatespecs);
						PreparedStatement ps3=con.prepareStatement(updatespecs);
						if(ps3.executeUpdate()>0){
							System.out.println("specs entered");
							
							return true;
						}
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