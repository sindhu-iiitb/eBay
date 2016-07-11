package ebay.iiitb.trackOrder;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ChangeStatusAction extends ActionSupport
{
	Map<String, Object> session = ActionContext.getContext().getSession();
	private ArrayList<TrackOrderModel> orderitems =new ArrayList<TrackOrderModel>();
	private int order_id;
	int u_surkey = (Integer) session.get("user_surr_key");
	private int o_surkey;
	private int i_surkey;
	
	
	public int getO_surkey() {
		return o_surkey;
	}
	public void setO_surkey(int o_surkey) {
		this.o_surkey = o_surkey;
	}
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public ArrayList<TrackOrderModel> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(ArrayList<TrackOrderModel> orderitems) {
		this.orderitems = orderitems;
	}

	
	public String isSeller()
	{
		
		ChangeStatusService changeStatusService=new ChangeStatusService();
		if(changeStatusService.checkSeller(u_surkey))
			return SUCCESS;
		return ERROR;
	}
	public String getPaidItems()
	{
		ChangeStatusService changeStatusService=new ChangeStatusService();
		setOrderitems(changeStatusService.getPaidOrders(u_surkey));
		if(getOrderitems().isEmpty())
			return ERROR;
		return SUCCESS;
	}
	
	public String Change_As_Shipped()
	{
		System.out.println("In Change status action itemsurkey = "+getI_surkey());
		ChangeStatusService changeStatusService=new ChangeStatusService();
		if(changeStatusService.updateOrder_asShipped(getO_surkey(),getI_surkey()))
			return SUCCESS;
		return ERROR;
	}
	
	public String getShippedItems()
	{
		ChangeStatusService changeStatusService=new ChangeStatusService();
		setOrderitems(changeStatusService.getShippedOrders(u_surkey));
		if(getOrderitems().isEmpty())
			return ERROR;
		return SUCCESS;
	}
	public String Change_As_Received()
	{
		ChangeStatusService changeStatusService=new ChangeStatusService();
		if(changeStatusService.updateOrder_asReceived(getO_surkey()))
			return SUCCESS;
		return ERROR;
	}
	

	public int getI_surkey() {
		return i_surkey;
	}
	public void setI_surkey(int i_surkey) {
		this.i_surkey = i_surkey;
	}

	
}
