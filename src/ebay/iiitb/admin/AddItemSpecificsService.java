
//tables : cat_sub_spec , category
//cat_sub_spec : cat_id, sub_cat_id , specifications
//category : name


package ebay.iiitb.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ebay.iiitb.DBUtil.DbConnection;

public class AddItemSpecificsService {

	public boolean addItemspecs(AddItemSpecificAttributeModel item) {

		String updatequery="UPDATE  cat_sub_spec SET specifications=? where cat_id =? AND sub_cat_id =?";
		String addquery="insert into cat_sub_spec (cat_id,sub_cat_id,specifications) values (?,?,?)";
		String getquery="select * from cat_sub_spec where cat_id=? and sub_cat_id=?";
		String getcatid="select * from category where name=?";
		
		int catid=0,subcatid=0;
		String att1=item.getSpecificattribute1();
		String att2=item.getSpecificattribute2();
		String att3=item.getSpecificattribute3();
		String present1="";
		DbConnection db = new DbConnection();
		Connection con = db.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		try {
			System.out.println("in try");
			ps=con.prepareStatement(getcatid);
			ps.setString(1, item.getCategory().trim());
			rs=ps.executeQuery();
			System.out.println(item.getCategory());
			System.out.println(item.getSubCategory());
			while(rs.next()){
				catid=rs.getInt(1);
			}
			
			System.out.println(catid);
			System.out.println(subcatid);
			
			ps=con.prepareStatement(getquery);
			ps.setInt(1, catid);
			ps.setInt(2, Integer.parseInt(item.getSubCategory()));
			rs=ps.executeQuery();
			while(rs.next()){
				present1=rs.getString(3);
			}
			
			String specification=att1+","+att2+","+att3;
			if(present1=="")
			{
				
				System.out.println(specification);
				ps=con.prepareStatement(addquery);
				ps.setInt(1, catid);
				ps.setInt(2, Integer.parseInt(item.getSubCategory()));
				ps.setString(3,specification);
				if(ps.executeUpdate()>0){
						return true;
				}
			}
			else
			{
			
				System.out.println(specification);
				ps=con.prepareStatement(updatequery);
				ps.setInt(2, catid);
				ps.setInt(3, Integer.parseInt(item.getSubCategory()));
				ps.setString(1, present1+","+specification);
				if(ps.executeUpdate()>0){
					return true;
				}
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}

}
