//tables : category , item
//category : name , id
//item : sc_surkey , advt_status , quantity
package ebay.iiitb.PopulateItems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import ebay.iiitb.DBUtil.*;

public class SubCategoryService {
	ArrayList<ItemModel> path = new ArrayList<ItemModel>();
	ArrayList<ItemModel> advtitems = new ArrayList<ItemModel>();//Advt_items
	ArrayList<ItemModel> subCategoryItems = new ArrayList<ItemModel>();
	ArrayList<String> brands = new ArrayList<String>();
	
	
	ArrayList<ArrayList<ItemModel>>  nestedsubcategory= new ArrayList<ArrayList<ItemModel>>();
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	
	public ArrayList<String> getBrands(){
		return brands;
	}
	
	
	public ArrayList<ArrayList<ItemModel>> DisplaySubCategories(String subCategory)
	{	
		int subCategoryID = 0;
		int categoryID=0;
		String getSubCategoryID = "select * from category where name = ? ";
		String getSubCategoryItems = "select * from item where sc_surkey = ?";	
		String getCategoryName="select * from category where id=?";
		String categoryName=null;
		
		try
		{
			System.out.println("sub cat is "+ subCategory +nestedsubcategory.size());
			PreparedStatement ps1=con.prepareStatement(getSubCategoryID);
			PreparedStatement ps2=con.prepareStatement(getSubCategoryItems);
			PreparedStatement ps3=con.prepareStatement(getCategoryName);
			ps1.setString(1, subCategory.trim());
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				subCategoryID = rs1.getInt(1);
				categoryID=rs1.getInt(3);
				System.out.println(subCategoryID);
				System.out.println("print cat id  "+categoryID);
			}
			ps3.setInt(1,categoryID);
			//System.out.println("ps3 is  "+ps3);
			ResultSet rs3=ps3.executeQuery();
			while(rs3.next()){
			categoryName=rs3.getString(2);
			System.out.println("now the cat name is  "+categoryName);}
			
			ps2.setInt(1, subCategoryID);
			ResultSet rs2=ps2.executeQuery();
			if(!rs2.next())
			{
				System.out.println("inside null rs2");
				ItemModel i = new ItemModel();
				i.setCategory_id(categoryID);//added
				i.setSubcategory_id(subCategoryID);//added to print path
				System.out.println("here   "+categoryName);
				System.out.println(" here  " + subCategory);
				
				path.add(i);
				nestedsubcategory.add(path);
				System.out.println("added");
				return nestedsubcategory;
				//System.out.println("added");
				
			}
				rs2.close();
			ResultSet	rs4=ps2.executeQuery();
			while (rs4.next()) {
				System.out.println("not empty");
				ItemModel i = new ItemModel();
				ItemModel j = new ItemModel();
				i.setI_surkey(rs4.getInt(1));
				i.setSeller_id(rs4.getString(6));
				i.setItem_Name(rs4.getString(2));
				i.setPrice(rs4.getInt(4));
				i.setPicture(rs4.getString(3));
				j.setCategory_id(categoryID);
				j.setSubcategory_id(subCategoryID);//added to print path
				System.out.println(i.getI_surkey());
				System.out.println(i.getItem_Name());
				
				//brands
				String brand1=rs4.getString(16);
				if(!brands.contains(brand1))
				brands.add(brand1);
				
				path.add(j);
				subCategoryItems.add(i);	
				
				if(rs4.getString(11).equals("yes"))
				{
					System.out.println("------advt-----------"+rs4.getString(2));
					advtitems.add(i);
					//System.out.println(i.getSeller_id());
					
					//System.out.println(advtitems.size());
					
				}
				
			}
			nestedsubcategory.add(path);
			nestedsubcategory.add(subCategoryItems);
			nestedsubcategory.add(advtitems);
			//nestedsubcategory.add(advtitems);
			//System.out.println(advtitems.get(0));
			//System.out.println(nestedsubcategory.get(1).get(0).getSeller_id());
//			System.out.println(nestedsubcategory.get(2).get(0).getSeller_id());
			
			System.out.println("Hi");
			System.out.println(brands.get(0));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}		
		return nestedsubcategory;
	}


	public ArrayList<ItemModel> DisplayAdvt() {
		int subCategoryID = 0;
		int categoryID=0;
		String adtitems="select * from item where advt_status=? and quantity >0";
		ArrayList<ItemModel> advtitem=new ArrayList<ItemModel>();
		
		try
		{
			
			PreparedStatement ps1=con.prepareStatement(adtitems);
		
			ps1.setString(1,"yes");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				ItemModel item=new ItemModel();
				System.out.println(rs1.getInt(4));
				item.setI_surkey(rs1.getInt(1));
				item.setPicture(rs1.getString(3));
				item.setItem_Name(rs1.getString(2));
				item.setPrice(rs1.getInt(4));
				item.setBrand(rs1.getString(16));
				advtitem.add(item);
				
			}
		
			
		}catch (SQLException e) {
			e.printStackTrace();
			
		}		
		return advtitem;
	}
}
	
	
