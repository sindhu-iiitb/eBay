package ebay.iiitb.admin;

import java.sql.SQLException;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateAdvtAction extends ActionSupport implements ModelDriven {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String item_Id;

	public String getItem_Id() {
		return item_Id;
	}

	public void setItem_Id(String item_Id) {
		this.item_Id = item_Id;
	}
	boolean status1;
	public String execute()
	{
		System.out.println("in execute of updateAdvt");
		System.out.println(getItem_Id());
		status1=validateid();
		UpdateAdvtService updateadvtservice=new  UpdateAdvtService();
		try {
			updateadvtservice.update(getItem_Id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status1)
		return SUCCESS;
		else
			return "error";
	}
	public boolean validateid()
	{
		boolean status=false;
	System.out.println("in update status validate"+ getItem_Id());
		UpdateAdvtService updateadvtservice = new  UpdateAdvtService();
		status=updateadvtservice.validate(getItem_Id());
		System.out.println(status+"in updateaction");
		return status;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
