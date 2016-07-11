package ebay.iiitb.trackOrder;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderItemsAction extends ActionSupport implements ModelDriven<ArrayList<TrackOrderItemModel>> 
{
	private int orderid;
	private float rate;
	private int item_key;
	Map<String, Object> session = ActionContext.getContext().getSession();
	private ArrayList<TrackOrderItemModel> itemdetails = new ArrayList<TrackOrderItemModel>();
	int u_surkey = (Integer) session.get("user_surr_key");
	
	public String execute()
	{
		
		ShippedOrderItemsService orderItemsService=new ShippedOrderItemsService();
		setItemdetails(orderItemsService.getOrders(getOrderid(),u_surkey));
		if(getItemdetails().isEmpty())
			return ERROR;
		return SUCCESS;
	}
	
	public String getReceivedOrderItems()
	{
		System.out.println("In getShippedorderitems action :"+getOrderid());
		ShippedOrderItemsService orderItemsService=new ShippedOrderItemsService();
		setItemdetails(orderItemsService.getReceivedItems(getOrderid()));
		if(getItemdetails().isEmpty())
			return ERROR;
		return SUCCESS;
	}
	
	public String getShippedOrderItems()
	{
		
		ShippedOrderItemsService orderItemsService=new ShippedOrderItemsService();
		setItemdetails(orderItemsService.getShippedItems(getOrderid(),u_surkey));
		if(getItemdetails().isEmpty())
			return ERROR;
		return SUCCESS;
	}
	
	

	@Override
	public ArrayList<TrackOrderItemModel> getModel() {
		// TODO Auto-generated method stub
		return itemdetails;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public ArrayList<TrackOrderItemModel> getItemdetails() {
		return itemdetails;
	}

	public void setItemdetails(ArrayList<TrackOrderItemModel> itemdetails) {
		this.itemdetails = itemdetails;
	}
	
	public String rateSeller()
	{
		ShippedOrderItemsService orderItemsService=new ShippedOrderItemsService();
		System.out.println("In Action:"+getRate());
		if(orderItemsService.sellerRating(getItem_key(), getRate()))
			return SUCCESS;
		return ERROR;
	}


	public int getItem_key() {
		return item_key;
	}


	public void setItem_key(int item_key) {
		this.item_key = item_key;
	}


	public float getRate() {
		return rate;
	}


	public void setRate(float rate) {
		this.rate = rate;
	}


	
}
