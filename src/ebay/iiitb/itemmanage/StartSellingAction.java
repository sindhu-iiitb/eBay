package ebay.iiitb.itemmanage;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;
//import org.iiitb.action.LoginAction;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import ebay.iiitb.itemmanage.StartSellingService;
import ebay.iiitb.itemmanage.sessionservice;

public class StartSellingAction implements SessionAware {
	
StartSellingService startsellingservice=new StartSellingService();
private Map<String, Object> session;

	public String execute() throws SQLException
	{ 
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		System.out.println(session.getAttribute("name").toString());
//		sessionservice serv=new sessionservice();
	//	System.out.println(serv.show());
		
		System.out.println("in startsellingaction");
		
		
		String email=(String) session.get("email");
		System.out.println(email);
		if(startsellingservice.validSeller(email))
			{
			System.out.println(email);
			return "success";
			}
		else{
			
			System.out.println("in startselling action-------------not a seller");
			System.out.println(email);
			return "failure";
		}
	}

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		this.session=map;
		
	}
}
