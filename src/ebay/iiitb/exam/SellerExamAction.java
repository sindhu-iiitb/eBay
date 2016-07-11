//tables : item , seller ,user
//item : brand087 , advt_status
//seller : s_surkey
//user : u_surkey
package ebay.iiitb.exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import ebay.iiitb.DBUtil.DbConnection;
import ebay.iiitb.itemdetails.ItemModel;

public class SellerExamAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7321815944519428087L;
	private static final int NULL = 0;
	private ArrayList<SellerModel> sellers=new ArrayList<SellerModel>();
	private ArrayList<Integer> sellerids=new ArrayList<Integer>();
	
	public ArrayList<SellerModel> getSellers() {
		return sellers;
	}

	public void setSellers(ArrayList<SellerModel> sellers) {
		this.sellers = sellers;
	}

	private String brand;
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	


public String execute() {
	boolean status=false;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	ResultSet rs,rs1,rs2;
	int seller_surkey;
	String sellername;
	String username = null;
	int sid;
	PreparedStatement ps,ps1,ps2;
	String address="";
	String query="select * from item where brand087=? and advt_status=?";
	String getSellers="select * from seller where s_surkey=?";
	String getSellername="select * from user where u_surkey=?";
	try {
		
		ps=con.prepareStatement(query);
		
		
		ps.setString(1, brand);
		ps.setString(2, "yes");
		
		
		
		rs1=ps.executeQuery();
		while(rs1.next()){
			seller_surkey=rs1.getInt(6);
			if(!(sellerids.contains(seller_surkey))){
				sellerids.add(seller_surkey);
			}
		}
		for(int i=0;i<sellerids.size();i++){
		sid=sellerids.get(i);
		ps=con.prepareStatement(getSellers);
		ps.setInt(1, sid);
		rs=ps.executeQuery();
		while(rs.next()){
			seller_surkey=rs.getInt(5);
			
			ps2=con.prepareStatement(getSellername);
			ps2.setInt(1,seller_surkey);
			rs2=ps2.executeQuery();
			while(rs2.next()){
				username=rs2.getString(1);
			}
			
			
			SellerModel seller=new SellerModel();
			seller.setSellerid(rs.getString(2));
			
			seller.setSellername(username);
			seller.setSelleraddress(rs.getString(9));
			sellers.add(seller);
			System.out.println("Inside sellerExamAction    "+sellers.size());
		}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return SUCCESS;
	
}


}
