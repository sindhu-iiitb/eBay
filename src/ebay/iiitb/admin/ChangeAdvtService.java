
//tables : advt_detail_table
//advt_detail_table: cost , adt_surkey
package ebay.iiitb.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;

public class ChangeAdvtService {
 int cost;
	public ChangeAdvtService(String cost) {
		this.cost=Integer.parseInt(cost);
	}
	public boolean updatecost() {
		String updatequery="update advt_detail_table set cost=? where adt_surkey=?";
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(updatequery);
			ps.setInt(1, cost);
			ps.setInt(2, 1);
			if(ps.executeUpdate()>0){
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return false;
		
	}
	

}
