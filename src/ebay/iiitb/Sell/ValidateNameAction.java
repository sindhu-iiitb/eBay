package ebay.iiitb.Sell;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import ebay.iiitb.admin.UpdateAdvtService;

public class ValidateNameAction extends ActionSupport implements SessionAware {
private String item_Name;
private Map<String, Object> session;
public String getItem_Name() {
	return item_Name;
}
private String status;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public void setItem_Name(String item_Name) {
	this.item_Name = item_Name;
}
public String validatename()
{System.out.println(getItem_Name());
	
	System.out.println("in update status validate"+ getItem_Name());
		ValidateNameService validservice = new  ValidateNameService();
		int u_key=(Integer) session.get("user_surr_key");
		System.out.println(u_key);
		setStatus(validservice.validate(getItem_Name(),u_key));
		System.out.println(getStatus()+"in valid name action");
	return "success";
}
public void setSession(Map<String, Object> map) {
	// TODO Auto-generated method stub
	this.session=map;
}
}
