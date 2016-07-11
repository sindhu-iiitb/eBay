//tables : vat
//vat : vat_percentage , changedOn , vat_surkey
package ebay.iiitb.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ebay.iiitb.DBUtil.DbConnection;

public class ChangeVatPercentageService {
	
	int vat_percentage;
	public ChangeVatPercentageService(int percent) {
		this.vat_percentage = percent;
	}
	
	public boolean updateVatdetails()
	{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		;
		String updatevat = "update vat set vat_percentage=?,changedOn = ? where vat_surkey=?";
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps;
		try {
			ps=con.prepareStatement(updatevat);
			ps.setInt(1, vat_percentage);
			ps.setString(2, format.format(date));
			ps.setInt(3, 1);
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
