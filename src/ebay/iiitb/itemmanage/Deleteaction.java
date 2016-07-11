package ebay.iiitb.itemmanage;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import ebay.iiitb.itemmanage.deleteservice;

public class Deleteaction implements SessionAware {
private ArrayList<String> itemslist=new ArrayList<String>();
private Map<String, Object> session;
	public ArrayList<String> getItemslist() {
	return itemslist;
}
public void setItemslist(ArrayList<String> itemslist) {
	this.itemslist = itemslist;
}
	public String  execute()
	{
		System.out.println("delete action");
		
		String email=(String) session.get("email");
		
	System.out.println(email);
		deleteservice delete=new deleteservice();
		setItemslist(delete.deleteitem(email));
		if(itemslist.isEmpty())return "failure";
	return "success";
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
}
