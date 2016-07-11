//tables : user , seller ,item , deals 
//user : u_surkey , email
//seller : s_surkey , u_surkey
//item : i_surkey , item_name , s_surkey , items_in_deal , deal_added
//deals : itemid1 , itemid2 , freeitemid
package ebay.iiitb.itemmanage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;

public class DeleteItemnameService {

	public void deleterow(String email,String item_name){
		
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();	
		int userid=0,sellerid=0,iid=0;
		String dealid="";
		String userkey="select u_surkey from user where email=?";
		String sellerkey="select s_surkey from seller where u_surkey=?";
		String itemquery="select i_surkey from item where item_name=?";
		String query="delete from item where s_surkey=? and item_name=?";
		String dealquery="delete from deals where itemid1=? or itemid2=? or freeitemid=?";
		String fetchdealitem="select items_in_deal from item where item_name=? and deal_added=?";
		PreparedStatement ps1,ps2,ps3,ps4,ps5,ps6,ud1,ud2,ud3;
		try {
			ps3=con.prepareStatement(userkey);
			ps3.setString(1, email);
			 ResultSet rs1=ps3.executeQuery();
			 while(rs1.next())
				 userid=rs1.getInt(1);
			 
			
			 
			 ps2=con.prepareStatement(sellerkey);
				ps2.setInt(1, userid);
				 rs1=ps2.executeQuery();
				 while(rs1.next())
					 sellerid=rs1.getInt(1);
				 
				 ps5=con.prepareStatement(itemquery);
				 ps5.setString(1,item_name);
				 rs1=ps5.executeQuery();
				 while(rs1.next())
					 iid=rs1.getInt(1);
			
				//deals in item 
				 ps6=con.prepareStatement(fetchdealitem);
				 ps6.setString(1,item_name);
				 ps6.setString(2, "Yes");
				 rs1=ps6.executeQuery();
				 while(rs1.next())
					 dealid=rs1.getString(1);
				 System.out.println("deal ids"+dealid);
				
				 //splitting
				 if(dealid!=""){
				 String[] itemids = dealid.split(",");
				 int iid1=(Integer.parseInt(itemids[0]));
				
				 int iid2=(Integer.parseInt(itemids[1]));
				 int iid3=(Integer.parseInt(itemids[2]));
				 System.out.println("csv "+iid1+iid2+iid3);
				 //updating
				 String value="null,null,null";
				 String updatedeal1="update item set deal_added=? , items_in_deal=? where i_surkey=?";
				 String updatedeal2="update item set deal_added=? , items_in_deal=? where i_surkey=?";
				 String updatedeal3="update item set deal_added=? , items_in_deal=? where i_surkey=?";
				 ud1=con.prepareStatement(updatedeal1);
				 ud1.setString(1, "no");
				 ud1.setString(2, value);
				 ud1.setInt(3,iid1);
				 System.out.println("going to update");
				 ud1.executeUpdate();
					System.out.println("update deal 1");
					
				 ud2=con.prepareStatement(updatedeal2);
				 ud2.setString(1, "no");
				 ud2.setString(2, value);
				 ud2.setInt(3,iid2);
				ud2.executeUpdate();
					
					System.out.println("update deal 2");
					
				 ud3=con.prepareStatement(updatedeal3);
				 ud3.setString(1, "no");
				 ud3.setString(2, value);
				 ud3.setInt(3,iid3);
				 ud3.executeUpdate();
					
					System.out.println("update deal 3");
					
					//deleting from deals table
					ps4=con.prepareStatement(dealquery);
					ps4.setInt(1,iid );
					ps4.setInt(2,iid );
					ps4.setInt(3,iid );
					if(ps4.executeUpdate()>0)
					{
					System.out.println("item deleted with iid "+iid);
					}
				 }
				 
				 
			//deleting from item table a row	 
			ps1=con.prepareStatement(query);
			ps1.setInt(1,sellerid);
			ps1.setString(2,item_name);
			if(ps1.executeUpdate()>0)
			{
			System.out.println("item deleted with name "+item_name+"for seller"+email);
			}
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
