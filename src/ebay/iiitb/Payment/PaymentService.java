//tables : bank
//bank : card_id , password
package ebay.iiitb.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ebay.iiitb.DBUtil.DbConnection;
public class PaymentService {

	PaymentModel paymentModel;
	boolean status1;
	DbConnection db = new DbConnection();
	Connection con = db.getConnection();	
	public PaymentService(PaymentModel paymentModel)
	{
		this.paymentModel = paymentModel;
	}
	int amount;
	public boolean PaymentMethod()
	{
		System.out.println("in service Class");
		
		String checkUserAccount="select * from bank where card_id= ? and password= ? ";
		 try
			{  
			 	System.out.println("hello1");
				PreparedStatement ps1=con.prepareStatement(checkUserAccount);
				ps1.setString(1, paymentModel.getDebit_Card());
				ps1.setString(2, paymentModel.getPassword());
				System.out.println("hello2");
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next())
				{
				System.out.println("hello1executed Check user");
				status1= true;
				}
				else 
					status1= false;
				rs1.close();
				
			}
		 catch (SQLException e1) {
			 System.out.println("in catch");
				e1.printStackTrace();
				status1= false;
			}
			System.out.println("out of payment service");
		return status1;		
	}}
	