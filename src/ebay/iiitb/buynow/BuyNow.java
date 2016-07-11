package ebay.iiitb.buynow;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class BuyNow  extends ActionSupport implements SessionAware{
	int i_surkey;
public int getI_surkey() {
		return i_surkey;
	}

	public void setI_surkey(int i_surkey) {
		this.i_surkey = i_surkey;
	}

private Map<String, Object> session;

public String execute(){
	System.out.println("IN buy");
	System.out.println(getI_surkey());
	System.out.println(session.get("email"));
	return SUCCESS;
}

@Override
public void setSession(Map<String, Object> map) {
	
	this.session=map;
}
}
