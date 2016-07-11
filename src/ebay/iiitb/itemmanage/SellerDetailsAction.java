package ebay.iiitb.itemmanage;
import java.util.Map;
//import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import ebay.iiitb.itemmanage.SellerDetailsModel;
import ebay.iiitb.itemmanage.SellerDetailsService;
import ebay.iiitb.login.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SellerDetailsAction extends ActionSupport implements SessionAware,ModelDriven<SellerDetailsModel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
private SellerDetailsModel sellerdetailsmodel=new SellerDetailsModel();

public SellerDetailsModel getSellerdetailsmodel() {
	return sellerdetailsmodel;
}

public void setSellerdetailsmodel(SellerDetailsModel sellerdetailsmodel) {
	this.sellerdetailsmodel = sellerdetailsmodel;
}





SellerDetailsService sellerdetailsservice=new SellerDetailsService(sellerdetailsmodel);
public String execute()

{	
	System.out.println("In sellerdetails action");

	
	String email=(String) session.get("email");
	
	System.out.println(email);
	
	
	if(sellerdetailsservice.insertdetails(email))
	return SUCCESS;
	else
	return ERROR;
	



	
}
public SellerDetailsModel getModel() {

	return sellerdetailsmodel;
}


@Override
public void setSession(Map<String, Object> map) {
	 //TODO Auto-generated method stub
	this.session=map;
	
}


}
