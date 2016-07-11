package ebay.iiitb.Sell;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddItemAction extends ActionSupport implements ModelDriven<SellItemModel>,SessionAware{

	private SellItemModel itemModel = new SellItemModel();
	private Map<String, Object> session;
	AddItemService ais = new AddItemService(itemModel);
	public String execute() throws Exception
	{
		//String x= (String) session.get("user_surr_key");
		Integer usr= (Integer) session.get("user_surr_key");
		
		
		if(ais.AddItemDetails(usr.intValue()))
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
