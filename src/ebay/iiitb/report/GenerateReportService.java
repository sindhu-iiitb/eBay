//tables : user , seller , item
//user : firstname , lastname , u_surkey
//seller : u_surkey , s_surkey
//item : i_surkey , item_name , s_surkey , price
package ebay.iiitb.report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ModelDriven;

import ebay.iiitb.DBUtil.DbConnection;


public class GenerateReportService {

	
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();
	private Reportmodel reportmodel;
	
//	public GenerateReportService(Reportmodel reportmodel)
//	{
//		this.reportmodel = reportmodel;
//	}
	private ArrayList<generatereportmodel> reportdetails = new ArrayList<generatereportmodel>();
	
	//private	int from,to;

	public ArrayList<generatereportmodel> getreport(int from,int to)
{//from=reportmodel.getFromprice();
 //to=reportmodel.getToprice();
 System.out.println("hello");
			System.out.println(from+"------------"+to);
			String itemquery="select i_surkey,item_name,s_surkey from item where price<=? and price>=?";
			String sellerquery="select u_surkey from seller where s_surkey=?";
			String userquery="select firstname,lastname from user where u_surkey=?";
			PreparedStatement ps1,ps2,ps3;
			ResultSet rs1,rs2,rs3;
			int uid = 0,sid;
			try {
				ps1=con.prepareStatement(itemquery);
				ps1.setInt(1,to);
				ps1.setInt(2,from);
				rs1=ps1.executeQuery();
				while(rs1.next())
				{
					generatereportmodel grm= new generatereportmodel();
					System.out.println(rs1.getInt(1)+ " "+rs1.getString(2));
					grm.setItemid(rs1.getInt(1));
					grm.setItem_name(rs1.getString(2));
					grm.getFirstname();
					grm.getLastname();
					 sid=rs1.getInt(3);
					 System.out.println(sid);
					ps2=con.prepareStatement(sellerquery);
					ps2.setInt(1, sid);
					rs2=ps2.executeQuery();
					while(rs2.next())
						 uid = rs2.getInt(1);
					System.out.println(uid);
					ps3=con.prepareStatement(userquery);
					ps3.setInt(1, uid);
					rs3=ps3.executeQuery();
					while(rs3.next())
					{
						grm.setFirstname(rs3.getString(1));
						grm.setLastname(rs3.getString(2));
						System.out.println(grm.getFirstname());
						System.out.println(grm.getLastname());
					}
					
					reportdetails.add(grm);
					
				}//end of while
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return reportdetails;
}	//end of function
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
