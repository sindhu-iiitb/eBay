package ebay.iiitb.deals;

import java.util.ArrayList;
import java.util.HashMap;

import com.opensymphony.xwork2.ActionSupport;

public class DealsAction extends ActionSupport{
	HashMap<Integer, ArrayList<DealsModel>> deals=new HashMap<Integer, ArrayList<DealsModel>>();
	DealsService dealsService=new DealsService();
	public String execute()
	{
		deals=dealsService.getDeals();
		System.out.println(deals.keySet());
		if(!deals.isEmpty())
		{
			System.out.println("in success");
			return SUCCESS;
		}
		else
			return ERROR;
		
	}
	public HashMap<Integer, ArrayList<DealsModel>> getDeals() {
		return deals;
	}
	public void setDeals(HashMap<Integer, ArrayList<DealsModel>> deals) {
		this.deals = deals;
	}
}
