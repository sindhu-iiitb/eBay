package ebay.iiitb.logout;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport implements SessionAware
{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private Map<String,Object> sessionMap=null;  
	
	public String execute()
	{
		System.out.println(sessionMap.get("email"));
		sessionMap.clear();
		message="Logged Out Successfully.";
		return "success";
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSession(Map<String, Object> map)
	{
		this.sessionMap=(SessionMap)map;
	}

}