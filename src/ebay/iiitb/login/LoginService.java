//tables : user
//user : user_id , pwd 
package ebay.iiitb.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ebay.iiitb.DBUtil.DbConnection;

public class LoginService {
	public boolean login(LoginModal login) {
		int u_surkey = 0;																//Added by Sirisha
		boolean status=false;
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		PreparedStatement ps;
		String login1="select * from user where (user_id=? and pwd=?) or (email=? and pwd=?)";
		try {
			ps=con.prepareStatement(login1);
			ps.setString(1, login.getEmail_user());
			ps.setString(2, login.getPassword());
			ps.setString(3, login.getEmail_user());
			ps.setString(4, login.getPassword());
			rs=ps.executeQuery();
			while (rs.next()) {
				login.setUsername(rs.getString(7));
				login.setEmail_user(rs.getString(3));
				login.setFname(rs.getString(1));
				login.setLname(rs.getString(2));
				login.setU_surkey(rs.getInt(5));										//Added by Sirisha
				status=true;
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
		
		
	}
    public boolean loginafterregister(LoginModal login) {
    	boolean status=false;
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		ResultSet rs;
		PreparedStatement ps;
		String login1="select * from user where user_id=?";
		try {
			System.out.println(login.getUsername());
			ps=con.prepareStatement(login1);
			ps.setString(1, login.getUsername().trim());
			
			rs=ps.executeQuery();
			while (rs.next()) {
				login.setUsername(rs.getString(7));
				login.setEmail_user(rs.getString(3));
				login.setFname(rs.getString(1));
				login.setLname(rs.getString(2));
				login.setU_surkey(rs.getInt(5));
				status=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
		
	}
}
