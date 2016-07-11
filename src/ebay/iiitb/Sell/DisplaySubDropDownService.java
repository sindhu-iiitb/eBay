//tables : category
//category : name , parent ,id
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ebay.iiitb.DBUtil.DbConnection;

public class DisplaySubDropDownService {
	ArrayList<String> sub = new ArrayList<String>();
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	public ArrayList<String> displaySubDropDown(String categoryName){
		String getCategoryid = "select id from category where name = ? ";
		String getSubcategories="select * from category where parent = ?";
		int id=0;
		
		String key=null;
		try
		{
			PreparedStatement ps=con.prepareStatement(getCategoryid);
			//ps.setString(0, "");
			ps.setString(1, categoryName);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				id=rs.getInt(1);
//				System.out.println("category Added");
			}
			ps=con.prepareStatement(getSubcategories);
			ps.setInt(1, id);
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				 System.out.println(rs.getString(2));
				 sub.add(rs.getString(2));
			 }
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return sub;
		
	}
}
