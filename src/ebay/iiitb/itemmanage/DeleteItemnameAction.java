package ebay.iiitb.itemmanage;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import ebay.iiitb.itemmanage.DeleteItemnameService;

public class DeleteItemnameAction implements SessionAware {
private String itemslist;
private Map<String, Object> session;

public String getItemslist() {
	return itemslist;
}

public void setItemslist(String itemslist) {
	this.itemslist = itemslist;
}
public String execute()
{
	String email=(String) session.get("email");
System.out.println("arey waah"+itemslist);
DeleteItemnameService itemnameservice=new DeleteItemnameService();
itemnameservice.deleterow(email,getItemslist());
return "success";
}

@Override
public void setSession(Map<String, Object> map) {
	// TODO Auto-generated method stub
	this.session=map;
}
}
