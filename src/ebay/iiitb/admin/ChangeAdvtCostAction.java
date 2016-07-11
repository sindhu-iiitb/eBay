package ebay.iiitb.admin;

import com.opensymphony.xwork2.ActionSupport;

public class ChangeAdvtCostAction extends ActionSupport {
String cost;

public String getCost() {
	return cost;
}

public void setCost(String cost) {
	this.cost = cost;
}

public String execute() {
	ChangeAdvtService change=new ChangeAdvtService(cost);	
	change.updatecost();
	return SUCCESS;
	
}
}
