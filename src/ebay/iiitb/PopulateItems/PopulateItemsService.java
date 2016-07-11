//tables : item , category
//item : sc_surkey 
//category : name
package ebay.iiitb.PopulateItems;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;



public class PopulateItemsService {
 
	String subcategory_Name=null;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public PopulateItemsService(String subcategory_Name) {
		
		this.subcategory_Name = subcategory_Name;
		System.out.println(" In const" + subcategory_Name);
	}
	
	
	public PopulateItemsModel getPopulateItemsModel()
	{
		int subcat_id = 0;
		PopulateItemsModel populateItemsModel = new PopulateItemsModel();
		ArrayList<String> itemList = new ArrayList<String>();
		String getList = "select * from item where sc_surkey = ?";
		String getsubCategoryId = "select * from category where name = ?";
		try
		{
			PreparedStatement ps1=con.prepareStatement(getsubCategoryId);
			PreparedStatement ps2=con.prepareStatement(getList);
			ps1.setString(1, subcategory_Name);
			System.out.println(subcategory_Name);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				subcat_id = rs1.getInt(1);
				System.out.println("subCategory id " + subcat_id);
			}
			    ps2.setInt(1, subcat_id);
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next())
				{
					System.out.println(rs2.getString(2));
					itemList.add(rs2.getString(2));
				}		
			    populateItemsModel.setItemList(itemList);
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return populateItemsModel;	
		
	}
	
	






	

}
