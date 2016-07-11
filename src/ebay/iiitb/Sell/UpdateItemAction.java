package ebay.iiitb.Sell;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateItemAction extends ActionSupport implements ModelDriven<SellItemModel>,SessionAware{

	private SellItemModel itemModel = new SellItemModel();
	private Map<String, Object> session;
	private Map<String,String> specs;
	UpdateItemService uis = new UpdateItemService(itemModel);
	public String execute() throws Exception
	{
		//String x= (String) session.get("user_surr_key");
		Integer usr= (Integer) session.get("user_surr_key");		
		setSpecs(uis.UpdateItemDetails(usr.intValue()));
		System.out.println("============================"+itemModel.getItem_desc());
		if(itemModel.getI_surkey() != null)
			return "success"; 
		
			return "error";
	}
	@Override
	public SellItemModel getModel() {
		// TODO Auto-generated method stub
		return itemModel;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
		
	}
	public Map<String,String> getSpecs() {
		return specs;
	}
	public void setSpecs(Map<String,String> specs) {
		this.specs = specs;
	}
	
}