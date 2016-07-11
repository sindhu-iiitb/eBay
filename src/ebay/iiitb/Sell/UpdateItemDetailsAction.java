package ebay.iiitb.Sell;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UpdateItemDetailsAction extends ActionSupport implements ModelDriven<SellItemModel>,SessionAware{

	private SellItemModel itemModel = new SellItemModel();
	private Map<String, Object> session;
	UpdateItemDetailsService uis = new UpdateItemDetailsService(itemModel);
	public String execute() throws Exception
	{
		Integer usr= (Integer) session.get("user_surr_key");	
		if(uis.UpdateItemDetails(usr.intValue()))
			return "success";  
			return ERROR;
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
	
}
