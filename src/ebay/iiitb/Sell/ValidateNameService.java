//tables : seller , item
//seller : s_surkey , u_surkey
//item : item_name , s_surkey
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;

public class ValidateNameService {
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	public String validate(String item_Name,int u_key)
	{
		String sellerkey = "select s_surkey from seller  where u_surkey =  ?";
		String itemquery="select * from item where s_surkey=? and item_name=?";
		 String status = null;
		 int s_key = 0;
		try
		{
			PreparedStatement ps=con.prepareStatement(sellerkey);
			
			ps.setInt(1, u_key);
			ResultSet rs=ps.executeQuery();
		
			if(rs.next())
			{
				 s_key=rs.getInt(1);
				System.out.println(" ValidateNameService" + s_key);
			
			}
			PreparedStatement ps1=con.prepareStatement(itemquery);
			ps1.setInt(1,s_key);
			ps1.setString(2,item_Name );
			ResultSet rs1=ps1.executeQuery();

			if(rs1.next())
			{
				System.out.println(rs1.getInt(1)+"i_surkey");
				status="true";
				System.out.println(" ValidateNameService"+status);
			
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		return status;
	}
	
}
