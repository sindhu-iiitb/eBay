//tables : deals , item , seller , user
//item : i_surkey
//seller : s_surkey
//user : u_surkey
package ebay.iiitb.deals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import ebay.iiitb.DBUtil.DbConnection;
public class DealsService {
	
	
	
	public HashMap<Integer, ArrayList<DealsModel>> getDeals() {
		DealsModel dealsModel;
		boolean status1=true;
		boolean status2=true;
		boolean status3=true;
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();	
		String getdeals="select * from deals";
		String getitems="select * from item where i_surkey=?";
		String sellerdetails="select * from seller where s_surkey=?";
		String detailsfromuser="select * from user where u_surkey=?";
		HashMap<Integer, ArrayList<DealsModel>> deals = new HashMap<Integer, ArrayList<DealsModel>>();;
		int id1=0,id2=0,id3=0;
		try {
			PreparedStatement ps=con.prepareStatement(getdeals);
			ResultSet res=ps.executeQuery();
			while(res.next()){
				dealsModel=new DealsModel();
			dealsModel.setDealtitle(res.getString(6));
			dealsModel.setDeals_id(res.getInt(1));
			System.out.println("IN deals"+res.getString(6));
			id1=res.getInt(2);
			id2=res.getInt(3);
			id3=res.getInt(4);
				ps=con.prepareStatement(getitems);
				ps.setInt(1, id1);
				ResultSet res1=ps.executeQuery();
				ArrayList<DealsModel> dealitems=new ArrayList<DealsModel>();
				
					while(res1.next())
					{
						DealsModel deal=new DealsModel();
						deal.setDealtitle(dealsModel.getDealtitle());
						deal.setItemid(id1);
						deal.setItemname(res1.getString(2));
						deal.setPrice(res1.getInt(4));
						deal.setPicture(res1.getString(3));
						deal.setSellerid(res1.getInt(6));
						PreparedStatement seller=con.prepareStatement(sellerdetails);
						seller.setInt(1, deal.getSellerid());
						ResultSet res4=seller.executeQuery();
						while(res4.next()){
							PreparedStatement user=con.prepareStatement(detailsfromuser);
							user.setInt(1, res4.getInt(5));
							ResultSet res5=user.executeQuery();
							while(res5.next()){
								deal.setSellername(res5.getString(1)+" "+res5.getString(2));
							}
							deal.setSellerrating(res4.getDouble(7));
							deal.setNumberofbuyers(res4.getInt(15));
						}
						deal.setQuantity(res1.getInt(8));
						deal.setI_surkey1(id1);
						if(res1.getInt(8)==0)
						{
							status1=false;
						}
						
						dealitems.add(deal);
					}
				ps=con.prepareStatement(getitems);
				ps.setInt(1, id2);
				ResultSet res2=ps.executeQuery();
					while(res2.next())
					{
						DealsModel deal=new DealsModel();
						deal.setItemid(id1);
						deal.setDealtitle(dealsModel.getDealtitle());
						deal.setItemname(res2.getString(2));
						deal.setPrice(res2.getInt(4));
						deal.setPicture(res2.getString(3));
						deal.setSellerid(res2.getInt(6));
						deal.setQuantity(res2.getInt(8));
						deal.setI_surkey1(id2);
						if(res2.getInt(8)==0)
						{
							status2=false;
						}
						
						dealitems.add(deal);
						}
					ps=con.prepareStatement(getitems);
					ps.setInt(1, id3);
					ResultSet res3=ps.executeQuery();
						while(res3.next())
						{
							DealsModel deal=new DealsModel();
							deal.setItemid(id1);
							deal.setDealtitle(dealsModel.getDealtitle());
							deal.setItemname(res3.getString(2));
							deal.setPrice(res3.getInt(4));
							deal.setPicture(res3.getString(3));
							deal.setSellerid(res3.getInt(6));
							deal.setQuantity(res3.getInt(8));
							deal.setI_surkey1(id3);
							if(res3.getInt(8)==0)
							{
								status3=false;
							}
							
							dealitems.add(deal);
						}
						if(status1 && status2 && status3)
							dealsModel.setFlag("yes");
						else {
							dealsModel.setFlag(null);
						}
						System.out.println("in deals flag"+dealsModel.getFlag());
						dealitems.add(dealsModel);
						deals.put(dealsModel.getDeals_id(), dealitems);
						status1=status2=status3=true;	
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return deals;

	}
}
