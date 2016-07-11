//tables : category , item
//category : id , name
//item : sc_surkey , quantity , brand
package ebay.iiitb.PopulateItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;

public class PopulateSubCategoriesService {
	ArrayList<ItemModel> items = new ArrayList<ItemModel>();
	
	public ArrayList<ItemModel> getAllItems(String category_Name) {
		// TODO Auto-generated method stub
		int subCategoryID = 0;
		int categoryID=0;
		
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		String getSubCategoryID = "select id from category where name = ? ";
		String getSubCategoryItems = "select * from item where sc_surkey = ? and quantity > ?";	
		
		try{
			PreparedStatement ps1=con.prepareStatement(getSubCategoryID);
			PreparedStatement ps2=con.prepareStatement(getSubCategoryItems);
			
			ps1.setString(1, category_Name.trim());
			
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				subCategoryID = rs1.getInt(1);
				System.out.println(subCategoryID);
				System.out.println("print cat id  "+categoryID);
			}
			ps2.setInt(1,subCategoryID);
			ps2.setString(2,"0");
			try{
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next()){
					ItemModel it = new ItemModel();
					it.setI_surkey(rs2.getInt(1));
					it.setItem_Name(rs2.getString(2));
					it.setPicture(rs2.getString(3));
					it.setPrice(rs2.getInt(4));
					it.setSubcategory_id(rs2.getInt(24));
					it.setDiscount(rs2.getString(7));
					it.setQuantity(rs2.getString(8));
					
					System.out.println(it.getItem_Name());
					items.add(it);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}	
		return items;
	}
	
	public ArrayList<String> getBrands(String subcategory_Name)
	{
		int subCategoryID = 0;
		int categoryID=0;
		ArrayList<String> brands=new ArrayList<String>();
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		String getSubCategoryID = "select id from category where name = ? ";	
		String getBrands ="select brand from item where sc_surkey=? and quantity >?";
		try{
			PreparedStatement ps1=con.prepareStatement(getSubCategoryID);
			
			PreparedStatement ps3=con.prepareStatement(getBrands);
			System.out.println(subcategory_Name);
			ps1.setString(1, subcategory_Name.trim());
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				subCategoryID = rs1.getInt(1);
				
				System.out.println("print cat id  "+categoryID);
			}
			ps3.setInt(1,subCategoryID);
			ps3.setInt(2, 0);
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next())
			{
				if(!(brands.contains(rs3.getString(1))))
					brands.add(rs3.getString(1));
			}
			System.out.println("In Servive");
			for(int i=0;i<brands.size();i++)
			{
				System.out.println(brands.get(i));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}	
	return brands;
		
	}
	public String getSubCatId(String category_Name ) {
		// TODO Auto-generated method stub
		Integer subCategoryID = 0;
		int categoryID=0;
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		String getSubCategoryID = "select id from category where name = ? ";
		try{
			PreparedStatement ps1=con.prepareStatement(getSubCategoryID);
			ps1.setString(1, category_Name.trim());
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				subCategoryID = rs1.getInt(1);
				System.out.println(subCategoryID);
				System.out.println("print cat id  "+categoryID);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			
		}	
		return subCategoryID.toString();
	}

}
