package ebay.iiitb.deals;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InsertDealAction extends ActionSupport implements ModelDriven<InsertDealModel> {
	
	InsertDealService insertDeal=new InsertDealService();
	InsertDealModel insertDealModel=new InsertDealModel();
	public InsertDealService getInsertDeal() {
		return insertDeal;
	}


	public void setInsertDeal(InsertDealService insertDeal) {
		this.insertDeal = insertDeal;
	}


	public InsertDealModel getInsertDealModel() {
		return insertDealModel;
	}


	public void setInsertDealModel(InsertDealModel insertDealModel) {
		this.insertDealModel = insertDealModel;
	}


	
	
	
	public String execute() {
		System.out.println(insertDealModel.getDeal_title());
		System.out.println(insertDealModel.getItem1());
		System.out.println(insertDealModel.getItem2());
		System.out.println(insertDealModel.getItem3());
		if(insertDeal.insertDeal(insertDealModel))
		{
			return SUCCESS;
		}
		else {
			return ERROR;
		}
		
	}


	@Override
	public InsertDealModel getModel() {
		// TODO Auto-generated method stub
		return insertDealModel;
	}
}
