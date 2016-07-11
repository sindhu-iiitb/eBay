//tables : user , bank , seller , address
//user : u_surkey , email
//seller : seller_id , sellershop , u_surkey , b_surkey , nature_of_business
//bank : b_surkey , u_surkey
//address : u_surkey , line1 , line2 , state , city , pincode , mobile
package ebay.iiitb.itemmanage;
import ebay.iiitb.DBUtil.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import ebay.iiitb.itemmanage.SellerDetailsModel;

import com.opensymphony.xwork2.ModelDriven;



public class SellerDetailsService implements ModelDriven<SellerDetailsModel>{
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	// HttpSession session = ServletActionContext.getRequest().getSession();
	
	SellerDetailsModel sellerdetailsmodel;
	boolean status=false;
	boolean status1=false;
	public SellerDetailsService(SellerDetailsModel sellerdetailsmodel)
	{
		this.sellerdetailsmodel = sellerdetailsmodel;
	}
	
	public boolean insertdetails(String email)
	{
		
		int id = 0 ;
		int bank_id=0;
		
		System.out.println("Priting in service"+email);
		
		System.out.println("email logged in SellerDetailsService is:"+ email);
		String u_surrogatekey="select u_surkey from user where email=?";
		String b_surrogatekey="select b_surkey from bank where u_surkey=?";
		String insert="insert into seller(seller_id,sellershop,u_surkey,b_surkey,nature_of_business) values(?,?,?,?,?)";
		String insertaddress="insert into address(u_surkey,line1,line2,state,city,pincode,mobile) values(?,?,?,?,?,?,?)";
		PreparedStatement ps1,ps2,ps3,ps4;
		try {
			ps1=con.prepareStatement(u_surrogatekey);
			ps1.setString(1,email);
			System.out.println("SellerDetailsService"+ps1);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{System.out.println("in SellerDetailsService");
				 id=rs1.getInt(1);
				System.out.println("SellerDetailsService surrogate id for email"+email+"is"+id);
			}
			
			ps3=con.prepareStatement(b_surrogatekey);
			ps3.setInt(1,id);
			System.out.println("SellerDetailsService"+ps3);
			 rs1=ps3.executeQuery();
			while(rs1.next())
			{System.out.println("in SellerDetailsService");
				 bank_id=rs1.getInt(1);
				System.out.println("SellerDetailsService id for email"+email+"is"+bank_id);
			}
			
			System.out.println("end");
			ps2=con.prepareStatement(insert);
			//System.out.println(sellerdetailsmodel.getCity());
			//System.out.println(sellerdetailsmodel.getLine1());
			ps2.setString(1,sellerdetailsmodel.getSellerid());
			ps2.setString(2, sellerdetailsmodel.getSellershop());
			
			ps2.setInt(3, id);
			ps2.setInt(4, bank_id);
			ps2.setString(5, sellerdetailsmodel.getNature());
			
			
			if(ps2.executeUpdate()>0)
			{
				status=true;
			}
			else
				status=false;
			ps4=con.prepareStatement(insertaddress);
			ps4.setInt(1, id);
			ps4.setString(2, sellerdetailsmodel.getLine1());
			ps4.setString(3,sellerdetailsmodel.getLine2());
			ps4.setString(4, sellerdetailsmodel.getState());
			ps4.setString(5, sellerdetailsmodel.getCity());
			ps4.setString(6, sellerdetailsmodel.getPincode());
			ps4.setString(7, sellerdetailsmodel.getMobile());
			
			if(ps4.executeUpdate()>0)
			{
				status1=true;
			}
			else
				status1=false;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	if(status&&status1)
		return status;
	else
		return false;

	}
	
	public SellerDetailsModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
