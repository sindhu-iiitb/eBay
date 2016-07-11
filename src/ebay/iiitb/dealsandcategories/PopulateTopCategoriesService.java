//tables : category 
//category : parent , name
package ebay.iiitb.dealsandcategories;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;



public class PopulateTopCategoriesService {
 
	String category_Name;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public PopulateTopCategoriesService(String category_Name) {
		
		this.category_Name = category_Name;
		System.out.println(" In const" + category_Name);
	}
	
	public PopulateTopCategoriesModel getSubCategories()
	{
		int cat_id = 0;
		PopulateTopCategoriesModel populateDealsModel = new PopulateTopCategoriesModel();
		ArrayList<String> subCatList = new ArrayList<String>();
		String getsubCategories = "select * from category where parent = ?";
		String getCategoryId = "select * from category where name = ?";
		try
		{
			PreparedStatement ps1=con.prepareStatement(getCategoryId);
			PreparedStatement ps2=con.prepareStatement(getsubCategories);
			ps1.setString(1, category_Name.trim());
			System.out.println(category_Name);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()) {
				cat_id = rs1.getInt(1);
				System.out.println("Category id " + cat_id);
			}
			    ps2.setInt(1, cat_id);
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next())
				{
					System.out.println(rs2.getString(2));
					subCatList.add(rs2.getString(2));
				}		
			    populateDealsModel.setSubCatlist(subCatList);
		
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return populateDealsModel;	
		
	}
	
	






	

}
