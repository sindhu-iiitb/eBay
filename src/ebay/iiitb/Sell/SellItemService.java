//tables : category , cat_sub_spec
//category :name , id
//cat_sub_spec : cat_id , sub_cat_id
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ebay.iiitb.DBUtil.DbConnection;

public class SellItemService {
	
	SellItemModel itemModel;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	
	public SellItemService(SellItemModel itemModel)
	{
		this.itemModel = itemModel;
	}
	
	
	public List<String> addItemDetails(String category, String subCategory)
	{
		int seller_surr_key = 0;
		
		String getCategoryId = "select id from category where name =\'"+category+"\'";
		String getsubCategoryId = "select id from category where name =\'"+subCategory+"\'";
		List<String> specs = new ArrayList<String>();
	 try
		{		
			PreparedStatement ps1=con.prepareStatement(getCategoryId);
			PreparedStatement ps2=con.prepareStatement(getsubCategoryId);
			ResultSet rs1=ps1.executeQuery();
			ResultSet rs2=ps2.executeQuery();
			while (rs1.next()) {
				itemModel.setCategoryId(rs1.getInt(1));
				System.out.println(":::::::::"+rs1.getInt(1));
				
				}
			while (rs2.next()) {
				itemModel.setSubCategoryId(rs2.getInt(1));
				}
			String getSpec = "select * from cat_sub_spec where cat_id =\'"+itemModel.getCategoryId()+"\' AND " +
				"sub_cat_id=\'"+itemModel.getSubCategoryId()+"\'";
			PreparedStatement ps3=con.prepareStatement(getSpec);
			ResultSet rs3=ps3.executeQuery();
			System.out.println(getSpec);
			while (rs3.next()) {
				
				specs = Arrays.asList(rs3.getString(3).split(","));
				break;
				}
			System.out.println(specs);
		}catch (SQLException e) {			
			e.printStackTrace();
					
		}
	 return specs;
	}
}
