//tables : category
//category : name , parent , class , id

package ebay.iiitb.admin;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import ebay.iiitb.DBUtil.*;

public class AddNewCategoryService {
	AddNewCategoryModel addNewCategoryModel;
	boolean status=false;
	public AddNewCategoryService(AddNewCategoryModel addNewCategoryModel)
	{
		this.addNewCategoryModel = addNewCategoryModel;
	}
	
	public boolean addCategory() {
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		
		String addnewCategory="insert into category (name,parent) values(?,?)";
		String fetchCategoryId = "select * from category where name = ?";
		String addnewsubcategory ="insert into category (name,parent,class) values(?,?,?)";
		String deletenewCategory = "delete from category where id = ?";
		String updateCategoryId = "update category set class = ? where id = ?";
		try {
			int parent = 0;
			PreparedStatement ps1=con.prepareStatement(addnewCategory);
			PreparedStatement ps2=con.prepareStatement(fetchCategoryId);
			PreparedStatement ps3=con.prepareStatement(addnewsubcategory);
			PreparedStatement ps4=con.prepareStatement(updateCategoryId);
			ps1.setString(1, addNewCategoryModel.getCategory());
			ps1.setInt(2, parent);	
			if(ps1.executeUpdate()>0){
				ps2.setString(1, addNewCategoryModel.getCategory());
				ResultSet rs1 = ps2.executeQuery();
				while(rs1.next())
				{
					ps4.setInt(1, rs1.getInt(1));
					ps4.setInt(2, rs1.getInt(1));
					if(ps4.executeUpdate()>0)
					{
						ps3.setString(1, addNewCategoryModel.getSubcategory());
						ps3.setInt(2, rs1.getInt(1));
						ps3.setInt(3, rs1.getInt(1));
						if(!addNewCategoryModel.getSubcategory().isEmpty())
						{
							if(ps3.executeUpdate() > 0)
							{
								status=true;				
							}
							else 
							{
								status = false;
							}
						}
						else
						{
							status = true;
						}
					}
					else
					{
						status = false;
					}
				}	
			}
			else
				status = false;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return status;
	}
	
}
