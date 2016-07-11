package ebay.iiitb.itemmanage;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import ebay.iiitb.itemmanage.sessionservice;

public class Sessioncheck {

	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		sessionservice serv=new sessionservice();
		System.out.println(serv.show());
		System.out.println("in sessioncheck action");
		//System.out.println(l+"in intercept");
		//if(session.getAttribute("name").toString()==null)
		
			String email=session.getAttribute("name").toString();
			System.out.println("user logged in as"+email);
			return "success";
		//return "success";
		
	}
	
	
	
}
