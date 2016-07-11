//tables : category
//category : class, parent
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import ebay.iiitb.DBUtil.DbConnection;

public class DisplayCategoriesService {
	
	//ArrayList<ArrayList<CategoryModel>> categories = new ArrayList<ArrayList<CategoryModel>>();
	Map<String,ArrayList<CategoryModel>> categories = new LinkedHashMap<String,ArrayList<CategoryModel>>();
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	public Map<String,ArrayList<CategoryModel>> displayCategories() {
		String getCategories = "select * from category ORDER BY class, parent";
		System.out.println(getCategories);
		String key=null;
		try
		{
			PreparedStatement ps=con.prepareStatement(getCategories);
			//ps.setString(0, "");
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				CategoryModel c = new CategoryModel();
				c.setCategory_Id(rs.getString(1));
				c.setCategory_Name(rs.getString(2));
				c.setCategory_Parent(rs.getString(3));
				c.setCategory_Group(rs.getString(4));
				System.out.println("category Parent:"+c.getCategory_Parent());
				if(c.getCategory_Parent().equals("0")){
					categories.put(c.getCategory_Name(),new ArrayList<CategoryModel>());
					key = c.getCategory_Name();	
				}
				else{
					categories.get(key).add(c);
				}
				
				System.out.println("category Added");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return categories;
	}

}
