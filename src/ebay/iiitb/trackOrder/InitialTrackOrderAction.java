package ebay.iiitb.trackOrder;

import java.util.HashMap;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class InitialTrackOrderAction extends ActionSupport {
	
	TrackOrderService trackOrderService=new TrackOrderService();
//	UserModel user;
//	UserModel u = new UserModel();
//	private Map<String, Object> session = new HashMap<String, Object>();
	private Map<String, Object> session = ActionContext.getContext()
			.getSession();
//	@Override
//	public void setSession(Map<String, Object> session) {
//		this.u.session = session;
//	}
	public String execute()
	{
		System.out.println("Im in execute of Track");
//		UserModel user = (UserModel) session.get("user");
//		if(user!= null)
//		{
//			System.out.println("Im in iffff");
//			return SUCCESS;
//		}
//		else
//		{
		
		System.out.println("In Track Action class setting");
		
//		u.setFirstname("sirisha");u.setLastname("Chodisetty");u.setEmail("abc@gmail.com");u.setPassword("123");
//		System.out.println(u.getFirstname());
//		session.put("user", u);
		System.out.println(session.get("user"));
		return SUCCESS;
//		}
		
	}

}
