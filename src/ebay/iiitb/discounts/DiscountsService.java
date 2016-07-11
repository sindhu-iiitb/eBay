//tables : item
//item : discount , quantity
package ebay.iiitb.discounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ebay.iiitb.DBUtil.DbConnection;

public class DiscountsService {
	public ArrayList<DiscountModel> getDiscount(){
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	String getdiscount="select * from item where discount<> ? and quantity > 0";
	ArrayList<DiscountModel> discountModels=new ArrayList<DiscountModel>();
	try {
		PreparedStatement ps=con.prepareStatement(getdiscount);
		ps.setInt(1, 0);
		ResultSet res=ps.executeQuery();
		while(res.next()){
			System.out.println("in discounts");
			DiscountModel discountModel=new DiscountModel();
			discountModel.setDiscount(res.getInt(7));
			discountModel.setItemid(res.getInt(1));
			discountModel.setItemname(res.getString(2));
			discountModel.setPicture(res.getString(3));
			discountModel.setPrice(res.getInt(4));
			discountModel.setQuantity(res.getInt(8));
			discountModel.setSellerid(res.getInt(6));
			discountModels.add(discountModel);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return discountModels;
	
	}
}
