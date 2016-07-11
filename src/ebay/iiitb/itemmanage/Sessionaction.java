package ebay.iiitb.itemmanage;



import java.util.Map;


import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;


public class Sessionaction implements SessionAware{






private Map<String, Object> session;

public String execute() {
	//HttpSession session = ServletActionContext.getRequest().getSession();
	
	System.out.println("in session action");
	//System.out.println(l+"in intercept");
	if(session.keySet().size() != 0)
	{
		String email=(String) session.get("email");
		System.out.println("user logged in as  "+email);
		return "set";
	}
	else
		{
		
		return "notset";
		}
	//return "success";
	
}

@Override
public void setSession(Map<String, Object> map) {
	// TODO Auto-generated method stub
	this.session=map;
	
}



}
