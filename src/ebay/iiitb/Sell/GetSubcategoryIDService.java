//tables : category
//category : name
package ebay.iiitb.Sell;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;

public class GetSubcategoryIDService {
int subid;
public int getSubcategoryId(String subcategoryname)
{
	String subcategoryid="select * from category where name=?";
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	try
	{
		PreparedStatement ps=con.prepareStatement(subcategoryid);
		ps.setString(1, subcategoryname);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			subid=rs.getInt(1);
			}		
	}catch (SQLException e) {
		e.printStackTrace();
		
	}
	return subid;
}

}
