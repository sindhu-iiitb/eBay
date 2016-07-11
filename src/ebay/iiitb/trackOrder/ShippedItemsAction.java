package ebay.iiitb.trackOrder;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;




public class ShippedItemsAction extends ActionSupport implements ModelDriven<ArrayList<TrackOrderModel>>{
	
	ShippedItemsService shippedItemsService=new ShippedItemsService();
    Map<String, Object> session = ActionContext.getContext().getSession();
	private ArrayList<TrackOrderModel> orderitems=new ArrayList<TrackOrderModel>();
	
	public String execute()
	{
		System.out.println("Im in execute of Track");
		int u_surkey = (Integer) session.get("user_surr_key");
		setOrderitems(shippedItemsService.getOrders(u_surkey));
		if(getOrderitems().isEmpty())
			return ERROR;
		return SUCCESS;

		
	}

	public ArrayList<TrackOrderModel> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(ArrayList<TrackOrderModel> orderitems) {
		this.orderitems = orderitems;
	}

	@Override
	public ArrayList<TrackOrderModel> getModel() {
		// TODO Auto-generated method stub
		return orderitems;
	}
	

}
