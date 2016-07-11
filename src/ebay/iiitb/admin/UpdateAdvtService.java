//tables : item 
// item : advt_status , i_surkey 

package ebay.iiitb.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import ebay.iiitb.DBUtil.*;
public class UpdateAdvtService {
	
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	
	public void update(String item_Id) throws SQLException
	{
		System.out.println("in service of updateadvt" + item_Id);
		String updatequery="update  item set advt_status= ? where i_surkey= ?";
		PreparedStatement ps1=con.prepareStatement(updatequery);
		ps1.setString(1,"yes");
		ps1.setString(2, item_Id);
	 ps1.executeUpdate();
		
	}
	public boolean validate(String item_Id)
	{
		String fetchsellerdetails = "select * from item where i_surkey =  ?";
		 boolean status = false;
		try
		{
			PreparedStatement ps=con.prepareStatement(fetchsellerdetails);
			int itemid=(Integer.parseInt(item_Id));
			ps.setInt(1, itemid);
			ResultSet rs=ps.executeQuery();
		
			if(rs.next())
			{
				
				System.out.println("immm here");
			status=true;
			}
			else
				status= false;
				
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return status;
	}
}
