//tables : address
//address : u_surkey , line1 , line2 , city , state , pincode , mobile

package ebay.iiitb.ChangeAddress;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import ebay.iiitb.DBUtil.*;

public class ChangeAddressService {
	private Map<String, Object> session;
	ChangeAddressModel changeAddressModel;
	boolean status1 = false;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public ChangeAddressService(ChangeAddressModel changeAddressModel)
	{
		this.changeAddressModel = changeAddressModel;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> map) {
		this.session=map;
	}

	public boolean ChangeAddressMethod(String user,int u_surkey)
	{
//		int u_surkey = (Integer) session.get("user_surr_key");
		System.out.println("in Change Addressservice starting............. "+ user);
//		String query = " select u_surkey from user where email=? ";
		String selectadressdetails = "select * from address where u_surkey = ?";
		String insertaddress = "insert into address(u_surkey,line1,line2,city,state,pincode,mobile) values(?,?,?,?,?,?,?)";
		
		System.out.println("in ChangeAddressservice "+user);
		 try
			{		
			 PreparedStatement ps1 = con.prepareStatement(selectadressdetails);
			 ps1.setInt(1, u_surkey);
			 ResultSet rs1 =  ps1.executeQuery();
			 if(rs1.next())
			 {
				  String checkUserAccount="update address set line1=? , line2=? , city=?, state=? , pincode=?, mobile=? where u_surkey=?";
					
					PreparedStatement ps=con.prepareStatement(checkUserAccount);				
					ps.setString(1, changeAddressModel.getLine1());
					ps.setString(2, changeAddressModel.getLine2());
					ps.setString(3, changeAddressModel.getCity());
					ps.setString(4, changeAddressModel.getState());
					ps.setString(5, changeAddressModel.getPincode());
					ps.setString(6, changeAddressModel.getMobile());
					ps.setInt(7, u_surkey);
					 if(ps.executeUpdate()>0)
						 status1 = true;
					 System.out.println("Address Changed");
					 
			 }
			 else{
			
				PreparedStatement ps2=con.prepareStatement(insertaddress);
				ps2.setInt(1,u_surkey);
				ps2.setString(2, changeAddressModel.getLine1());
				ps2.setString(3, changeAddressModel.getLine2());
				ps2.setString(4, changeAddressModel.getCity());
				ps2.setString(5, changeAddressModel.getState());
				ps2.setString(6, changeAddressModel.getPincode());
				ps2.setString(7, changeAddressModel.getMobile());
				
				if(ps2.executeUpdate()>0)
					status1 = true;
			 }
			}
		 catch (SQLException e1) {
				e1.printStackTrace();
				
			}
		 System.out.println("out of service chnage address");
		 return status1;
			}
}