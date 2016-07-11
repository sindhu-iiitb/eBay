package ebay.iiitb.discounts;

import java.util.ArrayList;
import java.util.Iterator;

import com.opensymphony.xwork2.ActionSupport;

public class DiscountsAction extends ActionSupport {
	ArrayList<DiscountModel> discountModels;
	DiscountsService discountsService=new DiscountsService();
	
	
	public ArrayList<DiscountModel> getDiscountModels() {
		return discountModels;
	}
	public void setDiscountModels(ArrayList<DiscountModel> discountModels) {
		this.discountModels = discountModels;
	}
	public DiscountsService getDiscountsService() {
		return discountsService;
	}
	public void setDiscountsService(DiscountsService discountsService) {
		this.discountsService = discountsService;
	}

	public String execute()
	{
		discountModels=discountsService.getDiscount();
		for (Iterator iterator = discountModels.iterator(); iterator.hasNext();) {
			DiscountModel discountModel = (DiscountModel) iterator.next();
			System.out.println(discountModel.getItemid());
			System.out.println(discountModel.getDiscount());
		}
		if(!discountModels.isEmpty())
		{
			System.out.println("in success");
			return SUCCESS;
		}
		else
			return ERROR;
		
	}
	
	
}
