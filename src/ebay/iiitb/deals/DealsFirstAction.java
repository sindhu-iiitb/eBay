package ebay.iiitb.deals;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

public class DealsFirstAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	DealsFirstService dealsService = new DealsFirstService();
	ArrayList<String> itemNames = new ArrayList<String>();
	public String execute(){
		String email=(String) session.get("email");
		System.out.println("Deals First Action");
		itemNames=dealsService.getItemNames(email);
		return SUCCESS; 
	}
	public ArrayList<String> getItemNames() {
		return itemNames;
	}
	public void setItemNames(ArrayList<String> itemNames) {
		this.itemNames = itemNames;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
	}
}
